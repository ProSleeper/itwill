package com.Score4;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class ScoreImpl implements Score {

	private Map<String, ScoreVO> hMap = new TreeMap<>();

	Scanner sc = new Scanner(System.in);

	@Override
	public void inputData() {

		int result = 0;

		ScoreVO vo = null;


		//		vo = new ScoreVO();
		//		
		//		System.out.println("�й� ������.");
		//		vo.setHak(sc.next());

		//		if(searchHak(hak)) {
		//		System.out.println("�й��� �����մϴ�. �߰� ����!");
		//		return;
		//	}

		//		System.out.println("�̸� ������.");
		//		vo.setName(sc.next());
		//
		//		System.out.println("���� ������?");
		//		vo.setKor(sc.nextInt());
		//
		//		System.out.println("���� ������?.");
		//		vo.setEng(sc.nextInt());
		//
		//		System.out.println("���� ������?.");
		//		vo.setMat(sc.nextInt());

		String[] arrName = {"����", "�����", "�����", "��", "���", "���缮"};
		String[] arrHak = {"123", "1134", "5555", "6792", "23", "15"};
		int[] arrKor = {70, 50, 39, 20, 100, 60};
		int[] arrEng = {40, 59, 19, 89, 41, 50};
		int[] arrMat = {30, 15, 79, 90, 45, 78};

		for (int i = 0; i < arrMat.length; i++) {
			vo = new ScoreVO();

			//			�� �ڵ�� �ؾ��ϴµ� �Է� �����ϱ� �ϴ� �ּ�
			//			String inputStr = doInput();
			//			
			//			if(inputStr != null) {
			//				System.out.println("�й��� �����մϴ�. �߰� ����!");
			//				i--;
			//				continue;
			//			}
			vo.set(arrName[i], arrKor[i], arrEng[i], arrMat[i], arrKor[i]+arrEng[i]+ arrMat[i]);
			hMap.put(arrHak[i], vo);
			System.out.println("�߰� ����!!");
		}
		//boolean xx = hMap.containsKey("xx");
	}

	@Override
	public void print() {
		Iterator<String> it = hMap.keySet().iterator();

		while (it.hasNext()) {
			String hak =  it.next();
			ScoreVO vo = hMap.get(hak);
			System.out.println(hak + " " + vo.toString());
		}
	}

	@Override
	public void delete() {
		String inputStr = find();
		
		if(inputStr == null) {
			return;
		}
		System.out.println(hMap.get(inputStr) + "�� �������ϴ�.");
		hMap.remove(inputStr);
	}

	@Override
	public void update() {
		String inputStr = find();
		if(inputStr == null) {
			return;
		}
		
		System.out.println(hMap.get(inputStr).getName() + "�� ������ �����մϴ�.");
		System.out.println("���� ������ �Է����ּ���.");
		int kor = sc.nextInt();
		System.out.println("���� ������ �Է����ּ���.");
		int eng = sc.nextInt();
		System.out.println("���� ������ �Է����ּ���.");
		int mat = sc.nextInt();
		
		hMap.get(inputStr).set(kor, eng, mat);
	}

	@Override
	public String findHak(String pStr) {

		if(hMap.get(pStr) != null) {
			return pStr;
		}
		return null;
	}

	@Override
	public String findName(String pStr) {

		for( String strKey : hMap.keySet() ){
			if(hMap.get(strKey).getName().equals(pStr)) {
				return strKey;
			}
		}
		return null;
	}

	public String find()
	{
		System.out.println("�й��̳� �̸��� �Է��ϼ���.");	
		String inputStr = sc.next();
		String result = findHak(inputStr) == null ? findName(inputStr) : findHak(inputStr);
		
		if (result == null) {
			System.out.println("ã�� ������ �����ϴ�.");
			return result;
		}
		
		System.out.println(hMap.get(result) + "ã�ҽ��ϴ�.");
		return result;
		
	}
}
