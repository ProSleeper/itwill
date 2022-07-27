package com.day13;

interface Test{
	
	public int total();
	public void write();
}

class TestImpl implements Test{

	private String hak, name;
	private int kor, eng;
	
	
	
	public TestImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TestImpl(String hak, String name, int kor, int eng) {
		super();
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	public void setData(String hak, String name, int kor, int eng) {
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	
	@Override
	public int total() {
		return 0;
	}

	@Override
	public void write() {
	}
	
}


public class Test2 {
	
}
