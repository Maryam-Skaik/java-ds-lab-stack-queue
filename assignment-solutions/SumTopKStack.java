package assignment_solutions;

/**
 * Problem:
 * Sum top k elements of a stack without losing data.
 *
 * Approach:
 * - Pop top recursively
 * - Sum
 * - Restore stack while recursion unwinds
 */
public class SumTopKStack {

    private LinkedListStack<Integer> stack = new LinkedListStack<>();

    public void push(int val) {
        stack.push(val);
    }

    public int sumTopK(int k) {
        if (stack.isEmpty() || k <= 0) return 0;
        return sumTopKHelper(k);
    }

    private int sumTopKHelper(int k) {
        if (k == 0 || stack.isEmpty()) return 0;
        int val = stack.pop();
        int sum = val + sumTopKHelper(k - 1);
        stack.push(val); // restore
        return sum;
    }
}
