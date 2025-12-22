// PalindromeUsingStack.java

/**
 * Problem: Check if a string is a palindrome using a stack.
 *
 * A palindrome is a string that reads the same forward and backward. We are asked to check if a given string 
 * is a palindrome by using a stack. The stack will be used to reverse the string and then compare each character.
 *
 * Approach:
 * 1. Push all characters of the string onto a stack.
 * 2. Pop characters from the stack and compare them with the original string.
 * 3. If any character doesn't match, return false. If all characters match, return true.
 */

public class PalindromeUsingStack {

    // Check if the string is palindrome using stack
    public boolean isPalindrome(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        
        // Step 1: Push all characters of the string onto the stack
        for (char c : s.toCharArray()) {
            stack.push(c);  // Push the character onto the stack
        }

        // Step 2: Compare characters from the string with the stack's popped elements
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != stack.pop()) {  // If characters do not match, return false
                return false;
            }
        }

        // Step 3: If all characters matched, return true
        return true;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        PalindromeUsingStack obj = new PalindromeUsingStack();
        
        // Test with a palindrome string
        System.out.println(obj.isPalindrome("ABCBA"));  // Output: true
        
        // Test with a non-palindrome string
        System.out.println(obj.isPalindrome("ABCD"));   // Output: false
    }
}
