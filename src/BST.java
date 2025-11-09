import org.w3c.dom.Node;
import java.util.ArrayList;
class BinaryNode
{
    Integer value;
    BinaryNode leftNode;
    BinaryNode rightNode;
    public BinaryNode(Integer value)
    {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
    public BinaryNode(Integer value, BinaryNode leftNode, BinaryNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public BinaryNode getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }
    public BinaryNode getRightNode() {
        return rightNode;
    }
    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }
}
public class BST
{
    private BinaryNode rootNode;
    /** Constructors **/
    public BST() {
        this.rootNode = null;
    }
    public BST(BinaryNode rootNode) {
        this.rootNode = rootNode;
    }
    /** Setters & getters **/
    public BinaryNode getRootNode() {
        return rootNode;
    }
    public void setRootNode(BinaryNode rootNode) {
        this.rootNode = rootNode;
    }
    /** Given member methods **/
    public void insert(Integer x)
    {
        if (x >= 0)
            setRootNode(insert(getRootNode(), x));
    }
    // private helper method for public insert method
    private BinaryNode insert(BinaryNode rootNode, Integer x)
    {
// if the root is null, create a new node and return it
        if (rootNode == null) {
            return new BinaryNode(x);
        }
// if given key is less than the root node, recur for left subtree



        if (x < rootNode.getValue())
        {
            rootNode.setLeftNode(insert(rootNode.getLeftNode(), x));
        }
// else, recur for right subtree
        else {
// key >= root.data
            rootNode.setRightNode(insert(rootNode.getRightNode(), x));
        }
        return rootNode;
    }
    public void printTreeInorder(BinaryNode nodeToRecur)
    {
        if (nodeToRecur == null) {
            return;
        }
        printTreeInorder(nodeToRecur.getLeftNode());
        System.out.print(nodeToRecur.getValue() + " ");
        printTreeInorder(nodeToRecur.getRightNode());
    }
    // TODO: converts BST into an inorder traversed arraylist
    protected ArrayList<Integer> toInorderList(BinaryNode parent, ArrayList<Integer> list)
    {
        if (parent != null) {
            toInorderList(parent.leftNode, list);
            list.add(parent.value);
            toInorderList(parent.rightNode, list);
        }
        return list;
    }
    // TODO: duplicate the subtree under element x from BST, return new duplicated BST
    public BST duplicateSubtree(BinaryNode root, Integer x) {
        if (root == null) return new BST(null);

        BinaryNode temp = rootNode;
        while (temp != null) {
            if (x < temp.value) temp = temp.leftNode;
            else if (x > temp.value) temp = temp.rightNode;
            else break;
        }

        if (temp == null) return new BST(null);

        BinaryNode newNode = new BinaryNode(temp.value);
        if (temp.leftNode != null)
            newNode.leftNode = duplicateSubtree(temp.leftNode, temp.leftNode.value).getRootNode();
        if (temp.rightNode != null)
            newNode.rightNode = duplicateSubtree(temp.rightNode, temp.rightNode.value).getRootNode();

        return new BST(newNode);
    }
    // TODO: check if any BST holds BST properties
    public Boolean isBST()
    {
        ArrayList<Integer> stack = toInorderList(getRootNode(), new ArrayList<Integer>());
        for (int i =1; i<stack.size(); i++){
            if (stack.get(i)<=stack.get(i-1)){
                return false;
            }
        }
        return true;
    }
    // TODO: finds maximum value in BST
    public Integer findMax() {
        if (getRootNode() != null) {
            BinaryNode temp = getRootNode();
            while (temp.getRightNode() != null) {
                temp = temp.rightNode;
            }
            return temp.getValue();
        }
        return -1;
    }}