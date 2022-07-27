package com.Score6;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score {

	Scanner sc = new Scanner(System.in);
	ScoreDAO dao = new ScoreDAO();
	List<ScoreDTO> allData = null;
	
	
	
	//입력
	@Override
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
	@Override
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
	@Override
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

	@Override
	public void selectAll() {

		allData = dao.getList();

		print();
	}

	@Override
	public void searchName() {
		
		System.out.println("검색할 이름?");
		String name = sc.next();
		
		allData = dao.getList(name);

		print();
		
	}
	
	@Override
	public void searchHak() {
		
		System.out.println("검색할 학번?");
		String hak = sc.next();
		ScoreDTO dto = dao.getLists(hak);
		
		if(dto == null) {
			System.out.println("입력한 학번이 없습니다.");
			return;
		}
		System.out.println(dto.toString());
	}
	
	public void print(){
		Iterator<ScoreDTO> iter = allData.iterator();

		while (iter.hasNext()) {
			ScoreDTO scoreDTO = (ScoreDTO) iter.next();
			
			if(scoreDTO.getRank() == 0) {
				System.out.println(scoreDTO.toString());
			}
			else {
				System.out.println(scoreDTO.toString() + "    " + scoreDTO.getRank());
			}	
		}
	}

}












