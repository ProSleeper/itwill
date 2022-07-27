package com.day16;

class MyException extends Exception{
	private static final long serialVersionUID = 1L;


	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}

public class Test3 {
	
	private int value;
	
	public void setValue1(int pValue) throws MyException{
		if (pValue < 0) {
			throw new MyException("수는 0보다 작을 수 없습니다.");
		}
		else {
			this.value = pValue;
		}
	}
	
	public void setValue2(int pValue) throws MyException{
		if (pValue > 10) {
			throw new MyException("수는 10보다 클 수 없습니다.");
		}
		else {
			this.value = pValue;
		}
	}
	
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {

		Test3 ob = new Test3();
		
		try {
			//ob.setValue1(-20);
			ob.setValue2(20);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(ob.getValue());
	}
}
