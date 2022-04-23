public class MyStack<T> {
    private MyLinkedList<T> x = new MyLinkedList<>();

    public int size() {
        return x.size();
    }
    public boolean empty() {
        return (size() == 0);
    }


    public T peek() {
        if (!empty())
            return x.get(size()-1);
        else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    public void push(T item) {
        x.add(item);

    }

    public T pop() {
        if (empty()) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return x.remove(size()-1);
        }
    }

}
