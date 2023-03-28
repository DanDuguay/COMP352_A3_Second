import java.util.Comparator;

public abstract class AbstractPriorityQueue implements IPriorityQueue
{
    protected static class PQEntry implements IEntry
    {
        private int k;
        private String v;
        public PQEntry(int key, String value)
        {
            this.k = key;
            this.v = value;
        }

        public int getKey() { return k;}
        public String getValue() { return v;}
        protected void setKey(int key) {k = key;}
        protected void setValue(String value) {v = value;}
    }

    private Comparator<Integer> comp;
    protected AbstractPriorityQueue(Comparator<Integer> c) {comp = c;}
    protected AbstractPriorityQueue() { this( new DefaultComparator());}
    protected int compare(IEntry a, IEntry b)
    {
        return comp.compare(a.getKey(),b.getKey());
    }
    protected int compare(IEntry a, IEntry b, boolean isMinHeap)
    {
        return comp.compare(a.getKey(),b.getKey());
    }
    protected boolean checkKey(int key) throws IllegalArgumentException
    {
        try{
            return (comp.compare(key,key)==0);
        } catch (ClassCastException e){
            throw new IllegalArgumentException("Incompatible key");
        }
    }
    public boolean isEmpty() { return getLastElement() == -1;}
}
