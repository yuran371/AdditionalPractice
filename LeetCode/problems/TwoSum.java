package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Integer;


@SuppressWarnings("hiding")
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.

public class TwoSum {
	public ArrayList<Integer> sum(ArrayList<Integer> al, int a) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		Integer g = Integer.valueOf(4);
		for (int i=0; i<al.size()-1; i++) {
			for (int j=i+1; j<al.size(); j++) {
				if ((al.get(i)+al.get(j))==a) {
//					if (al.get(i)==arrayList.get(i)&&al.get(j)==arrayList.get(j)) {
					arrayList.add(i); 
					arrayList.add(j); 
//					}
				}
			}
		}
		return arrayList;
	}
}

class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(15);
		arrayList.add(7);
		arrayList.add(11);
		arrayList.add(2);
		TwoSum twoSum = new TwoSum();
		
		System.out.println(twoSum.sum(arrayList, 9));
	}
}
