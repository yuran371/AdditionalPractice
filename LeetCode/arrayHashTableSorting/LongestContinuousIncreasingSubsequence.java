package arrayHashTableSorting;

/* 674. Longest Continuous Increasing Subsequence
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e.
 * subarray). The subsequence must be strictly increasing.
 * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1],
 * ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
 *
 * Example:
 * Input: nums = [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
 * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are
 * separated by element 4.
 * */
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int[] nums2 = {1, 3, 5, 4, 7};

        System.out.println(solution(nums2));
    }

    private static int solution(int[] nums) {
        int count = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else if (nums[i] > nums[i + 1]) {
                    max = count;
                count = 1;
            }
            if (max<count) {
                max = count;
            }
        }
        return max;
    }
}
