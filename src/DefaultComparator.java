import java.util.Comparator;

public class DefaultComparator implements Comparator<Integer>
{

    public int compare(Integer a, Integer b, boolean isMinHeap) throws ClassCastException
    {
        if (!isMinHeap)
            return ((Comparable<Integer>)a).compareTo(b);
        return ((Comparable<Integer>)a).compareTo(b)*-1;
    }
    public int compare(Integer a, Integer b) throws ClassCastException
    {
        return ((Comparable<Integer>)a).compareTo(b);
    }
}