package arrayHashTableSorting;

import java.util.*;
import java.util.Map.Entry;

import static java.util.Collections.reverseOrder;

/* 347. Top K Frequent Elements
 *Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1};
        int[] nums3 = {4, 1, -1, 2, 2, 2, -1, 2, 3};
        int[] nums4 = {4,1,-1,2,-1,2,3};
        int[] nums5 = {5,2,5,5,3,1};
        int k = 2;
        System.out.println("main1: "+Arrays.toString(solution(nums, k)));
        System.out.println("main2: "+Arrays.toString(solution(nums5, k)));
    }

    private static int[] solution(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println("Начало: "+Arrays.toString(nums));
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                count++;
                i++;
            }
            map.put(nums[i], count);
        }

        System.out.println("мапа не сорт: "+map);
        Map<Integer, Integer> sortedByValueMap = sortByValue(map);
        System.out.println("мапа сорт: "+sortedByValueMap);
        List<Integer> keyList = new ArrayList<>(sortedByValueMap.keySet());
        System.out.println("arralist: "+keyList);
        int[] result = new int[Math.min(map.size(), k)];
        for (int i = 0; i < result.length; i++) {
            result[i] = keyList.get(i);
        }
        return result;
    }
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(reverseOrder(Entry.comparingByValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}