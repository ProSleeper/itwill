package com.day14;

import java.util.Vector;

class Test{
	String name;
	int age;
}

public class Test3 {
	public static void main(String[] args) {
		Vector<Test> v = new Vector<>();
		
		Test ob = new Test();
		
		ob.name = "�����";
		ob.age = 27;
		v.add(ob);
		v.add(ob);
		v.add(ob);
		v.add(ob);
		
		//ob = new Test();
		ob.name = "���γ�";
		ob.age = 42;
		v.add(ob);
		
		for (Test test : v) {
			System.out.println(test.name + " " + test.age);
		}
	}
}
