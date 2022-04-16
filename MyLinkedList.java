public class MyLinkedList<T> implements MyList{
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void add(int index, T item)  {
        MyNode<T> newNode = new MyNode<>(item);
        int count = 0;
        MyNode<T> current = head;
        while (count != index){
            current = current.next;
            count++;
        }
        MyNode<T> prevNode = current.prev;
        prevNode.next = newNode;
        newNode.next = current;
        length++;
    }

    public boolean contains(T item)  {
        MyNode<T> current = head;
        while (current.next != null){
            if(current.data.equals(o)){
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    public T remove(int index)  {
        MyNode<T> current = head;
        int count = 0;
        while (current.next != null){
            if(count == index){
                if(current.prev == null){
                    removeFirst();
                    break;
                }
                else if(current.next == null){
                    removeLast();
                    break;
                }
                else{
                    MyNode<T> prevNode = current.prev;
                    MyNode<T> nextNode = current.next;
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                    break;
                }
            }
            current = current.next;
            count++;
        }

        length--;
        return (T)current.data;
    }

    public boolean remove(T item) {
        boolean flag = true;
        MyNode<T> current = head;
        if(current.next == null){
            removeLast();
        }
        while (current.next != null){
            if(current.data.equals(item)){
                if(current.prev == null){
                    removeFirst();
                    flag = false;
                }
                else {
                    MyNode<T> prevNode = current.prev;
                    MyNode<T> nextNode = current.next;
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                    flag = false;
                    length--;
                    break;
                }
            }
            current = current.next;
        }

        return flag;
    }

    public int size() {
        return length;
    }

    public void clear()  {
        head = tail = null;
        head.next = head.prev = null;
        tail.next = tail.prev = null;
        length = 0;
    }

    public int indexOf(T item) {
        MyNode<T> current = head;
        int index = -1;
        int count = 0;
        while (current != null){
            if(current.data.equals(item)){
                index = count;
                break;
            }
            current = current.next;
            count++;
        }
        if(index == -1){
            System.out.println("There is no such "+item.getClass().getSimpleName());
        }
        return index;
    }

    public int lastIndexOf(T item) {
        MyNode<T> current = head;
        int index = -1;
        int count = 0;
        while (current != null){
            if(current.data.equals(item)){
                index = count;
            }
            current = current.next;
            count++;
        }
        if(index == -1){
            System.out.println("There is no such "+item.getClass().getSimpleName());
        }
        return index;
    }
}
