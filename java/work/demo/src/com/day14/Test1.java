package com.day14;

import java.util.Vector;

// 설명 해볼 것


class Parent{
	public int number = 1;
	public void superNumber(){
		System.out.println(number);
		
	}
}

class Child extends Parent{
	public int number = 7;
	
	public void superNumber(){
		System.out.println(super.number);
		
	}
}

public class Test1 {
	
	public static void main(String[] args) {
		Child son = new Child();
		Parent par = new Parent();
		par = son;
		
		System.out.println(son.number);
		
		System.out.println(par.number);
		
		//par.superNumber();
//		son.superNumber();
		//System.out.println(par.number);
	}
}



//public class Test1 {
//	
//	
//	public static void main(String[] args) {
//		
//		Vector v = new Vector<>();
//		
//		v.add("서울");
//		v.add(30);
//		v.add('A');
//		
//		String str;
//		
//		str = (String)(v.get(0));
//		System.out.println(str);
//		
//		int i = (Integer)(v.get(1));
//		System.out.println(i);
//		
//		char c = (Character)(v.get(2));
//		System.out.println(c);
//		
//		for (int j = 0; j < args.length; j++) {
//			Object ob = v.get(j);
//			
//			if(ob instanceof String) {
//				str = (String)ob;
//				System.out.println(str);
//				
//			}
//			else if(ob instanceof Integer) {	//여기서 int와 integer말고 int로 해도 되는가
//				i = (int)i;
//				System.out.println(i);
//			}
//			else if(ob instanceof Character) {
//				c = (char)c;
//				System.out.println(c);
//			}
//		}
//	}
//}











