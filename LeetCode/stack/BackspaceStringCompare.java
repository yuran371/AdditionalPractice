package stack;

import java.util.Stack;

/* 844. Backspace String Compare
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a
 * backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "bbcd";
        System.out.println(solution(s, t));
    }

    private static boolean solution(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        isStacksEquals(s, stackS);
        isStacksEquals(t, stackT);
        System.out.println();
        int sizeS = stackS.size();
        if (stackT.size() != stackS.size()) {
            return false;
        } else {
            for (int i = 0; i < sizeS; i++) {
                if (stackT.pop() != stackS.pop()) {
                    return false;
                }
            }
        }
        System.out.println();
        return true;
    }

    private static void isStacksEquals(String s, Stack<Character> stackS) {
        for (int i = 0; i < s.length(); i++) {
            if (!stackS.empty() && s.charAt(i) == '#') {
                stackS.pop();
            } else if (s.charAt(i) != '#') {
                stackS.push(s.charAt(i));
            }
        }
    }
}
