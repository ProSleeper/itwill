package com.Score3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreImpl implements Score {

	private ArrayList<ScoreVO> lists = new ArrayList<>();
	Scanner sc = new Scanner(System.in);


	@Override
	public int input() {

		int result = 0;

//		Scanner sc = new Scanner(System.in);
//
		ScoreVO vo = null;
//
//		System.out.println("학번 쓰세요.");
//		vo.setHak(sc.next());
//
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
			vo.set(arrHak[i], arrName[i], arrKor[i], arrEng[i], arrMat[i]);
			vo.setTot(arrKor[i]+arrEng[i]+ arrMat[i]);
			lists.add(vo);
		}

		descSortTot();

		return result;
	}

	@Override
	public void print() {

		Iterator<ScoreVO> it = lists.iterator();
		while (it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.printf("%5s %6s %4d %4d %4d %4d %4.1f\n",
					vo.getHak(),vo.getName(),
					vo.getKor(),vo.getEng(),vo.getMat(),
					(vo.getKor()+vo.getEng()+vo.getMat()),
					(vo.getKor()+vo.getEng()+vo.getMat())/3.0);			        
		}
	}


	@Override
	public void searchHak() {

		System.out.print("?");//222
		String hak = sc.next();
		Iterator<ScoreVO> it = lists. iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(hak.equals(vo.getHak())) {
				System.out.println(vo.toString());
				break;
			}
		}			
	}


	@Override
	public void searchName() {
		System.out.print("?");//222
		String name = sc.next();
		Iterator<ScoreVO> it = lists. iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(name.equals(vo.getName())) {
				System.out.println(vo.toString());
			}
		}
	}

	//학번 오름차순
	@Override
	public void ascSortHak() {
		Comparator<ScoreVO> comp2 = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {

				
				
				if (Integer.parseInt(vo2.getHak()) > Integer.parseInt(vo1.getHak()) ) {
					return -1;
				}
				
				return 0;
			}
		};
		Collections.sort(lists, comp2);
	}
	
	//총점 내림차순 정렬
	@Override
	public void descSortTot() {

		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			//이 Comparator를 사용하는 방법 1은
		
			
			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				if (vo1.getTot() > vo2.getTot()) {
					return -1;
				}
				return 0;
			}
		};
		
		//첫번째 인자가 두번째 인자보다 작다면 음수, 같다면 0, 크다면 양수를 리턴하면 됩니다.

		Collections.sort(lists, comp);
		
	}

	@Override
	public void deleteHak() {
		
		System.out.print("?");//222
		String hak = sc.next();
		Iterator<ScoreVO> it = lists. iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(hak.equals(vo.getHak())) {
				System.out.println(vo.toString());
				lists.remove(vo);
			}
		}	
	}
	@Override
	public void deleteName() {
		
		System.out.println("?");//2220
		String name = sc.next();
		Iterator<ScoreVO> it = lists. iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(name.equals(vo.getName())) {
				lists.remove(vo);
				System.out.println(vo.getName());
			}
			System.out.println("해위");
		}
	}
}


