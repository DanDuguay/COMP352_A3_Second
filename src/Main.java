public class Main
{
    public static void main(String[] args)
    {
        AdaptablePQ adaptablePQ = new AdaptablePQ();

        Entry e1 = new Entry(4, "A");
        Entry e2 = new Entry(1, "B");
        Entry e3 = new Entry(25, "C");
        Entry e4 = new Entry(23, "D");
        Entry e5 = new Entry(45, "E");
        Entry e6 = new Entry(3, "E");
        Entry e7 = new Entry(985, "F");

        adaptablePQ.insert(4, "A");
        adaptablePQ.insert(1, "B");
        adaptablePQ.insert(25,"C");
        adaptablePQ.insert(23, "D");
        adaptablePQ.insert(45, "E");

        adaptablePQ.toString();
        adaptablePQ.toggle();
        adaptablePQ.toString();
    }
}