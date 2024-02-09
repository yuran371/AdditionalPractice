package arrayHashTableSorting;

import java.util.Arrays;

/* 242. Valid Anagram
* Given two strings s and t, return true if t is an anagram of s, and false otherwise.
* An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
* typically using all the original letters exactly once.
*
* Example:
* Input: s = "anagram", t = "nagaram"
* Output: true
* */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(solution("Tenet", "etnet"));
        System.out.println("------");
        System.out.println(solution("ttenet", "qwe"));
    }
    private static boolean solution(String s, String t) {
        String sLowerCase = s.toLowerCase();
        String tLowerCase = t.toLowerCase();
        if (s.length()==t.length()) {
            char[] sCharArray = sLowerCase.toCharArray();
            char[] tCharArray = tLowerCase.toCharArray();
            Arrays.sort(sCharArray);
            Arrays.sort(tCharArray);
            return Arrays.equals(sCharArray, tCharArray);
        }
        return false;
    }
}
