package arrayHashTableSorting;

import java.util.Arrays;
import java.util.stream.Collectors;

/* 1929
* Given an integer array nums of length n, you want to create an array ans
* of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i
* < n (0-indexed).
* Specifically, ans is the concatenation of two nums arrays.
* Return the array ans.
*
* Example:
* Input: nums = [1,2,1]
* Output: [1,2,1,1,2,1]
* Explanation: The array ans is formed as follows:
* - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
* - ans = [1,2,1,1,2,1]
* */
class ConcatenationOfArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(Arrays.toString(classicConcatenation(arr)));
    }

    public static int[] classicConcatenation(int[] nums) {
        int totalLength = nums.length * 2;
        int[] arr = new int[totalLength];
        int i = 0;
        for (int j = 0; j < totalLength; j++) {
            if (i == nums.length) {
                i = 0;
            }
            arr[j] = nums[i++];
        }
        return arr;
    }

}
