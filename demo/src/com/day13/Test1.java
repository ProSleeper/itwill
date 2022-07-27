package com.day13;


interface Fruit{
	String won = "��";	//public
	
	int getPrice();	//public, abstract ������
	public String getName();	//abstract ������
}

class FruitImpl implements Fruit{
	
	public int getPrice(){
		return 1000;
	}
	public String getName() {
		return "���";
	}
	public String getItems() {
		return "����";
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
