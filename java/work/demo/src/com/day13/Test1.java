package com.day13;


interface Fruit{
	String won = "원";	//public
	
	int getPrice();	//public, abstract 생략됨
	public String getName();	//abstract 생략됨
}

class FruitImpl implements Fruit{
	
	public int getPrice(){
		return 1000;
	}
	public String getName() {
		return "사과";
	}
	public String getItems() {
		return "과일";
	}	
}

public class Test1 {
	public static void main(String[] args) {
		FruitImpl ob1 = new FruitImpl();
		
		System.out.println(ob1.getItems());
		System.out.println(ob1.getName());
		System.out.println(ob1.getPrice() + Fruit.won);
		
		Fruit ob2 = ob1;
		
		System.out.println(ob2.getName());
		
	}
}
