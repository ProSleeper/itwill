package com.MemberJoin;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class SignUpImpl implements SignUp {

	private Map<String, SignUpVO> memberDB = new TreeMap<>();
	Calendar now = Calendar.getInstance();

	Scanner sc = new Scanner(System.in);

	@Override
	public void inputData() {
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DATE);

		String[] arrID = {"seong", "ignigngni", "contact92", "taijyun75", "love1549", "cocacolazero"};
		String[] arrPassword = {"coc11233j", "dh3oe02h391", "dbwotjrdhkswjs99", "wjdqhtnwjd55", "lowsodatem1", "lightguy22"};
		String[] arrName = {"지디", "배수지", "김봉남", "딘", "딘딘", "유재석"};
		String[] arrEmail= {"pusew@nate.com", "suji@naver.com", "winlock@gmail.com", "sujeong@daum.net", "infor2@naver.com", "mmsor@hotmail.com"};
		String[] arrPhone = {"010-5545-2343", "010-1155-8239","010-4565-2798","010-7894-1235","010-8888-7894","010-9995-5678",};


		for (int i = 0; i < arrID.length; i++) {
			SignUpVO vo = new SignUpVO();
			vo.set(arrID[i], arrName[i], arrPassword[i], arrEmail[i], arrPhone[i]);
			vo.setJoinDate(year, month, day);

			memberDB.put(arrID[i], vo);
			System.out.println(arrName[i] + " 추가 성공!!");
		}
	}

	@Override
	public void Join() {
		//가입하는 코드 작성

	}

	@Override
	public void LogIn() {
		if(checkData() != null) {
			System.out.println("로그인 성공!");
			return;
		}
	}

	@Override
	public void findID() {
		String eMailOrPhone = null;

		System.out.println("이메일 혹은 전화번호를 입력하세요.");	
		eMailOrPhone = sc.next();

		for( String strKey : memberDB.keySet() ){
			if(memberDB.get(strKey).geteMail().equals(eMailOrPhone) || memberDB.get(strKey).getPhone().equals(eMailOrPhone)) {
				System.out.println("ID를 찾았습니다.");
				System.out.println("ID는: " + memberDB.get(strKey).getId() + " 입니다.");
				return;
			}
		}

		System.out.println("잘못된 정보를 입력했습니다.");
		System.out.println("입력된 정보를 확인하세요.");
		return;
	}

	@Override
	public void findPassword() {	//pStr은 비밀번호
		String id = null;
		String eMailOrPhone = null;
		System.out.println("ID를 입력하세요.");	
		id = sc.next();
		System.out.println("이메일 혹은 전화번호를 입력하세요.");	
		eMailOrPhone = sc.next();

		if (checkID(id)) {
			return;
		}
		if (memberDB.get(id).geteMail().equals(eMailOrPhone) || memberDB.get(id).getPhone().equals(eMailOrPhone)) {
			System.out.println("비밀번호를 찾았습니다.");
			System.out.println("비밀번호는: " + memberDB.get(id).getPassword() + " 입니다.");
			return;
		}
		System.out.println("잘못된 정보를 입력했습니다.");
		System.out.println("입력된 정보를 확인하세요.");
		return;
	}

	@Override
	public void EditProfile() {
		String pw = null;
		String eMail = null;
		String phone = null;

		String editKey = checkData();

		if(editKey != null) {
			System.out.println("정보를 변경합니다.\n");	
			System.out.println("비밀 번호를 입력하세요.");	
			pw = sc.next();
			System.out.println("이메일을 입력하세요.");	
			eMail = sc.next();
			System.out.println("전화번호를 입력하세요.");	
			phone = sc.next();

			memberDB.get(editKey).set(pw, eMail, phone);
			System.out.println("정보가 변경되었습니다.");	
		}
	}

	@Override
	public void cancelMember() {
		String moreCheck = null;

		String deleteKey = checkData();

		if(deleteKey != null) {
			System.out.println("정말 회원 탈퇴하시겠습니까?[Y/N]");
			moreCheck = sc.next();

			if(moreCheck.equals("Y") || moreCheck.equals("y")) {
				memberDB.remove(deleteKey);
				System.out.println("이용해 주셔서 감사합니다.");
				return;
			}
		}
		System.out.println("##회원 탈퇴가 되지 않았습니다.##");
	}

	public String checkData() {
		String id = null;
		String pw = null;

		System.out.println("ID를 입력하세요.");	
		id = sc.next();
		System.out.println("Password를 입력하세요.");	
		pw = sc.next();
		if (checkID(id)) {
			return null;
		}
		if (checkPW(id, pw)) {
			return memberDB.get(id).getId();
		}
		return null;
	}
	
	public boolean checkID(String id)
	{
		if (memberDB.get(id) == null) {
			System.out.println("가입 된 회원이 아닙니다.");
			return true;
		}
		return false;
	}
	
	public boolean checkPW(String id, String pw)
	{
		if (memberDB.get(id).getPassword().equals(pw)) {
			return true;
		}
		System.out.println("비밀번호가 틀렸습니다.");
		System.out.println("비밀번호를 확인하세요.");
		return false;
	}
	
	@Override
	public void print() {
		Iterator<String> it = memberDB.keySet().iterator();

		while (it.hasNext()) {
			SignUpVO vo = memberDB.get(it.next());
			System.out.print(vo.toString());
		}
	}
}
