public class Entry
{
    int key;
    String value;
    int index;

    public Entry(int key, String value)
    {
        this.key = key;
        this.value = value;
        this.index = 0;
    }
    public Entry(int key, String value, int j)
    {
        this.key = key;
        this.value = value;
        this.index = j;
    }

    public int getIndex() {
        return index;
    }

    public int getKey() {
        return key;
    }
    public String getValue()
    {
        return value;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
