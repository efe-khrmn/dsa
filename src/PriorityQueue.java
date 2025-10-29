
class Node{
    int priority;
    String name;
    Node next;
    public Node(int priority, String name){
        this.priority = priority;
        this.name = name;
    }
    public Node(int priority, String name, Node next){
        this.priority = priority;
        this.name = name;
        this.next = next;
    }
    // Getters & Setters
    public int getPriority(){
        return this.priority;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Node getNext(){
        return this.next;
    }
    public void setNext(Node next){
        this.next = next;
    }
}
public class PriorityQueue {
    Node headNode;
    int size;
    public PriorityQueue(){
        headNode = null;
        size = 0;
    }
    // Getters & Setters
    public Node getHeadNode(){
        return headNode;
    }
    public void setHeadNode(Node newHeadNode){
        headNode = newHeadNode;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int newSize){
        size = newSize;
    }
    public void printQueue(){
        System.out.print("Size of the queue is: " + getSize() + "\n");
        Node cursor = getHeadNode();
        System.out.print("[headNode] ---> ");
        while(cursor != null){
            System.out.print("[" + cursor.getPriority() + ", " + cursor.getName() + "] ---> ");
            cursor = cursor.getNext();

        }
        System.out.print("NULL");
        System.out.println("\n\n");
    }
    // TODO:
    public boolean enqueue(int priority, String name){
        Node newNode = new Node(priority, name);

        // Case 1: empty queue
        if (headNode == null) {
            headNode = newNode;
        }
        // Case 2: new node has higher priority than head
        else if (priority < headNode.getPriority()) {
            newNode.setNext(headNode);
            headNode = newNode;
        }
        // Case 3: insert somewhere in the middle or end
        else {
            Node temp = headNode;
            while (temp.getNext() != null && temp.getNext().getPriority() <= priority) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }

        size++;
        return true;
    }
    // TODO:
    public String dequeue(){
        if(getSize()<1||getHeadNode()==null)return "E";
        Node temp = getHeadNode();
        setHeadNode(getHeadNode().next);
        size--;
        return temp.getName();
    }
    // TODO:
    public int findPlace(String name){
        Node temp = headNode;
        int index = 0;
        while(temp!=null&&temp.next!=null) {
            if (temp.getName().equals(name)) {
                return index;
            }
            temp = temp.next;
            index++;

        }
        return -1;
    }
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(5, "Task1");
        pq.enqueue(3, "Task2");
        pq.enqueue(8, "Task3");
        pq.enqueue(1, "Task4");
        pq.printQueue();

        System.out.println("Dequeued: " + pq.dequeue());
        pq.printQueue();

        System.out.println("Index of Task2: " + pq.findPlace("Task2"));
        System.out.println("Index of Task5: " + pq.findPlace("Task5"));
    }

}



