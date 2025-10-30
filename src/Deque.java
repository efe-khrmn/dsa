public class Deque<T> {
    private Node front;
    private Node rear;
    private int size;
    class Node{
        T value;
        Node next;
        Node prev;
        Node(T value){
            this.value = value;
        }
    }
    public Deque(){
        front = null;
        rear = null;
        size = 0;
    }
    public Deque(T value){
        Node newNode = new Node(value);
        size = 1;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void push(T value){
        Node newNode = new Node(value);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        } else {
            newNode.next=front;
            front.prev=newNode;
            front = newNode;
        }
        size++;
    }
    public T pop(){
        if(isEmpty()) throw new RuntimeException("Dequeue is empty");
        else if(size == 1){
            Node temp = front;
            front = null;
            rear = null;
            size--;
            return temp.value;
        }else{
            Node temp= front;
            front.next.prev = null;
            front = front.next;
            size--;
            return temp.value;
        }
    }
    public void inject(T value){
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }
    public T eject(){
        if(isEmpty()) throw new RuntimeException("Dequeue is empty");
        else if(size == 1){
            Node temp = rear;
            front = null;
            rear = null;
            size--;
            return temp.value;
        }else {
            Node temp = rear;
            rear.prev.next = null;
            rear = rear.prev;
            size--;
            return temp.value;
        }
    }

}
class Stack<T> {
    private Deque<T> deque = new Deque<>();
    public void push(T value) {deque.push(value);}
    public T pop() {return deque.pop();}
}
class Queue<T> {
    private Deque<T> deque = new Deque<>();
    public void enqueue(T value) {deque.inject(value);}
    public T dequeue() {return deque.eject();}
}
