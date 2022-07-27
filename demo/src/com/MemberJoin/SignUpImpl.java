package com.MemberJoin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class SignUpImpl implements SignUp {

	private ArrayList<SignUpVO> memberDB = new ArrayList<>();
	Calendar now = Calendar.getInstance();
	
	InputFormat iFormat = new InputFormat();	

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

			memberDB.add(vo);
			System.out.println(arrName[i] + " 추가 성공!!");
		}
	}

	@Override
	public void Join() throws Exception {
		//가입하는 코드 작성

		SignUpVO vo = new SignUpVO();

		
		while (true) {
			System.out.println("아이디를 입력해주세요.");
			vo.setId(sc.next());
			iFormat.idCheck(vo.getId());
			
			if (checkID(vo.getId()) != null) {
				System.out.println("이미 사용중인 아이디입니다.");
				System.out.println("다시 입력해주세요.");
			}
			else {
				break;
			}
		}
		
		
		
		//그래도 아이디인데 중복체크 부분 넣자.
		
		System.out.println("비밀번호를 입력해주세요.");
		vo.setPassword(sc.next());
		System.out.println("한번 더 비밀번호를 입력해주세요.");
		
		iFormat.pwCheck(vo.getPassword(), sc.next());

		//아이디와 비밀번호만 예외처리 나머지는 그냥 입력.

		System.out.println("이름을 입력해주세요.");
		vo.setName(sc.next());
		System.out.println("성별을 입력해주세요.");
		vo.setGender(sc.next());
		System.out.println("생일을 입력해주세요.(ex. 990804");
		vo.setBirth(sc.next());
		System.out.println("E-MAIL을 입력해주세요.");
		vo.seteMail(sc.next());
		System.out.println("전화번호를 입력해주세요.");
		vo.setPhone(sc.next());

		memberDB.add(vo);
		System.out.println(vo.getName() + " 가입 성공!!");
		
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

		for( SignUpVO strKey : memberDB ){
			if(strKey.geteMail().equals(eMailOrPhone) || strKey.getPhone().equals(eMailOrPhone)) {
				System.out.println("ID를 찾았습니다.");
				System.out.println("ID는: " + strKey.getId() + " 입니다.");
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

		if (checkID(id) == null) {
			return;
		}

		for( SignUpVO strKey : memberDB ){
			if(strKey.geteMail().equals(eMailOrPhone) || strKey.getPhone().equals(eMailOrPhone)) {
				System.out.println("비밀번호를 찾았습니다.");
				System.out.println("비밀번호는: " + strKey.getPassword() + " 입니다.");
				return;
			}
		}

		System.out.println("잘못된 정보를 입력했습니다.");
		System.out.println("입력된 정보를 확인하세요.");
		return;
	}

	@Override
	public void EditProfile() {
		String pw = null;
		String name = null;  
		String gender = null; 
		String eMail = null;
		String phone = null;
		
		  
		  
		SignUpVO editKey = checkData();	//여기 부분이 객체로 변해서 editKey를 수정하는 방식으로 가야할듯 list라서

		if(editKey != null) {
			System.out.println("정보를 변경합니다.\n");	
			System.out.println("비밀 번호를 입력하세요.");	
			pw = sc.next();
			System.out.println("이름을 입력하세요.");	
			name = sc.next();
			System.out.println("성별을 입력하세요.");	
			gender = sc.next();
			System.out.println("이메일을 입력하세요.");	
			eMail = sc.next();
			System.out.println("전화번호를 입력하세요.");	
			phone = sc.next();

			editKey.set(pw, name, gender, eMail, phone);
			System.out.println("정보가 변경되었습니다.");	
		}
	}

	@Override
	public void cancelMember() {
		String moreCheck = null;

		SignUpVO deleteKey = checkData();

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

	public SignUpVO checkData() {
		String id = null;
		String pw = null;

		System.out.println("ID를 입력하세요.");	
		id = sc.next();
		System.out.println("Password를 입력하세요.");	
		pw = sc.next();
		if (checkID(id) == null) {
			return null;
		}
		
		SignUpVO removeObject = checkPW(id, pw);
		
		if (removeObject != null) {
			return removeObject;
		}
		return null;
	}

	public SignUpVO checkID(String id)
	{
		for( SignUpVO strKey : memberDB ){
			if(strKey.getId().equals(id)) {
//				System.out.println("아이디를 찾았습니다.");
				return strKey; //여긴 사용하는 부분의 조건을 봐야함.
			}
		}
//		System.out.println("가입 된 회원이 아닙니다.");
		return null;
	}

	public SignUpVO checkPW(String id, String pw)
	{
		
		for( SignUpVO strKey : memberDB ){
			if(strKey.getId().equals(id) && strKey.getPassword().equals(pw)) {
				return strKey; //여긴 사용하는 부분의 조건을 봐야함.
			}
		}
		System.out.println("비밀번호가 틀렸습니다.");
		System.out.println("비밀번호를 확인하세요.");
		return null;
	}

	@Override
	public void print() {
		Iterator<SignUpVO> it = memberDB.iterator();

		while (it.hasNext()) {
			SignUpVO vo = it.next();
			System.out.print(vo.toString());
		}
	}
}