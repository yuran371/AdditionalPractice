package twoPointers;

import java.util.*;

/* 15. 3Sum
 *Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j !=
 * k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> ints : solution(nums)) {
            System.out.println(ints);
        }
    }

    private static List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k)
                if (nums[i] + nums[j] + nums[k] == 0) {
                    set.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            i++;
        }
        int[][] arr = set.stream()
                .map(list -> list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);     // Thought it should return int[][]
        List<List<Integer>> resultList = new ArrayList<>(set);
        return resultList;
    }
}
