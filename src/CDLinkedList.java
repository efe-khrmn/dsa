
import java.util.Arrays;
class LLNode
{
    private int element;
    private LLNode nextElement;
    private LLNode prevElement;
    public LLNode(int element)
    {
        this.element = element;
        this.nextElement = null;
        this.prevElement = null;
    }
    public LLNode(int element, LLNode nextElement, LLNode prevElement) {
        this.element = element;
        this.nextElement = nextElement;
        this.prevElement = prevElement;
    }
    public int getElement() {
        return element;
    }
    public void setElement(int element) {
        this.element = element;
    }
    public LLNode getNextElement() {
        return nextElement;
    }
    public void setNextElement(LLNode nextElement) {
        this.nextElement = nextElement;
    }
    public LLNode getPrevElement() {
        return prevElement;
    }
    public void setPrevElement(LLNode prevElement) {
        this.prevElement = prevElement;
    }
}
public class CDLinkedList
{
    private LLNode headNode;
    private LLNode tailNode;
    private int size;
    public CDLinkedList(int headValue, int tailValue) {
        this.headNode = new LLNode(headValue);
        this.tailNode = new LLNode(tailValue);
        initializeLinksAndCircularity();
        this.size = 2;
    }
    public LLNode getHeadNode() {
        return headNode;
    }
    public void setHeadNode(LLNode headNode) {
        this.headNode = headNode;
    }
    public LLNode getTailNode() {
        return tailNode;
    }
    public void setTailNode(LLNode tailNode) {
        this.tailNode = tailNode;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void addElement(int data)
    {
        LLNode newNode = new LLNode(data);

        if (getSize() < 0)
        {
            System.out.println("Illegal size (<0). There must a wrong operation in size calculation.");
            return;
        }
        else if (getSize() == 0 || getSize() == 1)// (this.headNode == null && this.tailNode == null)
        {
            System.out.println("There must be something wrong, since size cannot be 0 or 1 at any time.");
            return;
        }
        else
        {
            getTailNode().setNextElement(newNode);
            newNode.setPrevElement(getTailNode());
            newNode.setNextElement(getHeadNode());
            getHeadNode().setPrevElement(newNode);
            setTailNode(newNode);
            setSize(getSize() + 1);
        }
    }
    public void printCDLL()
    {
        LLNode temp = getHeadNode();
        int increase = String.valueOf(temp.getElement()).length() - 3;
        for (int i = 0; i < getSize(); i++)
        {
            if (temp != getTailNode())
            {
                System.out.print(temp.getElement() + " --> ");
                temp = temp.getNextElement();
                increase = increase + 2 + (String.valueOf(temp.getElement()).length() - 1);
            }
            else
            {
                System.out.println(temp.getElement() + ".");
                if (getTailNode().getNextElement().equals(getHeadNode()))
                    printCircularNextConnection(increase);
                else
                    System.out.println("No circular connection.");
            }
        }
    }
    public void printCDLLBackwards()
    {
        LLNode temp = getTailNode();
        int increase = String.valueOf(temp.getElement()).length() - 3;
        for (int i = getSize(); i > 0; i--)
        {
            if (temp != getHeadNode())
            {
                System.out.print(temp.getElement() + " <-- ");
                temp = temp.getPrevElement();
                increase = increase + 2 + (String.valueOf(temp.getElement()).length() - 1);
            }
            else
            {
                System.out.println(temp.getElement());
                if (getHeadNode().getPrevElement().equals(getTailNode()))
                    printCircularPrevConnection(increase);
                else
                    System.out.println("No circular connection.");
            }
        }
    }
    private void printCircularNextConnection(int increase)
    {
        char[] data = new char[getSize() * 4 + (increase - 1)];
        char c = '-';
        Arrays.fill(data, c);
        data[0] = '^';
        data[data.length - 1] = '|';
        System.out.println(new String(data));
    }
    private void printCircularPrevConnection(int increase)
    {
        char[] data = new char[getSize() * 4 + (increase - 1)];
        char c = '-';
        Arrays.fill(data, c);

        data[0] = '|';
        data[data.length - 1] = '^';
        System.out.println(new String(data));
    }
    // TODO:
    private void initializeLinksAndCircularity()
    {
        getHeadNode().setNextElement(getTailNode());
        getHeadNode().setPrevElement(getTailNode());
        getTailNode().setNextElement(getHeadNode());
        getTailNode().setPrevElement(getHeadNode());
    }
    // TODO:
    public boolean deleteSymmetricElements(int index)
    {
        LLNode prev = getHeadNode();
        LLNode temp = prev.getNextElement();
        LLNode prev2 = getTailNode();
        LLNode temp2 = prev2.getPrevElement();
        for(int i=0;i<index;i++){
            prev = prev.getNextElement();
            temp = temp.getNextElement();
        }
        for(int i=size-1;i>size-1-index;i--){
            prev2 = prev2.getPrevElement();
            temp2 = temp2.getPrevElement();
        }
        if(size>3&&!prev.equals(getHeadNode())&&!prev.equals(getTailNode())&&prev!=null) {
            temp2.setNextElement(prev2.getNextElement());
            prev2.getNextElement().setPrevElement(temp2);
            temp.setPrevElement(prev.getPrevElement());
            prev.getPrevElement().setNextElement(temp);
            size-=2;
        }
        else {
            return false;
        }
        return true;
    }
    // TODO:
    public int getElement(int position, boolean isForward)
    {
        if(isForward&&position>=0){
            LLNode temp = getHeadNode();
            for (int i=0;i<position;i++){
                temp = temp.getNextElement();
            }
            return temp.getElement();
        }
        else if(!isForward&&position>=0){
            LLNode temp = getTailNode();
            for(int i=0;i<position;i++){
                temp=temp.getPrevElement();
            }
            return temp.getElement();
        }
        return -1;
    }
    public static void main(String[] args){
        CDLinkedList cdll = new CDLinkedList(10, 20);
        cdll.addElement(30);
        cdll.addElement(40);
        cdll.addElement(50);
        cdll.printCDLL();
        cdll.printCDLLBackwards();
        System.out.println("Element at position 2 (forward): " + cdll.getElement(2, true));
        System.out.println("Element at position 1 (backward): " + cdll.getElement(1, false));
        cdll.deleteSymmetricElements(1);
        cdll.printCDLL();
    }
}


