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

		st.push("����");
		st.push("���");
		st.push("�λ�");
		st.push("Ű��");
		st.push("����");
		st.push("����");
		st.push("ũ��");
		st.push("�溸");
		st.push("�絵");
		st.push("����");
		st.push("Ŭ��");
		st.push("���");
		st.push("�й�");
		st.push("����");
		st.push("�޸�");
		st.push("����");


		//while (!st.empty()) {
		//System.out.println(st.pop() + " ");
		//}


		Queue<String> q = new LinkedList<>();

		q.offer("����");
		q.offer("���");
		q.offer("�λ�");
		q.offer("Ű��");
		q.offer("����");
		q.offer("����");
		q.offer("ũ��");
		q.offer("�溸");
		q.offer("�絵");
		q.offer("����");
		q.offer("Ŭ��");
		q.offer("���");
		q.offer("�й�");
		q.offer("����");
		q.offer("�޸�");
		q.offer("����");
		q.add("���");

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
		list2.add("����");
		list2.add("�λ�");
		list2.add("�뱸");

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


		String[] str = {"��", "��","��", "��", "��","��", "��"};

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
