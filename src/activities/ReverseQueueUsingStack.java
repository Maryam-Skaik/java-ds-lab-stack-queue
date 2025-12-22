// ReverseQueueUsingStack.java

/**
 * Problem: Reverse a queue using a stack.
 *
 * In this problem, we are tasked with reversing a queue using a stack.
 * The approach leverages the LIFO (Last-In-First-Out) property of a stack.
 *
 * Approach:
 * 1. Dequeue all elements from the queue and push them onto a stack.
 * 2. Since the stack is LIFO, the last element dequeued from the queue will be the first element in the stack.
 * 3. Pop all elements from the stack and enqueue them back into the queue. This will result in the queue being reversed.
 */

public class ReverseQueueUsingStack {

    // Reverse the queue using a stack
    public <T> void reverseByStack(LinkedListQueue<T> q) {
        LinkedListStack<T> stack = new LinkedListStack<>();

        // Step 1: Dequeue all elements from the queue and push them onto the stack
        while (!q.isEmpty()) {
            stack.push(q.dequeue());  // Pop from queue, push to stack
        }

        // Step 2: Pop all elements from the stack and enqueue them back to the queue
        while (!stack.isEmpty()) {
            q.enqueue(stack.pop());  // Pop from stack, push to queue
        }
    }

    // Main function to test the solution
    public static void main(String[] args) {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();

        // Step 1: Enqueue elements: 1, 2, 3, 4
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        // Step 2: Create an object of ReverseQueueUsingStack
        ReverseQueueUsingStack obj = new ReverseQueueUsingStack();
        
        // Step 3: Reverse the queue using a stack
        obj.reverseByStack(q);

        // Step 4: Print the reversed queue
        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " "); // Output should be: 4 3 2 1
        }
    }
}
