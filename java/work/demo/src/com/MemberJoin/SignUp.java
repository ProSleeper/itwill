package com.MemberJoin;

public interface SignUp {
	public void inputData();	//이건 자동 입력만 받기
	
	public void Join();			//가입
	public void LogIn();		//로그인
	public void findID();		//아이디 찾기
	public void findPassword();	//비밀번호 찾기
	public void EditProfile();	//정보 수정
	public void cancelMember();	//회원 탈퇴
	public void print();		//출력
}