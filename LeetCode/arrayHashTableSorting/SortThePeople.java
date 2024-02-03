package arrayHashTableSorting;

import java.util.Arrays;

/* 2418. Sort the People
 * You are given an array of strings names, and an array heights
 * that consists of distinct positive integers. Both arrays are of length n.
 * For each index i, names[i] and heights[i] denote the name and height
 * of the ith person.
 * Return names sorted in descending order by the people's heights.

 * Example:
 * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
 * Output: ["Mary","Emma","John"]
 * Explanation: Mary is the tallest, followed by Emma and John.
 *  */
public class SortThePeople {
    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        System.out.println(Arrays.toString(solution(names, heights)));
    }

    private static String[] solution(String[] names, int[] heights) {
        Man[] men = new Man[names.length];
        for (int i=0; i<men.length; i++) {
            men[i] = new Man(names[i], heights[i]);
        }
        Arrays.sort(men);
        String[] resultArray = new String[names.length];
        for (int i=0; i< resultArray.length; i++) {
            resultArray[i]=men[i].name;
        }
        return resultArray;
    }
}

class Man implements Comparable<Man>{
    String name;
    int height;

    public Man(String name, int height2) {
        this.name = name;
        this.height = height2;
    }

    @Override
    public int compareTo(Man oth) {
        return oth.height - this.height;
    }
}
