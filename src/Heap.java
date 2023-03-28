public class Heap
{
    public Entry[] eArray;
    int size;
    int lastElement;

    public boolean isMinHeap;

    public Heap()
    {
        this.size = 5;
        this.isMinHeap = true;
        this.lastElement = -1;
        this.eArray = new Entry[size];
    }

    public Heap(int size)
    {
        this.size = size;
        this.isMinHeap = true;
        this.lastElement = -1;
        this.eArray = new Entry[size];
    }

    public boolean isFull() { return (size-1 == lastElement);}
    public boolean isEmpty() { return (lastElement == -1);}

    protected int parent(int j) {return (j-1)/2;}
    protected int left(int j) { return 2*j+1;}
    protected int right(int j) { return 2*j+2;}
    protected boolean hasLeft(int j) { return left(j) < lastElement;}
    protected boolean hasRight(int j) { return right(j) < lastElement;}

    protected void swap(int i, int j)
    {
        Entry temp = eArray[i];
        eArray[i] = eArray[j];
        eArray[j] = temp;
    }

    protected void upheap(int j)
    {
        while (j > 0)
        {
            int p = parent(j);
            if (heapComparator(eArray[j], eArray[p], isMinHeap) >= 0) break;
            swap(j,p);
            j = p;
        }
    }

    protected void downheap(int j)
    {
        while (hasLeft(j))
        {
            int leftIndex = left(j);
            int childToSwapIndex = leftIndex;
            if (hasRight(j))
            {
                int rightIndex = right(j);
                if (heapComparator(eArray[leftIndex], eArray[rightIndex], isMinHeap) >= 0) break;
                swap(j, childToSwapIndex);
                j = childToSwapIndex;
            }
        }
    }

    public int size() { return lastElement;}

    public Entry min()
    {
        return eArray[0];
    }

    public Entry[] increaseHeapSize()
    {
        size *= size;
        Entry[] newHeap = new Entry[size];
        for (int i = 0; i < lastElement; i++)
        {
            newHeap[i] = eArray[i];
        }
        return newHeap;
    }

    public Entry insert(int key, String value)
    {
        if(isFull())
            eArray = increaseHeapSize();
        lastElement++;
        Entry newest = new Entry(key, value);
        eArray[lastElement] = newest;
        upheap(lastElement);
        return newest;
    }

    public Entry removeMin()
    {
        if (isEmpty()) return null;
        Entry answer = eArray[0];
        swap(0, lastElement);
        eArray[lastElement] = null;
        lastElement--;
        downheap(0);
        return answer;
    }

    public int heapComparator(Entry e1, Entry e2, boolean isMinHeap)
    {
        int key1 = e1.getKey();
        int key2 = e2.getKey();

        if (isMinHeap)
        {
            if(key1 > key2)
                return 1;
            if (key1 == key2)
                return 0;

            return -1;
        }
        else
        {
            if (key1 > key2)
                return -1;
            if (key1 == key2)
                return 0;

            return 1;
        }
    }
}
