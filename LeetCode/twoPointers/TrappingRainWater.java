package twoPointers;

/* 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it can trap after raining.
 *
 * Example:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 *  6 units of rain water (blue section) are being trapped.
 * */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution(height));
    }

    private static int solution(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int res = 0;
        int maxL = 0;
        int maxR = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < height.length) {
            if (height[i] > maxL) {
                maxL = height[i];
            }
            if (height[j] > maxR) {
                maxR = height[j];
            }
            left[i] = maxL;
            right[j] = maxR;
            i++;
            j--;
        }
        for (int k = 0; k < height.length; k++) {
            if ((Math.min(left[k], right[k]) - height[k]) > 0) {
                res += Math.min(left[k], right[k]) - height[k];
            }
        }
        return res;
    }

    private static int solution2(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
                maxL = Math.max(maxL, height[l]);
                res += maxL - height[l];
            } else {
                r--;
                maxR = Math.max(maxR, height[r]);
                res += maxR - height[r];
            }
        }
        return res;
    }
}
