import java.util.Comparator;

public class HeapPriorityQueue extends AbstractPriorityQueue
{
    protected IEntry[] heap;
    protected int size;
    protected int lastElement;
    protected boolean isMinHeap;
    public HeapPriorityQueue()
    {
        super();
        this.size = 5;
        heap = new IEntry[size];
        this.lastElement = -1;
        this.isMinHeap = true;
    }
    public HeapPriorityQueue(Comparator<Integer> comp) {super(comp);}
    protected int parent(int j) { return (j-1)/2;}
    protected int left(int j) { return 2*j+1;}
    protected int right(int j) { return 2*j+2;}
    protected boolean hasLeft(int j) { return left(j) <= getLastElement();}
    protected boolean hasRight(int j) { return right(j) <= getLastElement();}
    protected boolean isFull() { return (size-1 == lastElement);}

    protected IEntry[] increaseHeapSize()
    {
        size *= size;
        IEntry[] newHeap = new IEntry[size];
        for (int i = 0; i < heap.length; i++)
        {
            newHeap[i] = heap[i];
        }
        return newHeap;
    }
    protected void swap (int i, int j)
    {
        IEntry temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    protected void upheap(int j)
    {
        while (j > 0)
        {
            int p = parent(j);
            if (compare(heap[j], heap[p], isMinHeap)<=0) break;
            swap(j,p);
            j = p;
        }
    }
    protected void downheap(int j)
    {
        //System.out.println(j);
        //System.out.println("Left(j) = " +left(j));
        //System.out.println(hasLeft(j));
        //System.out.println("Last Element: " + getLastElement());
        while(hasLeft(j))
        {
            //System.out.println("Entered downheap loop.");
            int leftIndex = left(j);
            int childToSwapIndex = leftIndex;
            //System.out.println("right(j) = " + right(j));
            //System.out.println(hasRight(j));
            if (hasRight(j))
            {
                int rightIndex = right(j);
                if (compare(heap[leftIndex], heap[rightIndex], isMinHeap)<0)
                    childToSwapIndex = rightIndex;
            }
            if (compare(heap[childToSwapIndex], heap[j], isMinHeap) <=0) break;
            swap(j,childToSwapIndex);
            j = childToSwapIndex;
        }
    }

    protected void heapify()
    {
        int startIndex = parent(lastElement);
        for (int j = startIndex; j >= 0; j--)
            downheap(j);
    }
    public int getLastElement() { return lastElement;}
    public int getNumberOfElements() { return lastElement+1;}

    public int getSize() { return heap.length;}
    public IEntry top()
    {
        if (isEmpty()) return null;
        return heap[0];
    }
    public IEntry insert(int key, String value) throws IllegalArgumentException
    {
        if (isFull())
            heap = increaseHeapSize();
        checkKey(key);
        IEntry newest = new PQEntry(key, value);
        lastElement++;
        heap[lastElement] = newest;
        upheap(lastElement);
        return newest;
    }
    public IEntry removeTop()
    {
        if(isEmpty()) return null;
        IEntry answer = heap[0];
        swap(0, getLastElement());
        heap[lastElement]= null;
        lastElement--;
        downheap(0);
        return answer;
    }

}
