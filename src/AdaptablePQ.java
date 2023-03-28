public class AdaptablePQ  extends Heap
{
    Heap heap = new Heap();
    protected Entry validate(Entry entry) throws IllegalArgumentException
    {
        if (entry != null)
        {
            int j = entry.index;
            if (j>= heap.lastElement || heap.eArray[j] != entry)
                throw new IllegalArgumentException("Invalid Entry");
            return entry;
        }
        throw new IllegalArgumentException("Null Entry");
    }

    protected void swap (int i, int j)
    {
        heap.swap(i,j);
        heap.eArray[i].index = i;
        heap.eArray[j].index = j;
    }

    protected void bubble(int j)
    {
        if (j > 0 && heapComparator(heap.eArray[j], heap.eArray[parent(j)], heap.isMinHeap) < 0)
            upheap(j);
        else
            downheap(j);
    }

    public Entry insert(int key, String value)
    {
        if(heap.isFull())
            heap.increaseHeapSize();
        heap.lastElement++;
        System.out.println(heap.lastElement);
        Entry newest = new Entry(key, value, heap.lastElement);
        heap.eArray[heap.lastElement] = newest;
        heap.upheap(heap.lastElement);
        return newest;
    }

    public void remove(Entry entry) throws IllegalArgumentException
    {
        entry = validate(entry);
        int j = entry.index;
        if(j == heap.lastElement)
        {
            heap.eArray[lastElement] = null;
            heap.lastElement--;
        }
        else
        {
            swap(j, heap.lastElement);
            heap.eArray[lastElement] = null;
            heap.lastElement--;
            bubble(j);
        }
    }

    public void removeTop()
    {
        swap(0, heap.lastElement);
        heap.eArray[lastElement] = null;
        heap.lastElement--;
        bubble(0);
    }

    public Entry top()
    {
        return heap.eArray[0];
    }

    public boolean isEmpty()
    {
        return heap.isEmpty();
    }

    public void replaceKey( Entry entry, int key) throws IllegalArgumentException
    {
        entry = validate(entry);
        entry.setKey(key);
        bubble(entry.getIndex());
    }

    public String state()
    {
        if (heap.isMinHeap)
            return "Current State: minHeap";
        else
            return "Current State: maxHeap";
    }

    protected Entry[] heapify()
    {
        Heap tempHeap = new Heap(heap.size);
        for (int i = 0; i <= heap.lastElement; i++)
        {
            tempHeap.insert(heap.eArray[i].getKey(), heap.eArray[i].getValue());
        }
        return tempHeap.eArray;
    }

    public void toggle()
    {
        heap.isMinHeap = !heap.isMinHeap;
        heap.eArray = heapify();
    }

    public void replaceValue(Entry entry, String value) throws IllegalArgumentException
    {
        entry = validate(entry);
        entry.setValue(value);
    }

    public String toString()
    {
        for (int i = 0; i <= heap.lastElement;i++)
        {
            System.out.println("Key: " + heap.eArray[i].getKey() + "\nValue: " + heap.eArray[i].getValue() + "\nIndex: " + heap.eArray[i].getIndex() + "\n");
        }
        return null;
    }

}
