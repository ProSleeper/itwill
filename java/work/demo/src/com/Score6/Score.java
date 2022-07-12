package com.Score6;

import java.util.Scanner;

public class Score {
	Scanner sc = new Scanner(System.in);
	ScoreDAO dao = new ScoreDAO();

	//입력
	public void insert() {
		ScoreDTO dto = new ScoreDTO();

		System.out.println("학번?");
		dto.setHak(sc.next());

		System.out.println("이름?");
		dto.setName(sc.next());		

		System.out.println("국어?");
		dto.setKor(sc.nextInt());		

		System.out.println("영어?");
		dto.setEng(sc.nextInt());	

		System.out.println("수학?");
		dto.setMat(sc.nextInt());	

		int result = dao.insertData(dto);
		if(result != 0) {
			System.out.println("추가 성공!!");
		}
		else {
			System.out.println("추가 실패!!");
		}
	}

	//수정
	public void update() {
		ScoreDTO dto = new ScoreDTO();

		System.out.println("수정할 학번?");
		dto.setHak(sc.next());

		System.out.println("국어?");
		dto.setKor(sc.nextInt());		

		System.out.println("영어?");
		dto.setEng(sc.nextInt());	

		System.out.println("수학?");
		dto.setMat(sc.nextInt());	

		int result = dao.updateData(dto);

		if(result != 0) {
			System.out.println("수정 성공!!");
		}
		else {
			System.out.println("수정 실패!!");
		}
	}

	//삭제
	public void delete() {
		ScoreDTO dto = new ScoreDTO();

		System.out.println("삭제할 학번?");
		int result = dao.deleteData(sc.next());

		if(result != 0) {
			System.out.println("삭제 성공!!");
		}
		else {
			System.out.println("삭제 실패!!");
		}
	}
}




















