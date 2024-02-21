package twoPointers;

import java.util.Arrays;

/* 167. Two Sum II - Input Array Is Sorted
 *Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such
 * that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1
 * <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of
 * length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 *
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * */
public class TwoSumTwoInputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = {5,25,75};
        int target = 100;
        System.out.println(Arrays.toString(solution(numbers, target)));
    }

    private static int[] solution(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < numbers.length) {
            if (numbers[i]+numbers[j] > target) {
                j--;
            } else
            if (numbers[i]+numbers[j] < target) {
                i++;
            } else {
                res[0]=i+1;
                res[1]=j+1;
                return res;
            }
        }
        return res;
    }
}
