package com.day18;

import java.io.Serializable;

public class MyData implements Serializable {
	private String name;
	private int score;
	
	
	public MyData(String pName, int pScore){
		this.setName(pName);
		this.setScore(pScore);
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
}
