package com.MemberJoin;

public class SignUpVO {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String birth;
	private String eMail;
	private String phone;
	private String joinDate;
	
	public void set(String id, String password, String name, String gender, String birth, String eMail, String phone, String joinDate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.eMail = eMail;
		this.phone = phone;
		this.joinDate = joinDate;
	}
	public void set(String password, String name, String gender, String eMail, String phone) {
		this.password = password;
		this.eMail = eMail;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Integer pYear, Integer pMonth, Integer pDay) {
		this.joinDate = pYear.toString() + "-" +  String.format("%02d", pMonth) + "-" + String.format("%02d", pDay);
	}
	public String toString() {
		String str = String.format("%10s %10s %10s %10s %10s %10s\n", id, name, gender, birth, eMail, phone/*, joinDate*/);
		return str;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
}
