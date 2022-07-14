package com.guest;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GuestImpl implements Guest {
	Scanner sc = new Scanner(System.in);
	GuestDAO dao = new GuestDAO();
	List<GuestDTO[]> allData = null;
	boolean loggedIn = false;

	//입력
	@Override
	public void writeInfo() {
		GuestCustomDTO dto = new GuestCustomDTO();

		System.out.print("아이디?: ");
		dto.setId(sc.nextLine());

		System.out.print("비밀번호?: ");
		dto.setPw(sc.nextLine());		

		System.out.println("이름?: ");
		dto.setName(sc.nextLine());		

		int result = dao.writeInfo(dto);

		if(result != 0) {
			System.out.println("추가 성공!!");
		}
		else {
			System.out.println("추가 실패!!");
		}
	}
	
	//방명록 수정
		@Override
		public void updateRecord() {
			
			String id = checkData();
			
			if(id == null) {
				return;
			}
			
			GuestRecordDTO dto = new GuestRecordDTO();

			dto.setId(id);

			System.out.println("방명록 입력");
			dto.setG_content(sc.nextLine());


			int result = dao.updateRecord(dto);

			if(result != 0) {
				System.out.println("수정 성공!!");
			}
			else {
				System.out.println("수정 실패!!");
			}

		}
	
	@Override
	public void search() {

		System.out.println("검색할 아이디를 입력하세요.");
		String id = sc.nextLine();
		GuestDTO[] data = dao.searchID(id);

		if(data != null) {
			System.out.println(data[0].toString());
		}

	}

	//정보 수정
	@Override
	public void updateInfo() {
		GuestCustomDTO dto = new GuestCustomDTO();
		
		String id = checkData();
		
		if(id == null) {
			return;
		}
		
		dto.setId(id);

		System.out.println("새로운 PW?");
		dto.setPw(sc.nextLine());

		System.out.println("새로운 이름?");
		dto.setName(sc.nextLine());

		int result = dao.updateInfo(dto);


		if(result != 0) {
			System.out.println("수정 성공!!");
		}
		else {
			System.out.println("수정 실패!!");
		}

		//방명록 수정해줄 부분
		//아마 따로 메서드가 나올듯?


	}

	//삭제
	@Override
	public void delete() {
		GuestCustomDTO dto = new GuestCustomDTO();

		System.out.println("삭제할 ID?");
		int result = dao.deleteData(sc.nextLine());


		if(result != 0) {
			System.out.println("삭제 성공!!");
		}
		else {
			System.out.println("삭제 실패!!");
		}
	}

	@Override
	public void print() {

		allData = dao.printData();

		Iterator<GuestDTO[]> iter = allData.iterator();

		while (iter.hasNext()) {
			GuestDTO[] DTO = iter.next();

			System.out.println(DTO[0].toString() + " " + DTO[1].toString());
			
		}
	}
	
	//아이디 검사 헬퍼 메서드
	private String checkData(){
		System.out.println("로그인 ID?");
		String id = sc.nextLine();
		System.out.print("비밀번호?: ");
		String pw = sc.nextLine();	
		
		return dao.CheckInfo(id, pw);
	}
	
	//입력
	//구조 변경으로 안씀
//	@Override
//	public void writeRecord() {
//		GuestRecordDTO dto = new GuestRecordDTO();
//
//		System.out.print("아이디: ");
//		dto.setId(sc.nextLine());
//
//		System.out.print("방명록을 입력하세요: ");
//		dto.setG_content(sc.nextLine());		
//
//		System.out.print("날짜를 입력하세요: ");
//		dto.setCreated(sc.nextLine());		
//
//		int result = dao.writeRecord(dto);
//
//		if(result != 0) {
//			System.out.println("방명록 추가 성공!!");
//		}
//		else {
//			System.out.println("방명록 추가 실패!!");
//		}
//	}
}












