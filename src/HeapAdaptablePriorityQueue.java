import java.util.Comparator;

public class HeapAdaptablePriorityQueue extends HeapPriorityQueue
{
    protected static class AdaptablePQEntry extends PQEntry
    {
        private int index;
        public AdaptablePQEntry(int key, String value, int j)
        {
            super(key, value);
            index = j;
        }
        public int getIndex() { return index;}
        public void setIndex(int j) { index = j;}
        @Override
        public String toString()
        {
            return "( " + this.getKey() + ", " + this.getValue() + ", "+ this.getIndex()+ " )";
        }
    }

    public HeapAdaptablePriorityQueue() { super();}
    public HeapAdaptablePriorityQueue(Comparator<Integer> comp) { super(comp);}
    protected AdaptablePQEntry validate(IEntry entry) throws IllegalArgumentException
    {
        if (!(entry instanceof AdaptablePQEntry))
            throw new IllegalArgumentException("Invalid entry");
        AdaptablePQEntry locator = (AdaptablePQEntry) entry;
        int j = locator.getIndex();
        if (j >= getLastElement() || heap[j] != locator)
            throw new IllegalArgumentException("Invalid entry");
        return locator;
    }

    /**
     * This function is used to determine if the heap is Min or Max.
     * @return A string describing the state of the heap.
     */
    protected String getState()
    {
        if (isMinHeap)
            return "Current State: minHeap";
        return "Current State: maxHeap";
    }

    /**
     * toggles the heap from Min to Max or vice-versa. Heapify's the heap into the new state.
     */
    protected void toggle()
    {
        isMinHeap = !isMinHeap;
        heapify();
    }

    /**
     * Swap two entries in the heap. Also adjusts the index after the swap.
     * @param i The index of the first entry.
     * @param j The index of the second entry.
     */
    protected void swap(int i, int j)
    {
        super.swap(i,j);
        ((AdaptablePQEntry) heap[i]).setIndex(i);
        ((AdaptablePQEntry) heap[j]).setIndex(j);
    }

    /**
     * Determines if a upheap or downheap would be more efficient.
     * @param j the index of the entry to downheap/upheap.
     */
    protected void bubble(int j)
    {
        if (j > 0 && compare(heap[j], heap[parent(j)], isMinHeap) < 0)
            upheap(j);
        else
            downheap(j);
    }

    /**
     * Inserts a new entry into the queue
     * @param key The key of the entry
     * @param value The value of the entry
     * @return the entry created and inserted.
     * @throws IllegalArgumentException if the key or value is of the wrong type
     */
    public IEntry insert(int key, String value) throws IllegalArgumentException
    {
        if (isFull())
            heap = increaseHeapSize();
        checkKey(key);
        lastElement++;
        IEntry newest = new AdaptablePQEntry(key,value,getLastElement());
        heap[lastElement] = newest;
        upheap(lastElement);
        return newest;
    }

    /**
     * Removes the entry form the heap.
     * @param entry the entry to remove.
     * @return the removed entry
     * @throws IllegalArgumentException if the entry is invalid.
     */
    public IEntry remove(IEntry entry) throws IllegalArgumentException
    {
        AdaptablePQEntry locator = validate(entry);
        int j = locator.getIndex();
        IEntry tempEntry;
        if (j == getLastElement())
        {
            tempEntry = heap[lastElement];
            heap[lastElement] = null;
            lastElement--;
        }
        else
        {
            swap(j,lastElement);
            tempEntry = heap[lastElement];
            heap[lastElement] = null;
            lastElement--;
            bubble(j);
        }
        return tempEntry;
    }

    /**
     * Uses the remove() method on the first index of the heap.
     * @return returns the removed entry.
     */
    public IEntry removeTop()
    {
        return remove(heap[0]);
    }

    /**
     * Replace the key of an entry and reajusts the heap order if necessary
     * @param entry the entry to locate and modify
     * @param key the new key value.
     * @throws IllegalArgumentException if the entry or key are invalid
     */
    public void replaceKey(IEntry entry, int key) throws IllegalArgumentException
    {
        AdaptablePQEntry locator = validate(entry);
        checkKey(key);
        locator.setKey(key);
        bubble(locator.getIndex());
    }

    /**
     * Replace the value of an entry.
     * @param entry the entry to locate and modify
     * @param value the new value
     * @throws IllegalArgumentException if the entry is invalid
     */
    public void replaceValue(IEntry entry, String value) throws  IllegalArgumentException
    {
        AdaptablePQEntry locator = validate(entry);
        locator.setValue(value);
    }


    @Override
    public String toString()
    {
        for (int i = 0; i <= lastElement;i++)
        {
            System.out.println(heap[i].toString());
        }
        return null;
    }
}
