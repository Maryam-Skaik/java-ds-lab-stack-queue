// SortStack.java

/**
 * Problem: Sort a stack of integers using only stack operations and one extra stack.
 *
 * In this problem, we are given a stack of integers and are asked to sort it using stack operations only,
 * while using one additional stack for sorting. No arrays or loops are allowed.
 *
 * Approach:
 * 1. Use an auxiliary stack to help with sorting the elements of the original stack.
 * 2. Pop elements from the original stack and insert them into the correct position in the auxiliary stack.
 * 3. Ensure that the sorted stack maintains the correct order after all elements are processed.
 */

public class SortStack {

    // Sort stack using another stack
    public LinkedListStack<Integer> sortStack(LinkedListStack<Integer> stack) {
        LinkedListStack<Integer> temp = new LinkedListStack<>();
        
        // Step 1: While the original stack is not empty, pop an element
        while (!stack.isEmpty()) {
            int element = stack.pop();  // Pop the top element from the original stack

            // Step 2: Move elements from temp stack back to original stack if they are greater than the element
            while (!temp.isEmpty() && temp.top.data > element) {
                stack.push(temp.pop());  // Move elements from temp stack to original stack
            }

            // Step 3: Push the element into the temp stack (this ensures sorted order)
            temp.push(element);
        }

        // Return the sorted stack (temp)
        return temp;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Step 1: Create a stack: 3, 1, 4, 2
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        // Step 2: Create an object of SortStack
        SortStack obj = new SortStack();

        // Step 3: Sort the stack
        LinkedListStack<Integer> sortedStack = obj.sortStack(stack);

        // Step 4: Print the sorted stack
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
    }
}
