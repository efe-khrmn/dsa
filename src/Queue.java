import java.util.ArrayList;

public class Queue {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
class QueueWithCircularArray<T>{
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

}
class QueueWithSinglyLinkedList {}
