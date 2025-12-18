package stack.queue;

/**
 * Generic Stack implementation using an array.
 * Supports push, pop, peek, isEmpty operations.
 *
 * @param <T> Type of elements stored in the stack.
 */
public class ArrayStack<T> {
    // Array to hold stack elements
    private T[] stack;
    
    // Index of the top element in the stack
    private int top;

    /**
     * Constructor to initialize the stack with a given size.
     * @param size Initial capacity of the stack array.
     */
    public ArrayStack(int size) {
        // Generic array creation
        stack = (T[]) new Object[size];
        top = -1; // Empty stack
    }

    /**
     * Checks if the stack is empty.
     * @return true if stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns the top element without removing it.
     * @return Top element or null if stack is empty.
     */
    public T peek() {
        if (isEmpty()) return null;
        return stack[top];
    }

    /**
     * Adds a new element to the top of the stack.
     * Automatically expands the array if capacity is exceeded.
     * @param element Element to push onto the stack.
     */
    public void push(T element) {
        // Check if stack is full
        if (top == stack.length - 1) {
            // Increase array size by 10
            T[] newStack = (T[]) new Object[stack.length + 10];
            
            // Copy existing elements to new array
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            
            stack = newStack; // Replace old array
        }
        stack[++top] = element; // Increment top and insert element
    }

    /**
     * Removes and returns the top element of the stack.
     * @return The removed element or null if stack is empty.
     */
    public T pop() {
        if (isEmpty()) return null;
        T temp = peek(); // Store current top
        top--;           // Decrement top index
        return temp;
    }

    /**
     * Example usage of ArrayStack.
     */
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        
        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        // Pop elements one by one
        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
        System.out.println(stack.pop()); // null (empty stack)
        
        // Push again to test dynamic resizing
        stack.push(40);
        System.out.println(stack.peek()); // 40
    }
}
