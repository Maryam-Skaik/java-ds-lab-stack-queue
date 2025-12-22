// ReverseSLLUsingStack.java

/**
 * Problem: Reverse a Singly Linked List using a Stack.
 *
 * In this problem, we are given a singly linked list (SLL) and asked to reverse it.
 * We will use a stack data structure to solve this problem by leveraging the LIFO (Last-In-First-Out) 
 * nature of the stack to reverse the list.
 *
 * Approach:
 * 1. Traverse the original list and push all nodes onto a stack.
 * 2. Pop nodes from the stack and rebuild the linked list in reverse order.
 * 3. Since stacks are LIFO structures, the order of elements is reversed when they are popped.
 */

public class ReverseSLLUsingStack {

    // Node class to represent each element in the Singly Linked List
    static class Node {
        int data;
        Node next;

        // Constructor to initialize a new node with data
        Node(int data) {
            this.data = data;
            this.next = null;
        }

        // Getters and setters for node data and next reference
        public int getData() { return data; }
        public Node getNext() { return next; }
        public void setNext(Node next) { this.next = next; }
    }

    // Stack class implemented using a linked list for generic types
    static class LinkedListStack<T> {
        private Node top;

        // Constructor to initialize the stack
        public LinkedListStack() {
            this.top = null;
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return top == null;
        }

        // Push an element onto the stack
        public void push(T data) {
            Node newNode = new Node((int) data); // Create a new node with the data
            newNode.next = top;  // Point the new node to the current top
            top = newNode;  // Update the top to the new node
        }

        // Pop the top element from the stack
        public T pop() {
            if (isEmpty()) return null; // If the stack is empty, return null
            T poppedData = (T) Integer.valueOf(top.data); // Get the data of the top node
            top = top.next;  // Move the top pointer to the next node
            return poppedData;
        }
    }

    // Method to reverse the Singly Linked List using the stack
    public Node reverseSLL(Node head) {
        LinkedListStack<Node> stack = new LinkedListStack<>();
        
        // Step 1: Push all nodes onto the stack
        while (head != null) {
            stack.push(head);  // Push the current node onto the stack
            head = head.getNext();  // Move to the next node
        }

        // Step 2: Pop from the stack and rebuild the reversed list
        Node newHead = stack.pop();  // Pop the top node from the stack, which will become the new head
        Node currentNode = newHead;  // Start building the reversed list
        
        // Continue popping nodes from the stack and linking them
        while (!stack.isEmpty()) {
            currentNode.setNext(stack.pop());  // Set the next node in the reversed list
            currentNode = currentNode.getNext();  // Move the currentNode pointer to the newly added node
        }

        // End of the reversed list (set the last node's next to null)
        currentNode.setNext(null);

        return newHead;  // Return the new head of the reversed list
    }

    // Main function to test the reverseSLL method
    public static void main(String[] args) {
        // Step 1: Create a sample singly linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(4));

        // Step 2: Create an object of ReverseSLLUsingStack
        ReverseSLLUsingStack obj = new ReverseSLLUsingStack();

        // Step 3: Reverse the linked list
        Node reversedHead = obj.reverseSLL(head);

        // Step 4: Print the reversed linked list
        Node current = reversedHead;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }
}
