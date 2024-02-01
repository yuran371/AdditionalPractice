package arrayHashTableSorting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 1637. Widest Vertical Area Between Two Points Containing No Points
 * Given n points on a 2D plane where points[i] = [xi, yi], Return the
 * widest vertical area between two points such that no points are
 * inside the area.
 * A vertical area is an area of fixed-width extending infinitely along
 * the y-axis (i.e., infinite height). The widest vertical area is the
 * one with the maximum width.
 * Note that points on the edge of a vertical area are not considered
 * included in the area.
 *
 * Example:
 * Input: points = [[8,7],[9,9],[7,4],[9,7]]
 * Output: 1
 * Explanation: Both the red and the blue area are optimal.
 * */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static void main(String[] args) {
        int[][] array = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};
        int[][] array1 = {{1, 2}, {4, 3}, {5, 6}, {7, 8}, {7, 8}, {33, 22}};
        int[][] array2 = {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};
        System.out.println(solution(array2));
    }

    private static int solution(int[][] nums) {
        List<Integer> collect = Arrays.stream(nums)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
        int[] oneDArray = IntStream.range(0, collect.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(collect::get)
                .mapToInt(j -> (int) j)
                .toArray();
        int[] sortedArray = Arrays.stream(oneDArray)
                .boxed()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
        int max = 0;
        for (int i=sortedArray.length-1; i>0; i--) {
            int diff = sortedArray[i] - sortedArray[i - 1];
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }

    private static int solution0(int[][] nums) {
        /*
         * Код ниже помогает найти количество точек по x-координате
         * за вычетом крайних точек (даже если они дублируются)
         * */

        List<Integer> collect = Arrays.stream(nums)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
        int[] array = IntStream.range(0, collect.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(collect::get)
                .mapToInt(j -> (int) j)
                .toArray();
        int[] array1 = Arrays.stream(array)
                .boxed()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
        long count = Arrays.stream(array1)
                .filter(i -> i != array1[array1.length - 1] &&
                        i != array1[0])
                .count();
        return (int) count;
    }
}
