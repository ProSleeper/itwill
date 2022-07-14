package com.guest;

import java.util.Scanner;

import com.db.DBConn;

public class GuestMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ch;
		Guest ob = new GuestImpl();

		while (true) {
			do {
				System.out.println("1.회원가입 2.방명록 입력 3.검색 4.정보수정 5.삭제 6.전체출력 7.종료");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 9);

			switch (ch) {
				case 1:
					ob.writeInfo();
					break;
				case 2:
					ob.updateRecord();
					break;
				case 3:
					ob.search();
					break;
				case 4:
					ob.updateInfo();
					break;
				case 5:
					ob.delete();
					break;
				case 6:
					ob.print();
					break;
				default:
					DBConn.close();
					System.exit(0);
			}
		}
	}
}











