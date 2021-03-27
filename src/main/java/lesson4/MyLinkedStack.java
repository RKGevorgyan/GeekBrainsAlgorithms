package lesson4;

public class MyLinkedStack<T> {
    private MyLinkedList<T> ll = new MyLinkedList<>();

    public void push(T item){
        ll.insertFirst(item);
    }

    public T peek(){
        return ll.getFirst();
    }

    public T pop(){
        return ll.removeFirst();
    }

    public int size(){
        return ll.size();
    }

    public boolean isEmpty(){
        return ll.isEmpty();
    }
}
