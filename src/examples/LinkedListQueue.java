/**
 * Generic Queue implementation using a linked list.
 * Supports enqueue, dequeue, peek, display, getSize, isEmpty operations.
 *
 * @param <T> Type of elements stored in the queue.
 */
public class LinkedListQueue<T> {
    private Node front; // Front node of the queue
    private Node rear;  // Rear node of the queue
    private int size;   // Number of elements in the queue

    /**
     * Constructor to initialize an empty queue.
     */
    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Checks if the queue is empty.
     * @return true if queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns the number of elements in the queue.
     * @return Queue size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the front element without removing it.
     * @return Front element or null if queue is empty
     */
    public T peek() {
        if (isEmpty()) return null;
        return (T) front.getElement();
    }

    /**
     * Adds a new element at the rear of the queue.
     * @param element Element to enqueue
     */
    public void enqueue(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode; // First element
        } else {
            rear.setNext(newNode); // Link new node
            rear = newNode;        // Update rear
        }
        size++;
    }

    /**
     * Removes and returns the front element of the queue.
     * @return The dequeued element or null if queue is empty
     */
    public T dequeue() {
        if (isEmpty()) return null;
        T temp = (T) front.getElement();
        front = front.getNext(); // Move front pointer
        if (isEmpty()) rear = null; // Queue becomes empty
        size--;
        return temp;
    }

    /**
     * Displays all elements in the queue in order.
     * Maintains the original order using enqueue after dequeue.
     */
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            T temp = dequeue();
            System.out.print(temp + " ");
            enqueue(temp); // Maintain order
        }
        System.out.println();
    }

    /**
     * Example usage of LinkedListQueue
     */
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        
        queue.display(); // 1 2 3 4 5
        
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());    // 2
        queue.display();                     // 2 3 4 5
    }
}
