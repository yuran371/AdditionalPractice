package arrayHashTableSorting;

import java.util.Arrays;

/* 2433. Find The Original Array of Prefix Xor
 * You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * * Note that ^ denotes the bitwise-xor operation.
 * It can be proven that the answer is unique.
 *
 * Example:
 * Input: pref = [5,2,0,3,1]
 * Output: [5,7,2,3,2]
 * Explanation: From the array [5,7,2,3,2] we have the following:
 * - pref[0] = 5.
 * - pref[1] = 5 ^ 7 = 2.
 * - pref[2] = 5 ^ 7 ^ 2 = 0.
 * - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
 * - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
 * */
public class FindTheOriginalArrayOfPrefixXor {
    public static void main(String[] args) {
        int[] pref = {5,2,0,3,1};
        System.out.println(Arrays.toString(solution(pref)));
    }

    private static int[] solution(int[] nums) {
        int length = nums.length;
        int[] array = new int[length];
        array[0] = nums[0];
        for (int i = 1; i < length; i++) {
            array[i] = nums[i - 1] ^ nums[i];
        }
        return array;
    }
}
