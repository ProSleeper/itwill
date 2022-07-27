package com.FileMember;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

import com.Score4.ScoreVO;
import com.day18.MyData;

public class InfoImpl implements Info{

	Scanner sc = new Scanner(System.in);
	ArrayList<InfoVO> studentInfo = null;
	
	public InfoImpl() {
		loadData();
	}

	@Override
	public void inputData() {
		
		//자동 입력 코드
//		String[] arrName = {"배수지", "유인나", "아이유", "공유", "스티븐슨"};
//		String[] arrBirth = {"2022-11-11", "2000-03-05", "1998-02-28", "1997-07-09", "2005-09-17"};
//		String[] arrScore = {"70", "50", "39", "20","100"};
//		
//		for (int i = 0; i < arrName.length; i++) {
//			
//			studentInfo.add(new InfoVO(arrName[i], arrBirth[i], arrScore[i]));
//		}
		
		String name;
		String birth;
		String score;
		
		System.out.print("이름  ?  ");
		name = sc.next();
	
		System.out.print("생일  ?  ");
		birth = sc.next();
		
		System.out.print("점수  ?  ");
		score = sc.next();
		
//		System.out.println("입력 성공");
		studentInfo.add(new InfoVO(name, birth, score));

	}

	@Override
	public void loadData() {
		try {
			if(!(new File("c:\\doc\\InfoData.txt").exists())) {
				studentInfo = new ArrayList<>();
				return;
			}
			
			FileInputStream fis = new FileInputStream("c:\\doc\\InfoData.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			

			studentInfo = (ArrayList<InfoVO>)ois.readObject();
			
			ois.close();
			fis.close();

		} catch (Exception e) {
			System.out.println(e.toString());
//			System.out.println("불러오기 실패!!");
		}
//		System.out.println("불러오기 성공!!");
	}

	@Override
	public void saveData() {
		try {
			FileOutputStream fos = new FileOutputStream("c:\\doc\\InfoData.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(studentInfo);
		
			oos.close();
			fos.close();
		} catch (Exception e) {
//			System.out.println("저장 실패!!");
		}
//		System.out.println("저장 완료!!");
	}
	
	@Override
	public void outputData() {
		studentInfo.forEach(data -> System.out.println(data.toString()));
	}

}
