package com.ToDoList;

import java.util.ArrayList;
import java.util.Date;

//��� ������ ����
public class DataManager {
	private static DataManager dm = null;
	ArrayList<ToDoList_Object> tdloList = null;

	private DataManager() {
		tdloList = new ArrayList<>();
		setCalendar();
	}
	
	public static DataManager getInstance() {
		if(dm == null) {
			dm = new DataManager();
		}
		return dm;
	}
	
	public void setUIManager(UIManager dataManager) {
		
	}
	
	public void setFactoryClass(ToDoDataFactory tdlf) {
		
	}

	//����Ʈ ���� �̺�Ʈ�� �߻����� �� �� �޼��带 �����ؼ� ��������
	//������ ToDoListFactory ���� ������ ���ְ� �ؾ��ϴµ� ����� �����κ��� �ʹ� �۾Ƽ� ���⼭ ����
	//���� ����
	public void createData(String toDoText) {
		tdloList.add(new ToDoList_Object(toDoText));
	}
	
//	�����͸� ���� �Ѱ��ִ� �� �´� ���� �ƴϸ�
//  �� DataManager���� �����͸� ������ UIManager�� �����ؼ� �����͸� �ѷ��ִ� �� �´°��� ���� �𸣰ڴ�.
//	�ϴ� ���� ���� �����, ���Ŀ� � ��쿡�� �ᱹ DB�� ���� �����ؼ� �������״ϱ�
//	���⼭�� �� DataManager�� DB ��� �����ϰ� DB�� UIManager�� �ҷ��ͼ� ������ִ� ������� ����.
	public ArrayList<ToDoList_Object> getData(){
		return tdloList;
	}
	
	
	//�޷� ����ؼ� ����ϴ� �κ� �ۼ�
	void setCalendar() {
		String day = "";
		int dayInt = 1;
		long miliseconds = System.currentTimeMillis();
		Date date = new Date();
		
		System.out.println(miliseconds/1000);
		int tSecond = (int) (miliseconds/1000);
		int tMinute = tSecond / 60 % 60;
		int tHour = tSecond / 60 / 60 % 24;
		int tDay = tMinute / 60 / 24;
		int tYear = tDay / 365 + 1970;
		
		System.out.println("��: " + tSecond);
		System.out.println("��: " + tMinute);
		System.out.println("��: " + tHour);
		System.out.println("��: " + tDay);
		System.out.println("��: " + tYear);
		
		//������ gmt�� �츮���� �ð��� ���Ϸ��� +9�ð��� �������.
		
		//System.out.println(date);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}