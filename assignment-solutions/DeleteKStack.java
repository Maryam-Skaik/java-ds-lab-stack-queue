package assignment_solutions;

/**
 * Problem:
 * Delete the k-th element from top of stack using recursion.
 *
 * Approach:
 * - Pop elements recursively until reaching k-th
 * - Skip the k-th element
 * - Push back remaining elements
 *
 * Time Complexity: O(k)
 * Space Complexity: O(k) due to recursion
 */
public class DeleteKStack<T> {

    private LinkedListStack<T> stack = new LinkedListStack<>();

    public void push(T val) {
        stack.push(val);
    }

    public T pop() {
        return stack.pop();
    }

    public void deleteK(int k) {
        if (stack.isEmpty() || k <= 0) return;
        deleteKHelper(k);
    }

    private void deleteKHelper(int k) {
        if (k == 1) {
            stack.pop(); // remove k-th
            return;
        }

        T val = stack.pop();
        deleteKHelper(k - 1);
        stack.push(val);
    }
}
