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
            return String.valueOf(index);
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
    protected void swap(int i, int j)
    {
        super.swap(i,j);
        ((AdaptablePQEntry) heap[i]).setIndex(i);
        ((AdaptablePQEntry) heap[j]).setIndex(j);
    }

    protected void bubble(int j)
    {
        if (j > 0 && compare(heap[j], heap[parent(j)], isMinHeap) < 0)
            upheap(j);
        else
            downheap(j);
    }

    public IEntry insert(int key, String value) throws IllegalArgumentException
    {
        checkKey(key);
        lastElement++;
        IEntry newest = new AdaptablePQEntry(key,value,getLastElement());
        heap[lastElement] = newest;
        upheap(lastElement);
        return newest;
    }

    public void remove(IEntry entry) throws IllegalArgumentException
    {
        AdaptablePQEntry locator = validate(entry);
        int j = locator.getIndex();
        if (j == getLastElement())
        {
            heap[lastElement] = null;
            lastElement--;
        }
        else
        {
            swap(j,lastElement);
            heap[lastElement] = null;
            lastElement--;
            bubble(j);
        }
    }
    public void replaceKey(IEntry entry, int key) throws IllegalArgumentException
    {
        AdaptablePQEntry locator = validate(entry);
        checkKey(key);
        locator.setKey(key);
        bubble(locator.getIndex());
    }

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
            System.out.println("( " + heap[i].getKey() + ", " + heap[i].getValue() + ", "+ heap[i].toString()+ " )");
        }
        return null;
    }
}
