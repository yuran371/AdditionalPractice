package arrayHashTableSorting;

import java.util.Arrays;

/* 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};     // ans = [24,12,8,6]
        int[] nums2 = {-1, 1, 0, -3, 3};        // ans = [0,0,9,0,0]
        System.out.println(Arrays.toString(solution(nums)));
        System.out.println(Arrays.toString(solution(nums2)));
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf(nums2)));
    }

    private static int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        OUTTER:
        for (int i = 0; i < nums.length; i++) {
            int multi = 1;
            INNER:
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
//                    j++;
                    continue INNER;
                }
                multi *= nums[j];
            }
            result[i] = multi;
        }
        return result;
    }
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
