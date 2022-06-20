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
		String[] arrName = {"����", "�����", "�����", "��", "���", "���缮"};
		String[] arrEmail= {"pusew@nate.com", "suji@naver.com", "winlock@gmail.com", "sujeong@daum.net", "infor2@naver.com", "mmsor@hotmail.com"};
		String[] arrPhone = {"010-5545-2343", "010-1155-8239","010-4565-2798","010-7894-1235","010-8888-7894","010-9995-5678",};


		for (int i = 0; i < arrID.length; i++) {
			SignUpVO vo = new SignUpVO();
			vo.set(arrID[i], arrName[i], arrPassword[i], arrEmail[i], arrPhone[i]);
			vo.setJoinDate(year, month, day);

			memberDB.add(vo);
			System.out.println(arrName[i] + " �߰� ����!!");
		}
	}

	@Override
	public void Join() throws Exception {
		//�����ϴ� �ڵ� �ۼ�

		SignUpVO vo = new SignUpVO();

		
		while (true) {
			System.out.println("���̵� �Է����ּ���.");
			vo.setId(sc.next());
			iFormat.idCheck(vo.getId());
			
			if (checkID(vo.getId()) != null) {
				System.out.println("�̹� ������� ���̵��Դϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
			}
			else {
				break;
			}
		}
		
		
		
		//�׷��� ���̵��ε� �ߺ�üũ �κ� ����.
		
		System.out.println("��й�ȣ�� �Է����ּ���.");
		vo.setPassword(sc.next());
		System.out.println("�ѹ� �� ��й�ȣ�� �Է����ּ���.");
		
		iFormat.pwCheck(vo.getPassword(), sc.next());

		//���̵�� ��й�ȣ�� ����ó�� �������� �׳� �Է�.

		System.out.println("�̸��� �Է����ּ���.");
		vo.setName(sc.next());
		System.out.println("������ �Է����ּ���.");
		vo.setGender(sc.next());
		System.out.println("������ �Է����ּ���.(ex. 990804");
		vo.setBirth(sc.next());
		System.out.println("E-MAIL�� �Է����ּ���.");
		vo.seteMail(sc.next());
		System.out.println("��ȭ��ȣ�� �Է����ּ���.");
		vo.setPhone(sc.next());

		memberDB.add(vo);
		System.out.println(vo.getName() + " ���� ����!!");
		
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

		for( SignUpVO strKey : memberDB ){
			if(strKey.geteMail().equals(eMailOrPhone) || strKey.getPhone().equals(eMailOrPhone)) {
				System.out.println("ID�� ã�ҽ��ϴ�.");
				System.out.println("ID��: " + strKey.getId() + " �Դϴ�.");
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

		if (checkID(id) == null) {
			return;
		}

		for( SignUpVO strKey : memberDB ){
			if(strKey.geteMail().equals(eMailOrPhone) || strKey.getPhone().equals(eMailOrPhone)) {
				System.out.println("��й�ȣ�� ã�ҽ��ϴ�.");
				System.out.println("��й�ȣ��: " + strKey.getPassword() + " �Դϴ�.");
				return;
			}
		}

		System.out.println("�߸��� ������ �Է��߽��ϴ�.");
		System.out.println("�Էµ� ������ Ȯ���ϼ���.");
		return;
	}

	@Override
	public void EditProfile() {
		String pw = null;
		String name = null;  
		String gender = null; 
		String eMail = null;
		String phone = null;
		
		  
		  
		SignUpVO editKey = checkData();	//���� �κ��� ��ü�� ���ؼ� editKey�� �����ϴ� ������� �����ҵ� list��

		if(editKey != null) {
			System.out.println("������ �����մϴ�.\n");	
			System.out.println("��� ��ȣ�� �Է��ϼ���.");	
			pw = sc.next();
			System.out.println("�̸��� �Է��ϼ���.");	
			name = sc.next();
			System.out.println("������ �Է��ϼ���.");	
			gender = sc.next();
			System.out.println("�̸����� �Է��ϼ���.");	
			eMail = sc.next();
			System.out.println("��ȭ��ȣ�� �Է��ϼ���.");	
			phone = sc.next();

			editKey.set(pw, name, gender, eMail, phone);
			System.out.println("������ ����Ǿ����ϴ�.");	
		}
	}

	@Override
	public void cancelMember() {
		String moreCheck = null;

		SignUpVO deleteKey = checkData();

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

	public SignUpVO checkData() {
		String id = null;
		String pw = null;

		System.out.println("ID�� �Է��ϼ���.");	
		id = sc.next();
		System.out.println("Password�� �Է��ϼ���.");	
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
//				System.out.println("���̵� ã�ҽ��ϴ�.");
				return strKey; //���� ����ϴ� �κ��� ������ ������.
			}
		}
//		System.out.println("���� �� ȸ���� �ƴմϴ�.");
		return null;
	}

	public SignUpVO checkPW(String id, String pw)
	{
		
		for( SignUpVO strKey : memberDB ){
			if(strKey.getId().equals(id) && strKey.getPassword().equals(pw)) {
				return strKey; //���� ����ϴ� �κ��� ������ ������.
			}
		}
		System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		System.out.println("��й�ȣ�� Ȯ���ϼ���.");
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