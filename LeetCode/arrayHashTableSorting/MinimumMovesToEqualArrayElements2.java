package arrayHashTableSorting;

/* 462. Minimum Moves to Equal Array Elements II
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 * In one move, you can increment or decrement an element of the array by 1.
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * */

import java.util.Arrays;

/*
 * nums = [1,0,0,8,6]
 * Output 16
 * Expected 14
 * */
public class MinimumMovesToEqualArrayElements2 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int[] numbers2 = {1, 0, 0, 8, 6};    // 6 чисел, сумма = 16
        System.out.println(solution2(numbers2));
    }

    private static int solutionError(int[] numbers) {
        double count = 0;
        for (int number : numbers) {
            count += number;
        }
        double srednee = count / (double) numbers.length;
        int round = (int) Math.round(srednee);
        int raznica = 0;
        for (int number : numbers) {
            if (number < round) {
                int l1 = round - number;
                raznica += l1;
            }
            if (number > round) {
                int l2 = number - round;
                raznica += l2;
            }

        }
        return raznica;
    }

    private static int solution1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = n % 2 == 0 ? (nums[n / 2] + nums[n / 2 - 1]) / 2 : nums[n / 2];
        if (n % 2 == 0) {
            median = (nums[n / 2] + nums[n / 2 - 1]) / 2;
        } else {
            median = nums[n / 2];
        }
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer += Math.abs(nums[i] - median);
        }
        return answer;
    }

    private static int solution2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = n % 2 == 0 ? (nums[n / 2] + nums[n / 2 - 1]) / 2 : nums[n / 2];
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer += Math.abs(nums[i] - median);
        }
        return answer;
    }

    private static int solution3(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = nums.length-1; i < j; i++, j--) {
            ans += nums[i] - nums[j];
        }
        return Math.abs(ans);
    }
}
