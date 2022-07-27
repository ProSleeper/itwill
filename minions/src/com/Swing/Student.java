package com.Swing;

public class Student {
	String name;
	int kor;
	int eng;
	int mat;
	int sum;
	double avg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getSum() {
		return sum;
	}
	public void setSum(int kor,int eng,int mat) {
		sum = kor+eng+mat;
		avg = sum/3.f;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public void Modify(int kor,int eng,int mat){
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
		result();
	}

	public void result(){
		avg=sum/3.f;
	}
}
