package com.Test1;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
	public static void main(String[] ar) {

		testComparable test1 = new testComparable(1);
		testComparable test2 = new testComparable(5);
		testComparable[] arr = new testComparable[] { test1, test2 };

		System.out.print("���� �� : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].getA() + " ");
		}

		Arrays.sort(arr);

		System.out.print("\n���� �� : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].getA() + " ");
		}
	}
}

class testComparable implements Comparable<testComparable> {

	private int a;

	public testComparable(int a) {
		super();
		this.a = a;
	}

	@Override
	public int compareTo(testComparable o) {

		if (this.a < o.a) {
			System.out.println("\n���ϰ� : 1");
			return 1;
		}

		System.out.println("\n���ϰ�  : -1");
		return -1;
	}

	public int getA() {
		return a;
	}
}