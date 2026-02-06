package assignment_solutions;

import java.util.LinkedList;

/**
 * Problem:
 * Reverse the first k elements of a queue.
 *
 * Approach:
 * - Use a stack to reverse the first k elements
 * - Re-enqueue the rest to maintain order
 *
 * Recursive Approach:
 * - Optional: reverse recursively without a stack
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k) using stack
 */
public class ReverseKQueue<T> {

    private LinkedList<T> queue = new LinkedList<>();
    private int size = 0;

    public void enqueue(T value) {
        queue.addLast(value);
        size++;
    }

    public T dequeue() {
        size--;
        return queue.removeFirst();
    }

    public void reverseK(int k) {
        if (k <= 0 || k > size) return;

        LinkedList<T> stack = new LinkedList<>();

        // Push first k elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(dequeue());
        }

        // Enqueue back reversed
        while (!stack.isEmpty()) {
            enqueue(stack.pop());
        }

        // Move remaining elements to back
        int remaining = size - k;
        for (int i = 0; i < remaining; i++) {
            enqueue(dequeue());
        }
    }

    // Recursive version (without stack)
    public void reverseKRec(int k) {
        if (k <= 0 || k > size) return;
        reverseKRecHelper(k);
    }

    private void reverseKRecHelper(int k) {
        if (k == 0) return;
        T val = dequeue();
        reverseKRecHelper(k - 1);
        enqueue(val);
    }
}
