package com.day16;

import java.util.List;
import java.util.ArrayList;

public class Test5 {
	public static void main(String[] args) {
		List<String> lists = new ArrayList<String>();

		lists.add("����");
		lists.add("�λ�") ;
		lists.add("�뱸");
		lists.add("��õ");
		for(String str : lists) {
			System.out.print(str + " ");
		}
		System.out. println("\n----------------------- ");

		lists.stream().forEach(a -> System.out.print(a + " "));

		System.out. println("\n----------------------- ");

		lists.stream().filter(x -> x.startsWith("�λ�")).forEach(x -> System.out.println(x + " "));

		System.out. println("\n----------------------- ");

		lists.stream().map(x -> x + 10).forEach(x -> System.out.println(x + " "));
	}
}
