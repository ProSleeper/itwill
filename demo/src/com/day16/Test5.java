package com.day16;

import java.util.List;
import java.util.ArrayList;

public class Test5 {
	public static void main(String[] args) {
		List<String> lists = new ArrayList<String>();

		lists.add("서울");
		lists.add("부산") ;
		lists.add("대구");
		lists.add("인천");
		for(String str : lists) {
			System.out.print(str + " ");
		}
		System.out. println("\n----------------------- ");

		lists.stream().forEach(a -> System.out.print(a + " "));

		System.out. println("\n----------------------- ");

		lists.stream().filter(x -> x.startsWith("부산")).forEach(x -> System.out.println(x + " "));

		System.out. println("\n----------------------- ");

		lists.stream().map(x -> x + 10).forEach(x -> System.out.println(x + " "));
	}
}
