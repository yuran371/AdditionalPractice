package stack;

import java.util.Stack;
import java.util.stream.Collectors;

/* 1544. Make The String Great
* Given a string s of lower and upper case English letters.
* A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
* 0 <= i <= s.length - 2
* s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
* To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can
* keep doing this until the string becomes good.
* Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
* Notice that an empty string is also good.
*
* Example:
* Input: s = "leEeetcode"
* Output: "leetcode"
* Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to
* "leetcode".
* */
public class MakeTheStringGreat {
    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(solution(s));
    }
    private static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (!stack.empty()&&s.charAt(i)!=stack.peek()) {
                String str1 = Character.toString(s.charAt(i));
                String str2 = Character.toString(stack.peek());
                if (str1.toUpperCase().equals(str2.toUpperCase())) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.stream().map(ch -> ch.toString()).collect(Collectors.joining(""));
    }
}
