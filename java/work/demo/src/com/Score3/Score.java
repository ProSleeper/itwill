package com.Score3;

public interface Score {
	
	
	//상속 받을 건데 왜 퍼블릭인지?
	//이걸 강제 하기 위해서 interface를 만드는건지?
	public int input();
	
	void print();
	void deleteHak();
	
	void searchHak();
	
	void searchName();
	
	void descSortTot();
	
	void ascSortHak();
	
}








