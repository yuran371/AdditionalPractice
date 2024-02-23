package twoPointers;

import java.util.Arrays;

/* 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water (blue section) the container can contain is 49.
 * */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 25, 7};
        System.out.println(solution(height));
    }

    private static int solution(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right) {
            if (height[left]>height[right]) {
                max = Math.max(max, Math.min(height[right], height[left])*(right-left));
                right--;
            } else if (height[left]<height[right]) {
                max = Math.max(max, Math.min(height[right], height[left])*(right-left));
                left++;
            } else {
                max = Math.max(max, Math.min(height[right], height[left])*(right-left));
                right--;
                left++;
            }
        }
        return max;
    }

    private static int solution2(int[] height) {
        int i = 1;
        int length = height.length;
        int j = length - 2;
        int maxLeft = height[0];
        int maxRight = height[length - 1];
        int left = height[0] * length;
        int right = height[length - 1] * length;
        int idLeft = 0;
        int idRight = height.length - 1;
        if (height.length == 3) {
            Arrays.sort(height);
            return height[2] * height[1];
        }
        while (i < j) {
            if (height[i] * (j + 1) > left) {
                left = height[i] * (j + 1);
                maxLeft = height[i];
                idLeft = i;
            }
            i++;
            if (height[j] * (j + 1) > right) {
                right = height[j + 1] * (j + 1);
                maxRight = height[j];
                idRight = j;
            }
            j--;
        }
        int min = Math.min(maxLeft, maxRight);
        System.out.println(min);
        System.out.println("---------");
        System.out.println(maxLeft);
        System.out.println(idLeft);
        System.out.println(maxRight);
        System.out.println(idRight);
        int res = min * (idRight - idLeft);
        return res;
    }

}
