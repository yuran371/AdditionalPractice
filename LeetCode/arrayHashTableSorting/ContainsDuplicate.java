package arrayHashTableSorting;

import java.util.*;

/* 217
* Given an integer array nums, return true if any value appears at least
* twice in the array, and return false if every element is distinct.
*
* Example:
* Input: nums = [1,2,3,1]
* Output: true
**/
class ContainsDuplicate {

    public static void main(String[] args) {
        int[] example = {1, 2, 1};
        System.out.println(containsDuplicate(example));
        System.out.println(viaStreamArray(example));
    }

    // Time Limit Exceeded
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean viaStreamArray(int[] nums) {
        long count = Arrays.stream(nums).distinct().count();
        if (count<nums.length) {
            return true;
        } else {
            return false;
        }
//        Optional<Integer> optionalInteger = Arrays.stream(nums)
//                .boxed()
//                .sorted(Comparator.naturalOrder())
//                .filter(x -> nums[x] == nums[x + 1])
//                .findFirst();
//         optionalInteger.ifPresentOrElse(() -> {return true},() -> {return false});
    }

    public static boolean viaHashMap(int[] nums) {
        /*
        * 1) При добавлении уже существующего ключа value++
        * 2) if value>1 return true
        * */
        return true;
    }
}
