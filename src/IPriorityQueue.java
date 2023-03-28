public interface IPriorityQueue
{
    int getLastElement();
    int getSize();
    boolean isEmpty();
    IEntry insert(int key, String value) throws IllegalArgumentException;
    IEntry top();
    IEntry removeTop();
}
