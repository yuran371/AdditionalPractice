package arrayHashTableSorting;

import java.util.Arrays;

/* 1470. Shuffle the Array
* ------------------------
* Given the array nums consisting of 2n elements
* in the form [x1,x2,...,xn,y1,y2,...,yn].
* Return the array in the form [x1,y1,x2,y2,...,xn,yn].
*
* Example:
* Input: nums = [2,5,1,3,4,7], n = 3
* Output: [2,3,5,4,1,7]
* Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7
* then the answer is [2,3,5,4,1,7].*/
public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4,7};
        int n = 3;
        System.out.println(Arrays.toString(solution(arr, n)));
    }

    private static int[] solution(int[] nums, int n) {
        int length = nums.length;
        int[] arr = new int[length];
        for (int i=0,j=0; i<length/2; i++,j++) {
            arr[j] = nums[i];
            arr[j+1] = nums[i+n];
            j++;
        }
        return arr;
    }
}
