package arrayHashTableSorting;

import java.util.*;

/* 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the original
 * letters exactly once.
 *
 * Example:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("main" + Arrays.toString(strs));
        System.out.println("main" + Arrays.toString(solution2(strs)));
    }

    private String[] solution(String[] strArray) {
        String[] str = strArray.clone();
        String[] array = Arrays.stream(str)
                .map(String::toLowerCase)
                .map(String::toCharArray)
                .peek(chars -> Arrays.sort(chars))
                .map(String::valueOf)
                .toArray(String[]::new);

        Map<String, Integer> map = new HashMap<>();
        for (String s : array) {
            int newValue = map.getOrDefault(s, 0) + 1;
            map.put(s, newValue);
        }
//        Map<String, Integer> collect = map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue() )
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

//        System.out.println(collect);
        String[][] stringArray = new String[map.size()][];
        for (int i = 0; i < map.size(); i++) {
//            stringArray[i][]
        }
        return array;
    }

    private static String[] solution2(String[] strArray) {
        String[] str = strArray.clone();
        System.out.println("array: " + Arrays.toString(str));
        String[] array = Arrays.stream(str)
                .map(String::toLowerCase)
                .map(String::toCharArray)
                .peek(chars -> Arrays.sort(chars))
                .map(String::valueOf)
                .toArray(String[]::new);
        System.out.println("array: " + Arrays.toString(array));
        Map<String, Integer> map = new HashMap<>();
        CompareForTreeMap cft = new CompareForTreeMap(map);
        TreeMap<String, Integer> sortedTreeMap = new TreeMap<>(cft);
        for (String s : array) {
            int newValue = map.getOrDefault(s, 0) + 1;
            map.put(s, newValue);
        }
        sortedTreeMap.putAll(map);
        System.out.println("sortedTreeMap: " + sortedTreeMap);

        String[][] stringArray = new String[map.size()][];
        List<Integer> valueList = new ArrayList<>();
        List<String> keyList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedTreeMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            valueList.add(value);
            keyList.add(key);
            System.out.println(key + " => " + value);
        }
        for (int i = 0; i < valueList.size(); i++) {
            stringArray[i] = new String[valueList.get(i)];
        }
        System.out.println("valueList: " + valueList);
        System.out.println("keyList: " + keyList);
        for (int i = 0; i < stringArray.length; i++) {
            int j=0;
            while(j<valueList.get(i)) {
                for (int n = 0; n < array.length; n++) {
                    if (keyList.get(i).equals(array[n])) {
                        stringArray[i][j] = str[n];
                        j++;
                    }
                }
            }
        }
        System.out.println("stringArray: " + Arrays.toString(stringArray));
        for (String[] strings : stringArray) {
            System.out.println(Arrays.toString(strings));
        }
        List<List<String>> listOfLists = new ArrayList<>();

        for (String[] array1 : stringArray) {
            List<String> innerList = new ArrayList<>();
            for (String value : array1) {
                innerList.add(value);
            }
            listOfLists.add(innerList);
        }

        return str;
    }
}

class CompareForTreeMap implements Comparator<String> {
    Map<String, Integer> map;

    public CompareForTreeMap(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(String s1, String s2) {
        if (map.get(s1) >= map.get(s2)) {
            return 1;
        } else {
            return -1;
        }
    }

}
