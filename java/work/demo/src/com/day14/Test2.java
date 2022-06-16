package com.day14;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test2 {
	private static String city[] = {"서울", "부산", "대구", "인천", "광주", "대전", "울산"};
	static Vector<String> v;
	
	public static void print(){
		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		System.out.println("공간 갯수: " + v.capacity());
		System.out.println("데이터 갯수: " + v.size() + "개");
	}

	public static void main(String[] args) {
		
		v = new Vector<>();


		for (String string : city) {
			v.add(string);
		}


		String str;

		str = v.firstElement();
		System.out.println(str);

		str = v.get(1);
		System.out.println(str);

		str = v.lastElement();
		System.out.println(str);

		System.out.println(v.size() +  "개");

		for (String string : v) {
			System.out.print(string + " ");
		}

		System.out.println();


		for (String c : v) {
			System.out.print(c + " ");
		}

		System.out.println();

		Iterator<String> iter = v.iterator();
		while (iter.hasNext()) {

			str = iter.next();
			System.out.print(str + " ");

		}

		while (iter.hasNext()) {

			str = iter.next();
			System.out.print(str + " ");
			System.out.println("하위");

		}

		System.out.println();

		v.set(0, "Seoul");
		v.set(1, "Pusan");

		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();


		//삽입
		v.insertElementAt("대한민국", 0);
		System.out.println(v.size() +  "개");

		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();


		int idx = v.indexOf("대구1");

		if (idx != -1) {
			System.out.println("검색성공" + idx);
		}
		else {
			System.out.println("검색실패" + idx);
		}


		Collections.sort(v);

		System.out.println(v.size() +  "개");

		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();



		Collections.sort(v, Collections.reverseOrder());

		System.out.println(v.size() +  "개");

		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		v.remove("Pusan");	//내부적으로 String 비교가 있는건가? 아니면 new String("Pusan") 이렇게 들어간건가?
		
		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		System.out.println("공간 갯수: " + v.capacity());
		System.out.println("데이터 갯수: " + v.size() + "개");
		
		
		for (int i = 1; i <= 20;i++) {
			v.add(Integer.toString(i));
		}
		
		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		for (int i = 1; i <= 10;i++) {
			v.remove(5);
		}
		
		v.trimToSize();
		print();
		
		
		System.out.println("공간 갯수: " + v.capacity());
		System.out.println("데이터 갯수: " + v.size() + "개");
		
		v.clear();
		v.trimToSize();
		print();
		
		System.out.println("바↗니↘바↗니↘바↗니↘바↗니↘          바↘ 니↗바↘ 니↗바↘ 니↗바↘ 니↗");
	}
}

//import java.io.*;
//
////이분탐색으로 풀어야하는 문제
//
//public class baek10815 {
//
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int n = br.read();
//		br.readLine();
//		String nstr = br.readLine();
//		int m = br.read();
//		br.readLine();
//		String[] marr = br.readLine().split(" ");
//		
//		for (int i=0;i<marr.length;i++) {
//			if(nstr.contains(marr[i])) {
//				System.out.print("1 ");
//			} else {
//				System.out.print("0 ");
//			}
//
//		}
//
//
//	}
//
//}



