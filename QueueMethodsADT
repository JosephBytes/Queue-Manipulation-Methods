package queues;

/**
 * An interface for a Queue.Specific queue implementations will implement this interface
 * @author Joseph Abdulwahab
 * @version final
 * @param <T> - The generic data type of the objects in this queue
 */
public interface QueueADT<T> extends CollectionADT<T> {
       
    /**
     * Removes and returns the element that is at index x in the queue.
     * Precondition: x must be greater than 0 and x must be less than size (because indexed)
     * Note: indexing from 0: 0 == front element, 1 == second element, etc.
     * @param x the passed in index of the element to be removed.
     * @return the element removed from the queue.
     * @throws EmptyCollectionException if the queue is empty.
     * @throws InvalidArgumentException if x is negative or greater than size. 
     */
    public T dequeue(int x) throws EmptyCollectionException, InvalidArgumentException;
    
    /**
     * Returns (without removing) the element that is at place x in the queue.
     * Precondition: x must be less than or equal to size, and greater than or equal to 0.
     * Note: indexing from 0: 0 == front element, 1 == second element, etc.
     * @return the element requested in parameter.
     * @throws EmptyCollectionException if the queue is empty.
     * @throws InvalidArgumentException if x is greater than size, or x is negative.
     * @param x the specified index of the element to return.
    **/
    public T first(int x) throws EmptyCollectionException, InvalidArgumentException;

    /**
     * Returns an ArrayList of the first three nodes in the queue.
     * @return an ArrayList of nodes of LinearNodes of T data type.
     * @throws EmptyCollectionException if the queue is empty.
     */
    public ArrayList<LinearNode<T>> firstThreeNodes() throws EmptyCollectionException;

    /**
     * Returns an ArrayList of the first three elements in the queue.
     * @return an ArrayList of elements of T data type.
     * @throws EmptyCollectionException if the queue is empty.
     */
    public ArrayList<T> firstThreeElements() throws EmptyCollectionException;

    /**
     * Adds the specified element to the back of the queue.
     * @param element element to be added to the end of the queue.
     */
    public void enqueue(T element) {

    /**
     * Removes and returns the element that is at the front of the queue.
     * @return the element removed from the queue.
     * @throws EmptyCollectionException if queue is empty.
     */
    public T dequeue() throws EmptyCollectionException;
    /**
     * Returns (without removing) the element that is at the front of the queue.
     * @return the element at the front of the queue.
     * @throws EmptyCollectionException if queue is empty.
     */
    public T first() throws EmptyCollectionException;

    /**
     * Returns true if the collection contains no elements.
     * @return true if the collection is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the collection.
     * @return the number of elements as an int
     */
    public int size();

    /**
     * Returns a string representation of the collection.
     * @return a string representation of the collection
     */
    public String toString();   
}
