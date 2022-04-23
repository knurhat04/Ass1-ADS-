public class MyQueue<T> {
    private MyLinkedList<T> x = new MyLinkedList<>();
    private static class MyNode<T>{
        T data;
    }
    MyNode<T> front, back;
    public boolean empty() {
        return front = back = null;
    }
    public int size() {
        return x.size();
    }
    public T peek() {
        if (!empty()) {
            return x.get(size()-1);
        }
    }

    public T enqueue(T item){
        x.add(size()-1, item);
    }

    public T dequeue(){
        return x.remove(front.data);
    }

}
