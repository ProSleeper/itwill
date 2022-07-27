package com.day15;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Test3 {
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();

		st.push("서울");
		st.push("비었");
		st.push("부산");
		st.push("키보");
		st.push("없다");
		st.push("광주");
		st.push("크도");
		st.push("경보");
		st.push("사도");
		st.push("동네");
		st.push("클남");
		st.push("쿠룽");
		st.push("압박");
		st.push("포스");
		st.push("메모");
		st.push("아이");


		//while (!st.empty()) {
		//System.out.println(st.pop() + " ");
		//}


		Queue<String> q = new LinkedList<>();

		q.offer("서울");
		q.offer("비었");
		q.offer("부산");
		q.offer("키보");
		q.offer("없다");
		q.offer("광주");
		q.offer("크도");
		q.offer("경보");
		q.offer("사도");
		q.offer("동네");
		q.offer("클남");
		q.offer("쿠룽");
		q.offer("압박");
		q.offer("포스");
		q.offer("메모");
		q.offer("아이");
		q.add("울산");

		//		while (q.peek() != null) {
		//			System.out.println(q.poll() + " ");
		//		}
		//		

		List<String> list1 = new LinkedList<>();

		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		list1.add("f");
		list1.add("g");
		list1.add("h");
		list1.add("i");
		list1.add("j");
		list1.add("k");
		list1.add("l");


		List<String> list2 = new LinkedList<>();
		list2.add("서울");
		list2.add("부산");
		list2.add("대구");

		list2.addAll(list1);


		//System.out.println("list1...");

		for (String ss : list1) {
			//System.out.print(ss + " ");
		}

		//System.out.println("\n----------------");

		//System.out.println("list2...");
		for (String ss : list2) {
			//System.out.print(ss + " ");
		}

		//System.out.println("\n----------------");


		list2.subList(2, 5).clear();
		for (String ss : list2) {
			//System.out.print(ss + " ");
		}

		//System.out.println("\n----------------");


		String[] str = {"바", "가","사", "다", "나","라", "마"};

		for (String sss : str) {
			System.out.print(sss + " ");
		}
		System.out.println("\n----------------");

		Arrays.sort(str);
		for (String sss : str) {
			System.out.print(sss + " ");
		}
		System.out.println("\n----------------");

	}
}
