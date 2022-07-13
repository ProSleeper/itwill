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
		dto.setId(sc.next());

		System.out.print("비밀번호?: ");
		dto.setPw(sc.next());		

		System.out.println("이름?: ");
		dto.setName(sc.next());		

		int result = dao.writeInfo(dto);

		if(result != 0) {
			System.out.println("추가 성공!!");
		}
		else {
			System.out.println("추가 실패!!");
		}
	}

	//입력
	@Override
	public void writeRecord() {
		GuestRecordDTO dto = new GuestRecordDTO();

		System.out.print("아이디: ");
		dto.setId(sc.next());

		System.out.print("방명록을 입력하세요: ");
		dto.setG_content(sc.next());		

		System.out.print("날짜를 입력하세요: ");
		dto.setCreated(sc.next());		

		int result = dao.writeRecord(dto);

		if(result != 0) {
			System.out.println("방명록 추가 성공!!");
		}
		else {
			System.out.println("방명록 추가 실패!!");
		}
	}

	@Override
	public void search() {

		System.out.println("검색할 ID?");
		String id = sc.next();


		GuestDTO[] data = dao.searchID(id);

		if(data != null) {
			System.out.println(data[0].toString());
		}

	}

	//정보 수정
	@Override
	public void updateInfo() {
		GuestCustomDTO dto = new GuestCustomDTO();

		System.out.println("수정할 ID?");
		dto.setId(sc.next());

		System.out.println("수정할 PW?");
		dto.setPw(sc.next());

		System.out.println("수정할 이름?");
		dto.setName(sc.next());

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


	//방명록 수정
	@Override
	public void updateRecord() {
		
		
		System.out.println("로그인 ID?");
		String id = sc.next();
		
		GuestDTO[] data = dao.searchID(id);

		if(data == null) {
			System.out.println("아이디가 없습니다.");
			return;
		}
		

		System.out.println("로그인 PW?");
		String pw = sc.next();
		
		GuestCustomDTO cDTO = (GuestCustomDTO)data[0];
		
		if(!cDTO.getPw().equals(pw)) {
			System.out.println("패스워드가 일치하지 않습니다.");
			return;
		}
		
		GuestRecordDTO dto = new GuestRecordDTO();

		System.out.println("수정할 ID?");
		dto.setId(sc.next());

		System.out.println("수정할 방명록?");
		dto.setG_content(sc.next());

		System.out.println("수정할 날짜?");
		dto.setCreated(sc.next());

		int result = dao.updateRecord(dto);

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
		int result = dao.deleteData(sc.next());


		if(result != 0) {
			System.out.println("삭제 성공!!");
		}
		else {
			System.out.println("삭제 실패!!");
		}
	}

	public void logout() {

	}

	@Override
	public void print() {

		allData = dao.printData();

		Iterator<GuestDTO[]> iter = allData.iterator();

		while (iter.hasNext()) {
			GuestDTO[] DTO = (GuestDTO[]) iter.next();

			System.out.println(DTO[0].toString());
		}
	}
}












