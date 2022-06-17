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
		//		System.out.println("학번 쓰세요.");
		//		vo.setHak(sc.next());

		//		if(searchHak(hak)) {
		//		System.out.println("학번이 존재합니다. 추가 실패!");
		//		return;
		//	}

		//		System.out.println("이름 쓰세요.");
		//		vo.setName(sc.next());
		//
		//		System.out.println("국어 점수는?");
		//		vo.setKor(sc.nextInt());
		//
		//		System.out.println("영어 점수는?.");
		//		vo.setEng(sc.nextInt());
		//
		//		System.out.println("수학 점수는?.");
		//		vo.setMat(sc.nextInt());

		String[] arrName = {"지디", "배수지", "김봉남", "딘", "딘딘", "유재석"};
		String[] arrHak = {"123", "1134", "5555", "6792", "23", "15"};
		int[] arrKor = {70, 50, 39, 20, 100, 60};
		int[] arrEng = {40, 59, 19, 89, 41, 50};
		int[] arrMat = {30, 15, 79, 90, 45, 78};

		for (int i = 0; i < arrMat.length; i++) {
			vo = new ScoreVO();

			//			이 코드로 해야하는데 입력 받으니까 일단 주석
			//			String inputStr = doInput();
			//			
			//			if(inputStr != null) {
			//				System.out.println("학번이 존재합니다. 추가 실패!");
			//				i--;
			//				continue;
			//			}
			vo.set(arrName[i], arrKor[i], arrEng[i], arrMat[i], arrKor[i]+arrEng[i]+ arrMat[i]);
			hMap.put(arrHak[i], vo);
			System.out.println("추가 성공!!");
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
		System.out.println(hMap.get(inputStr) + "를 지웠습니다.");
		hMap.remove(inputStr);
	}

	@Override
	public void update() {
		String inputStr = find();
		if(inputStr == null) {
			return;
		}
		
		System.out.println(hMap.get(inputStr).getName() + "의 정보를 수정합니다.");
		System.out.println("국어 점수를 입력해주세요.");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력해주세요.");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력해주세요.");
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
		System.out.println("학번이나 이름을 입력하세요.");	
		String inputStr = sc.next();
		String result = findHak(inputStr) == null ? findName(inputStr) : findHak(inputStr);
		
		if (result == null) {
			System.out.println("찾는 정보가 없습니다.");
			return result;
		}
		
		System.out.println(hMap.get(result) + "찾았습니다.");
		return result;
		
	}
}
