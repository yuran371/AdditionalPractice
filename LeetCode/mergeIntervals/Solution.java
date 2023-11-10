package mergeIntervals;

import java.util.Arrays;

class Solution {
    public int[][] Merge(int[][] intervals) {
        int size=intervals.length;
        for (int i=0; i<intervals.length-1; i++) {
            for (int j=i+1; j<intervals.length-1; j++) {
                if (intervals[i][1]>=intervals[j][0]) {
                    size--;
                    System.out.println(size);
                }
            }
        }
        int[][] tempArr = new int[size][2];
        for (int i=0; i<intervals.length-1; i++) {
            for (int j=i+1; j<intervals.length-1; j++) {
                if (intervals[i][1]>=intervals[j][0]) {
                    tempArr[i][0]=intervals[i][0];
                    tempArr[i][1]=intervals[j][1];
                }
            }
        }
		return tempArr;
    }
	public static void main(String[] args) {
		int[][] tempArr1 = new int[4][2];
		tempArr1[0][0]=1;
		tempArr1[0][1]=3;
		tempArr1[1][0]=2;
		tempArr1[1][1]=6;
		tempArr1[2][0]=8;
		tempArr1[2][1]=15;
		tempArr1[3][0]=15;
		tempArr1[3][1]=18;
		Solution sl = new Solution();
		sl.Merge(tempArr1);
		System.out.println(Arrays.deepToString(sl.Merge(tempArr1)));
	}

}
