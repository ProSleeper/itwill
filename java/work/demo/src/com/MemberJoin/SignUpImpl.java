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
		String[] arrName = {"����", "�����", "�����", "��", "���", "���缮"};
		String[] arrEmail= {"pusew@nate.com", "suji@naver.com", "winlock@gmail.com", "sujeong@daum.net", "infor2@naver.com", "mmsor@hotmail.com"};
		String[] arrPhone = {"010-5545-2343", "010-1155-8239","010-4565-2798","010-7894-1235","010-8888-7894","010-9995-5678",};


		for (int i = 0; i < arrID.length; i++) {
			SignUpVO vo = new SignUpVO();
			vo.set(arrID[i], arrName[i], arrPassword[i], arrEmail[i], arrPhone[i]);
			vo.setJoinDate(year, month, day);

			memberDB.put(arrID[i], vo);
			System.out.println(arrName[i] + " �߰� ����!!");
		}
	}

	@Override
	public void Join() {
		//�����ϴ� �ڵ� �ۼ�

	}

	@Override
	public void LogIn() {
		if(checkData() != null) {
			System.out.println("�α��� ����!");
			return;
		}
	}

	@Override
	public void findID() {
		String eMailOrPhone = null;

		System.out.println("�̸��� Ȥ�� ��ȭ��ȣ�� �Է��ϼ���.");	
		eMailOrPhone = sc.next();

		for( String strKey : memberDB.keySet() ){
			if(memberDB.get(strKey).geteMail().equals(eMailOrPhone) || memberDB.get(strKey).getPhone().equals(eMailOrPhone)) {
				System.out.println("ID�� ã�ҽ��ϴ�.");
				System.out.println("ID��: " + memberDB.get(strKey).getId() + " �Դϴ�.");
				return;
			}
		}

		System.out.println("�߸��� ������ �Է��߽��ϴ�.");
		System.out.println("�Էµ� ������ Ȯ���ϼ���.");
		return;
	}

	@Override
	public void findPassword() {	//pStr�� ��й�ȣ
		String id = null;
		String eMailOrPhone = null;
		System.out.println("ID�� �Է��ϼ���.");	
		id = sc.next();
		System.out.println("�̸��� Ȥ�� ��ȭ��ȣ�� �Է��ϼ���.");	
		eMailOrPhone = sc.next();

		if (checkID(id)) {
			return;
		}
		if (memberDB.get(id).geteMail().equals(eMailOrPhone) || memberDB.get(id).getPhone().equals(eMailOrPhone)) {
			System.out.println("��й�ȣ�� ã�ҽ��ϴ�.");
			System.out.println("��й�ȣ��: " + memberDB.get(id).getPassword() + " �Դϴ�.");
			return;
		}
		System.out.println("�߸��� ������ �Է��߽��ϴ�.");
		System.out.println("�Էµ� ������ Ȯ���ϼ���.");
		return;
	}

	@Override
	public void EditProfile() {
		String pw = null;
		String eMail = null;
		String phone = null;

		String editKey = checkData();

		if(editKey != null) {
			System.out.println("������ �����մϴ�.\n");	
			System.out.println("��� ��ȣ�� �Է��ϼ���.");	
			pw = sc.next();
			System.out.println("�̸����� �Է��ϼ���.");	
			eMail = sc.next();
			System.out.println("��ȭ��ȣ�� �Է��ϼ���.");	
			phone = sc.next();

			memberDB.get(editKey).set(pw, eMail, phone);
			System.out.println("������ ����Ǿ����ϴ�.");	
		}
	}

	@Override
	public void cancelMember() {
		String moreCheck = null;

		String deleteKey = checkData();

		if(deleteKey != null) {
			System.out.println("���� ȸ�� Ż���Ͻðڽ��ϱ�?[Y/N]");
			moreCheck = sc.next();

			if(moreCheck.equals("Y") || moreCheck.equals("y")) {
				memberDB.remove(deleteKey);
				System.out.println("�̿��� �ּż� �����մϴ�.");
				return;
			}
		}
		System.out.println("##ȸ�� Ż�� ���� �ʾҽ��ϴ�.##");
	}

	public String checkData() {
		String id = null;
		String pw = null;

		System.out.println("ID�� �Է��ϼ���.");	
		id = sc.next();
		System.out.println("Password�� �Է��ϼ���.");	
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
			System.out.println("���� �� ȸ���� �ƴմϴ�.");
			return true;
		}
		return false;
	}
	
	public boolean checkPW(String id, String pw)
	{
		if (memberDB.get(id).getPassword().equals(pw)) {
			return true;
		}
		System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		System.out.println("��й�ȣ�� Ȯ���ϼ���.");
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
