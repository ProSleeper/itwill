package com.day14;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test2 {
	private static String city[] = {"����", "�λ�", "�뱸", "��õ", "����", "����", "���"};
	static Vector<String> v;
	
	public static void print(){
		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		System.out.println("���� ����: " + v.capacity());
		System.out.println("������ ����: " + v.size() + "��");
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

		System.out.println(v.size() +  "��");

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
			System.out.println("����");

		}

		System.out.println();

		v.set(0, "Seoul");
		v.set(1, "Pusan");

		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();


		//����
		v.insertElementAt("���ѹα�", 0);
		System.out.println(v.size() +  "��");

		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();


		int idx = v.indexOf("�뱸1");

		if (idx != -1) {
			System.out.println("�˻�����" + idx);
		}
		else {
			System.out.println("�˻�����" + idx);
		}


		Collections.sort(v);

		System.out.println(v.size() +  "��");

		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();



		Collections.sort(v, Collections.reverseOrder());

		System.out.println(v.size() +  "��");

		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		v.remove("Pusan");	//���������� String �񱳰� �ִ°ǰ�? �ƴϸ� new String("Pusan") �̷��� ���ǰ�?
		
		for (String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		System.out.println("���� ����: " + v.capacity());
		System.out.println("������ ����: " + v.size() + "��");
		
		
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
		
		
		System.out.println("���� ����: " + v.capacity());
		System.out.println("������ ����: " + v.size() + "��");
		
		v.clear();
		v.trimToSize();
		print();
		
		System.out.println("�٢ִϢٹ٢ִϢٹ٢ִϢٹ٢ִϢ�          �٢� �Ϣֹ٢� �Ϣֹ٢� �Ϣֹ٢� �Ϣ�");
	}
}

//import java.io.*;
//
////�̺�Ž������ Ǯ����ϴ� ����
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



