package assignment_solutions;

/**
 * Problem:
 * Find the largest element in a stack using recursion.
 *
 * Approach:
 * - Pop elements recursively
 * - Track max
 * - Restore stack while recursion unwinds
 */
public class MaxStack {

    private LinkedListStack<Integer> stack = new LinkedListStack<>();

    public void push(int val) {
        stack.push(val);
    }

    public int maxElement() {
        if (stack.isEmpty()) return Integer.MIN_VALUE;
        return maxHelper();
    }

    private int maxHelper() {
        if (stack.isEmpty()) return Integer.MIN_VALUE;

        int val = stack.pop();
        int max = Math.max(val, maxHelper());
        stack.push(val); // restore
        return max;
    }
}
