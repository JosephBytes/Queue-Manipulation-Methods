package queues;
import dsa3.EmptyCollectionException;
import dsa3.InvalidArgumentException;
import dsa3.LinearNode;
import java.util.*;

/**
 * class QueueMethods provides necessary Queue methods.
 * @author Joseph Abdulwahab
 * @version 3/14/2024
 * @param <T> a generic parameter.
 */
public class QueueMethods<T> implements QueueMethodsADT<T> {
    /** The front node of the queue. */
    protected LinearNode<T> front;
    
    /** The back node of the queue. */
    protected LinearNode<T> back;
    
    /** ArrayList containing the first 3 nodes in the queue. */
    protected ArrayList<LinearNode<T>> frontThreeNodes;
    
    /** ArrayList containing the first 3 elements in the queue. */
    protected ArrayList<T> frontThreeElements;
    
    /** The number of nodes currently in the queue. */
    protected int numNodes;
    
    /**
     * Constructor- Initializes frontThree ArrayLists.
     */
    protected QueueMethods() { 
        frontThreeNodes = new ArrayList();
        frontThreeElements = new ArrayList();
    }

    @Override
    public T dequeue(int x) throws EmptyCollectionException, InvalidArgumentException {
        if (this.numNodes == 0) { //not empty 
            throw new EmptyCollectionException("firstThreeElements");
        } else if (x < 0 || x >= numNodes) { //can't get index not in the queue or negative index. 
            throw new InvalidArgumentException("x");
        } 
        T temp = null;
        LinearNode second = front; 
        if (x == 0) { //index 0 front node dequeue
            temp = front.getElement();    //store first node element in temp 
            second = front.getNext();     //move front to node 2
            if (second != null) {           //if there is a node 2, set its previous to null
                front.getNext().setPrev(null);
                front = front.getNext();  
                numNodes--;
            } else { //if there is no second node, remove this only node and return element
                front = null;
                back = null;
                numNodes--;
            }
        } else { //index 1 and above 
            LinearNode<T> before = front;  //before points to the node before remove
            LinearNode<T> remove = before.getNext();//remove points at node user wishes to dequeue
            LinearNode<T> after = before.getNext().getNext();  //after points at node after remove
            for (int i = 0; i < x - 1 ; i++) { 
                before = before.getNext();
            }      
            remove = before.getNext();  
            after = remove.getNext();  
            temp = remove.getElement();   //temp stores the element of remove
            if (after != null) {          //if there's a third node,
                before.setNext(after);    //set befores's next to it
                after.setPrev(before);    //set after's previous to it
                numNodes--;
            } else {                      //There's no third node, so your index is 1. 
                before.setNext(null);
                back = before;
                numNodes--;
            }
        }
        //refresh the frontThree arraylist 
        frontThreeNodes.clear();   
        frontThreeElements.clear();
        LinearNode current = front;
        int count = 0;
        while (count < 3 && current != null) { //do max 3 loops; stop adding if under 3 nodes. 
            frontThreeNodes.add(current);   
            frontThreeElements.add((T)current.getElement());
            current = current.getNext();
        }
        return temp;
    }
    
    @Override
    public T first(int x) throws EmptyCollectionException, InvalidArgumentException {
        if (this.numNodes == 0) {
            throw new EmptyCollectionException("firstThreeElements");
        } else if (x > size() || x < 0) { //index not in the queue or a negative index. 
            throw new InvalidArgumentException("x");
        } else { 
            LinearNode<T> traverse = front;
            for (int i = 0; i < x; i++) { //traverse until you reach index requested.
                traverse = traverse.getNext();
            }      
            return traverse.getElement(); //return first node's element.
        }
    }

    @Override
    public ArrayList<LinearNode<T>> firstThreeNodes() throws EmptyCollectionException {
        if (this.numNodes == 0) { 
            throw new EmptyCollectionException("firstThreeElements");
        }
        ArrayList<LinearNode<T>> aList = new ArrayList<>(); 
        LinearNode point = front;
        for (int i = 0; (point != null) && (i < 3); i++) { //loop 3x or less if there's < 3 nodes
            aList.add(point);        //add node to collection
            point = point.getNext();   //move pointer to next node
        }
        return aList;
    }

    @Override
    public ArrayList<T> firstThreeElements() throws EmptyCollectionException {
        if (this.numNodes == 0) {
            throw new EmptyCollectionException("firstThreeElements");
        }
        ArrayList<T> aListEle = new ArrayList<>();
        LinearNode<T> temp = front;
        for (int i = 0; (temp != null) && (i < 3); i++) { //loop 3x, or less if under 3 nodes
            aListEle.add(temp.getElement());            //add the element to the arrayList
            temp = temp.getNext();
        }
        return aListEle;
    }
    
    @Override
    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode(element);
        if (this.numNodes == 0) { 
            front = newNode;         //if empty, front & back will point to the new node
            back = newNode;
        } else {                    
            back.setNext(newNode); //set back's next to new node
            newNode.setPrev(back); 
            back = newNode;          //move back pointer to the new node 
        }
        numNodes++;        
        //refreshing the frontThree arrayList
        if (numNodes <= 3) { 
            frontThreeNodes.add(newNode);
            frontThreeElements.add(newNode.getElement());
        }

    }
    
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (this.numNodes == 0) { 
            throw new EmptyCollectionException("firstThreeElements");
        } 
        
        T temp = front.getElement();         //temp = first node's element
        if (numNodes == 1) {                 //if only 1 node, set front & back = null
            front = null;                    //size will now be 0
            back = null;
        } else {                             //if more than 1 node:
            front.getNext().setPrev(null);   //set second node's previous to null
            front = front.getNext();           //front now points to second node
        }
        //refreshing the frontThree arrayList
        frontThreeNodes.clear();
        frontThreeElements.clear();
        LinearNode<T> current = front; 
        for (int i = 0; i < 3 && current != null; i++) { 
            frontThreeNodes.add(current);
            frontThreeElements.add((T)current.getElement());
            current = current.getNext();
        }
        
        numNodes--;
        return temp;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.numNodes == 0) { 
            throw new EmptyCollectionException("firstThreeElements");
        }
        return front.getElement(); 
    }
    
    @Override
    public boolean isEmpty() {
        return (this.numNodes == 0);
    }
    
    @Override
    public int size() {
        return this.numNodes;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        LinearNode curr = front;
        for (int i = 0; i < size(); i++) {
            sb.append(curr.getElement().toString());
            if (i < size() - 1) {
                sb.append(", ");
            }
            curr = curr.getNext();
        }
        return sb.toString();
    } 
}
