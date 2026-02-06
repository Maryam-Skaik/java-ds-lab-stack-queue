package assignment_solutions;

/**
 * Problem:
 * Check if a queue is palindrome using stack.
 *
 * Approach:
 * - Copy queue elements into stack
 * - Compare front of queue with stack pop
 * - Restore queue order
 */
public class PalindromeQueue<T> {

    private LinkedListQueue<T> queue = new LinkedListQueue<>();
    private int size = 0;

    public void enqueue(T val) {
        queue.enqueue(val);
        size++;
    }

    public T dequeue() {
        size--;
        return queue.dequeue();
    }

    public boolean isPalindrome() {
        LinkedListStack<T> stack = new LinkedListStack<>();
        int n = size;

        // Copy elements into stack
        for (int i = 0; i < n; i++) {
            T temp = dequeue();
            stack.push(temp);
            enqueue(temp);
        }

        // Compare
        for (int i = 0; i < n; i++) {
            T temp = dequeue();
            if (!temp.equals(stack.pop())) {
                enqueue(temp);
                return false;
            }
            enqueue(temp);
        }

        return true;
    }
}
