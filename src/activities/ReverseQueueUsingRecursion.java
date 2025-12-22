// ReverseQueueUsingRecursion.java

/**
 * Problem: Reverse a queue using recursion.
 *
 * In this problem, we are tasked with reversing a queue using recursion. 
 * The idea is to dequeue an element, recursively reverse the remaining queue, 
 * and then enqueue the dequeued element back to the queue.
 *
 * Approach:
 * 1. Base Case: If the queue is empty, return (do nothing).
 * 2. Dequeue an element from the front of the queue.
 * 3. Recursively reverse the remaining queue.
 * 4. After recursion completes (unwinding), enqueue the previously dequeued element back.
 * 5. This process will reverse the order of elements in the queue as recursion unwinds.
 */

public class ReverseQueueUsingRecursion {

    // Reverse the queue using recursion
    public <T> void reverseByRecursion(LinkedListQueue<T> q) {
        // Base case: If the queue is empty, return
        if (q.isEmpty()) return;
        
        // Step 1: Dequeue an element from the front of the queue
        T temp = q.dequeue();
        
        // Step 2: Recursively reverse the remaining elements in the queue
        reverseByRecursion(q);
        
        // Step 3: Enqueue the dequeued element back into the queue after recursion unwinds
        q.enqueue(temp);
    }

    // Main function to test the solution
    public static void main(String[] args) {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        
        // Step 1: Enqueue elements: 1, 2, 3, 4
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        // Step 2: Create an object of ReverseQueueUsingRecursion
        ReverseQueueUsingRecursion obj = new ReverseQueueUsingRecursion();
        
        // Step 3: Reverse the queue using recursion
        obj.reverseByRecursion(q);

        // Step 4: Print the reversed queue
        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " "); // Output should be: 4 3 2 1
        }
    }
}
