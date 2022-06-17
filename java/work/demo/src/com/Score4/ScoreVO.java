package com.Score4;

public class ScoreVO {
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	
	
	
	public void set(String name, int kor, int eng, int mat, int tot) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
	}
	public void set(int kor, int eng, int mat) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
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
	public int getTot() {
		return kor + eng + mat;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	
	public String toString() {
		String str = String.format("%6s %4d %4d %4d %4d %4.1f", name, kor, eng, mat, getTot(), getTot()/3.0);
		return str;
	}
	
}
