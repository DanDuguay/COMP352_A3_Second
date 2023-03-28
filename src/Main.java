public class Main
{
    public static void main(String[] args)
    {
       HeapAdaptablePriorityQueue heapAPQ = new HeapAdaptablePriorityQueue();
       heapAPQ.insert(0, "A");
       heapAPQ.insert(25, "B");
       heapAPQ.insert(2, "C");
       heapAPQ.insert(5, "D");
       heapAPQ.toString();
       System.out.println("=====================================");
       heapAPQ.remove(heapAPQ.heap[2]);
       heapAPQ.toString();
       System.out.println("=====================================");
       heapAPQ.removeMin();
       heapAPQ.toString();
    }
}