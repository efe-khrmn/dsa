import java.util.ArrayList;

public class Queue {

    public static void main(String[] args) {

        QueueWithCircularArray<Integer> queueArray = new QueueWithCircularArray<>(5);
        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.printQueue();
        System.out.println("Dequeued from circular array queue: " + queueArray.dequeue());
        System.out.println("Dequeued from circular array queue: " + queueArray.dequeue());
        queueArray.printQueue();

        QueueWithSinglyLinkedList<Integer> queueList = new QueueWithSinglyLinkedList<>();
        queueList.enqueue(1);
        queueList.enqueue(2);
        queueList.enqueue(3);
        queueList.printQueue();
        System.out.println("Dequeued from linked list queue: " + queueList.dequeue());
        System.out.println("Dequeued from linked list queue: " + queueList.dequeue());
        queueList.printQueue();
    }
}
class QueueWithCircularArray<T> extends Queue{
    private ArrayList<T> data;
    private int front, rear, capacity;

    public QueueWithCircularArray(int size){
        capacity = size;
        front = 0;
        rear = 0;
        data = new ArrayList<T>(size);
    }
    public boolean isEmpty(){
        return front == rear;
    }
    public boolean isFull(){
        return (rear + 1) % capacity == front;
    }
    public void enqueue(T datum){
        if(!isFull()){
            if(data.size() < capacity){
                data.add(datum);
            } else {
                data.set(rear, datum);
            }
            rear = (rear + 1) % capacity;
        }
    }
    public T dequeue(){
        if(!isEmpty()){
            T datum = data.get(front);
            front = (front + 1) % capacity;
            return datum;
        }
        return null;
    }
    public void printQueue(){
        for(int i = front; i != rear; i = (i + 1) % capacity){
            System.out.print(data.get(i) + " ");
        }
        System.out.println();
    }

}
class QueueWithSinglyLinkedList<T> extends Queue {
    //this is O(n) implementation of enqueue using singly linked list with respect to given task requirements
    //it can be optimized to O(1) by maintaining a rear pointer
    private Node front;
    private int size;
    class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
        }
    }
    public QueueWithSinglyLinkedList() {
        front = null;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void enqueue(T data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front = newNode;
        } else{
            Node cursor = front;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = newNode;
        }
        size++;
    }
    public T dequeue(){
        if(!isEmpty()){
            Node temp = front;
            front = front.next;
            temp.next = null;
            size--;
            return (T) temp.data;
        }
        return null;
    }
    public void printQueue(){
        Node cursor = front;
        while(cursor != null){
            System.out.print(cursor.data + " ");
            cursor = cursor.next;
        }
        System.out.println();
    }
}
