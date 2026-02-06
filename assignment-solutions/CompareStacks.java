package stackqueue.assignment_solutions;

/**
 * Problem:
 * Check if two stacks are equal without modifying them.
 *
 * Approach:
 * - Pop top elements recursively
 * - Compare
 * - Restore stacks on recursion unwind
 */
public class CompareStacks<T> {

    public static <T> boolean areEqual(LinkedListStack<T> s1, LinkedListStack<T> s2) {
        if (s1.isEmpty() && s2.isEmpty()) return true;
        if (s1.isEmpty() || s2.isEmpty()) return false;

        T top1 = s1.pop();
        T top2 = s2.pop();

        boolean eq = top1.equals(top2) && areEqual(s1, s2);

        s1.push(top1);
        s2.push(top2);

        return eq;
    }
}
