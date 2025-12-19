/**
 * Generic Stack implementation using a linked list.
 * Supports push, pop, peek, isEmpty operations.
 * Additional methods:
 * - reverseString: reverses a string using stack
 * - isBalanced: checks if parentheses/brackets are balanced
 *
 * @param <T> Type of elements stored in the stack.
 */
public class LinkedListStack<T> {
    private Node top; // Top node of the stack

    /**
     * Constructor to initialize an empty stack.
     */
    public LinkedListStack() {
        top = null;
    }

    /**
     * Checks if the stack is empty.
     * @return true if stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the top element without removing it.
     * @return Top element or null if stack is empty.
     */
    public T peek() {
        if (isEmpty()) return null;
        return (T) top.getElement();
    }

    /**
     * Adds a new element to the top of the stack.
     * @param element Element to push onto the stack.
     */
    public void push(T element) {
        Node newNode = new Node(element);
        newNode.setNext(top); // Point new node to current top
        top = newNode;        // Update top
    }

    /**
     * Removes and returns the top element of the stack.
     * @return The removed element or null if stack is empty.
     */
    public T pop() {
        if (isEmpty()) return null;
        T temp = (T) top.getElement(); // Store top element
        top = top.getNext();           // Move top pointer
        return temp;
    }

    /**
     * Reverses a string using a stack.
     * @param s Input string
     * @return Reversed string
     */
    public String reverseString(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        
        // Push each character onto stack
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        
        s = "";
        // Pop all characters to reverse
        while (!stack.isEmpty()) {
            s += stack.pop();
        }
        
        return s;
    }

    /**
     * Checks if parentheses/brackets are balanced in a string.
     * Supports: (), {}, []
     * @param s Input string
     * @return true if balanced, false otherwise
     */
    public boolean isBalanced(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c); // Push opening bracket
            } else {
                if (stack.isEmpty()) return false; // No matching opening
                char b = stack.pop(); // Pop last opening
                if (c == ')' && b != '(') return false;
                if (c == '}' && b != '{') return false;
                if (c == ']' && b != '[') return false;
            }
        }
        return stack.isEmpty(); // All brackets matched
    }

    /**
     * Example usage of LinkedListStack
     */
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        // Check balanced parentheses
        System.out.println(stack.isBalanced("{()}")); // true
        System.out.println(stack.isBalanced("{()]")); // false

        // Reverse a string
        System.out.println(stack.reverseString("Maryam"));
    }
}
