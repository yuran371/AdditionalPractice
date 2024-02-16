package twoPointers;

import java.util.ArrayList;

/* 125. Valid Palindrome
 * A phrase is a palindrome if, after converting all uppercase letters
 * into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters
 * include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList al = new ArrayList();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch) && Character.isDigit(ch)) {
                char lowerCase = Character.toLowerCase(ch);
                sb.append(lowerCase);
            }
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();
        if (sb.toString()
                .equals(reverse.toString())) {
            return true;
        }
        System.out.println(sb + " " + reverse);
        return false;
    }

    private static boolean solution2(String s) {
        String lowerCase = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char iChar = lowerCase.charAt(i);
            char jChar = lowerCase.charAt(j);
            if (!Character.isLetterOrDigit(iChar)) {      // "!wefwe  ewqrqwer2r@"
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(jChar)) {
                j--;
                continue;
            }
            if (iChar != jChar) {
                return false;
            }
        }
        return true;
    }
}
