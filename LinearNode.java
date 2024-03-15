package queues;

/**
 * A simple Linear Node object.
 * @author Joseph Abdulwahab
 * @param <T> The data type of the object being managed by this node.
 * @version final
 */
public class LinearNode<T> implements LinearNodeADT<T>{

    private LinearNode<T> next;  // Pointer to the next LinearNode in the list
    private LinearNode<T> prev;  // Pointer to the last LinearNode in the list
    private T element;           // Pointer to the object managed by this node
    
    public LinearNode() {
        next = null;
        prev = null;
        element = null;
    }
    
    public LinearNode(T elem) {
        next = null;
        prev = null;
        element = elem;
    }
    
    public LinearNode<T> getNext() {
        return next;
    }
    
    public void setNext(LinearNode<T> n) {
        next = n;
    }
    
    public LinearNode<T> getPrev() {
        return prev;
    }
    
    public void setPrev(LinearNode<T> p) {
        prev = p;
    }
    
    public T getElement() {
        return element;
    }
    
    public void setElement(T elem) {
        element = elem;
    }

    @Override
    public String toString() {
        return "{el=" + element + ", next=" + next + ", prev=" + prev + "}";
    }
}
