package stack;

import java.util.Stack;

/* 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example:
 * Input: s = "()[]{()}"
 * Output: true
 * */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(){}}";
        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.empty() && isPair(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean isPair(char open, Character close) {
        return open == '(' && close == ')' ||
                open == '{' && close == '}' ||
                open == '[' && close == ']';
    }
}


