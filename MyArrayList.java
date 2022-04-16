public class MyArrayList<T> implements MyList  {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }


    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }
    public void add(int index, T item)  {
         increaseCapacity();
    for (int i = length -   1   ; i >= index; i++)
        arr[i + 1] = arr[i];
        arr[index] = item;
    }

    public boolean contains(T item)  {
        for (int i = 0; i < length; i++)
            if   (item.equals(arr[i]))
                return true;
        return false ;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        return (T)arr[index];
    }

    public int size() {
        return length;
    }

    public int indexOf(T item)  {
        for (int i = 0; i < length; i++)
            if   (item.equals(arr[i]))
                return   i;
        return -1;
    }

    public int lastIndexOf(T item)  {
        for   (int   i = length -   1   ; i >= length; i--)
            if (item.equals(arr[i]))
                return i;
        return -1;
    }

    public void clear()  {
        arr = new Object[3];
    }

    public T remove(int index)  {
        T item = arr[index];
        for   (int j = index; j < length - 1; j++)
            arr[j] = arr[j + 1];
            length--;
            return item;
    }

    public boolean remove(T item) {
        if(contains(item)==true){
            remove(indexOf(item));
            return true;
        }else{
            return false;
        }

    }

}
