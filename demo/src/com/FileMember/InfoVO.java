package com.FileMember;

import java.io.Serializable;

public class InfoVO implements Serializable{
	private String name;
	private String birth;
	private String score;
	
	
	public InfoVO(String name, String birth, String score) {
		super();
		this.name = name;
		this.birth = birth;
		this.score = score;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirth() {
		return birth;
	}
	

	public void setBirth(String birth) {
		this.birth = birth;
	}

	
	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}


	public String toString() {
		String str = String.format("%6s %10s %10s", name, birth, score);
		return str;
	}
}
