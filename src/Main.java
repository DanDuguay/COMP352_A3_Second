public class Main
{
    public static void main(String[] args)
    {
       HeapAdaptablePriorityQueue heapAPQ = new HeapAdaptablePriorityQueue();

       System.out.println("=====================================");
       System.out.println(heapAPQ.getState());
       System.out.println("\nTesting Insertion and dynamic resizing of heap.");
       System.out.println("Starting size of heap: " + heapAPQ.size);
       System.out.println("Inserting 7 elements into heapAPQ.\n");
       heapAPQ.insert(0, "A");
       heapAPQ.insert(25, "B");
       heapAPQ.insert(2, "C");
       heapAPQ.insert(5, "D");
       heapAPQ.insert(7, "F");
       heapAPQ.insert(29, "G");
       heapAPQ.insert(9, "H");
       heapAPQ.toString();
       System.out.println("\nCurrent size of heapAPQ: " + heapAPQ.size);

       System.out.println("=====================================");
       System.out.println("\nTesting remove(heapAPQ.heap[2])\n");
       heapAPQ.remove(heapAPQ.heap[2]);
       heapAPQ.toString();

       System.out.println("=====================================");
       System.out.println("\nTesting removeTop()\n");
       heapAPQ.removeTop();
       heapAPQ.toString();

       System.out.println("=====================================");
       System.out.println("\nInserting 5 more elements into heapAPQ.\n");
       heapAPQ.insert(1, "E");
       heapAPQ.insert(84, "K");
       heapAPQ.insert(1, "I");
       heapAPQ.insert(10, "M");
       heapAPQ.insert(1, "L");
       heapAPQ.toString();

       System.out.println("=====================================");
       System.out.println("\nTesting replaceKey(heapAPQ.heap[0],99)\n");
       heapAPQ.replaceKey(heapAPQ.heap[0], 99 );
       heapAPQ.toString();

       System.out.println("=====================================");
       System.out.println("\nTesting replaceValue(heap[1],\"F\")\n");
       heapAPQ.replaceValue(heapAPQ.heap[1],"F");
       heapAPQ.toString();

       System.out.println("=====================================");
       System.out.println("\nTesting toggle()");

       System.out.println(heapAPQ.getState() + "\n");
       heapAPQ.toString();
       System.out.println("\nToggling");
       heapAPQ.toggle();
       System.out.println((heapAPQ.getState()) + "\n");
       heapAPQ.toString();
       System.out.println("\nToggling");
       heapAPQ.toggle();
       System.out.println(heapAPQ.getState() + "\n");
       heapAPQ.toString();

       System.out.println("=====================================");
       System.out.println("\nTesting top()\n");
       System.out.println(heapAPQ.top().toString());

       System.out.println("=====================================");
       System.out.println("\nTesting getNumberOfElements()");
       System.out.println("Number of elements: " + heapAPQ.getNumberOfElements() + "\n");

       System.out.println("=====================================");
       System.out.println("\nTesting isEmpty()");
       System.out.println(heapAPQ.isEmpty());

    }
}