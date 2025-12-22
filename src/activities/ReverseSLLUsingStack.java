public class ReverseSLLUsingStack {
    // Node class representing each node in a singly linked list (SLL)
    static class Node {
        int data;
        Node next;

        // Constructor to initialize the node with data
        Node(int data) {
            this.data = data;
            this.next = null;
        }

        // Getter for the next node
        public Node getNext() {
            return next;
        }

        // Setter for the next node
        public void setNext(Node next) {
            this.next = next;
        }
    }

    // Reverse the Singly Linked List (SLL) using a Stack
    public Node reverseSLL(Node head) {
        // Create an empty stack to store the nodes
        LinkedListStack<Node> stack = new LinkedListStack<>();
        
        // Traverse the list and push each node to the stack
        // This step stores the nodes in reverse order
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }
        
        // Pop the top node and set it as the new head
        // This is the last node in the original list and becomes the first in the reversed list
        Node newHead = stack.pop();
        Node currentNode = newHead;

        // Pop the remaining nodes from the stack and link them in reversed order
        while (!stack.isEmpty()) {
            currentNode.setNext(stack.pop());
            currentNode = currentNode.getNext();
        }

        // Set the next pointer of the last node to null to terminate the reversed list
        currentNode.setNext(null);

        return newHead;  // Return the new head of the reversed list
    }

    // Test the reverseSLL method with a sample linked list
    public static void main(String[] args) {
        // Create a simple SLL for testing (1 -> 2 -> 3 -> 4)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        ReverseSLLUsingStack solution = new ReverseSLLUsingStack();
        Node reversedHead = solution.reverseSLL(head);  // Reverse the list

        // Print the reversed list (should print 4 -> 3 -> 2 -> 1)
        Node current = reversedHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.getNext();
        }
    }
}
