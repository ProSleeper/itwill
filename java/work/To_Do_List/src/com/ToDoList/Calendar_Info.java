package com.ToDoList;

import java.util.Date;

public class Calendar_Info {

	//��¥�� ���ϴ� ���� (�ϸ� ���� �޷�)
	/*
	1. �⺻������ ������ �������� �˾ƾ��Ѵ�.(��ǻ�� ���������� Ȥ�� ������ ������ ��������, �����Ϸκ��� ����°���� ��)
	2. ������ ���ϴ� ������ ����ؼ� ��Ȯ�� ������ ����
	3. Ҵ�� ������ ����������� ������ ���� �⵵�� ���´�.(�̶� ���ش� ���� �� �������� �ʾұ� ������ 2021�⵵������ ����
	4. ���� ���ظ� �������� 2022�⵵ 1��1���� �������� ������ �ȴ�.
	5.�δ� ���� ���� ������ 7�� ����� ���ϸ� �ȴ�.
	6. ���� ���� �������� ������ ��ĥ°���� ���ϸ� �ȴ�.
	7. ��� ���� ������(todolist)�� ������ ������ ������ �ش����� Ŭ���ؼ� todolist�� ����� �������� �����ǰ� ����.
	8. ��¥��ư�� ������ todolist�� ��µ� showtodo�гο��� �� ����� �ٽ� �� ��¥�� todolist�� ������ָ� �ȴ�.
	
	*/
	
	public static void main(String[] args) {
		setCalendar();
	}
	
	public void initializeCalendar()
	{
		String day = "";
		int dayInt = 1;
		long miliseconds = System.currentTimeMillis();
		Date date = new Date(miliseconds);
		//System.out.println(miliseconds);
	}
	
	//�޷� ����ؼ� ����ϴ� �κ� �ۼ�
		static void setCalendar() {
			String day = "";
			int dayInt = 1;
			long miliseconds = System.currentTimeMillis();
			Date date = new Date();
			
			System.out.println(miliseconds/1000);
			int tSecond = (int) (miliseconds/1000);
			int tMinute = tSecond / 60;
			int tHour = tMinute / 60;
			int tDay = tHour / 24;
			int tWeek = tDay / 7;
			int tMonth = 0;	// �̰� �������̶� �̷��� ���Ҽ� �� ����
			int tYear = (tDay + 13) / 365 + 1970 ;
			int modYear = (tDay - 13) % 365;
			
			System.out.println("��: " + tSecond);
			System.out.println("��: " + tMinute);
			System.out.println("��: " + tHour);
			System.out.println("��: " + tDay);
			System.out.println("��: " + tWeek);
			System.out.println("��: " + tYear);
			System.out.println("���� ��: " + modYear);
			
			//������ gmt�� �츮���� �ð��� ���Ϸ��� +9�ð��� �������.
			//��� ������ ���ϰ� ���� �츮���� �ð��� -9�ð� ���ָ� ��.
			//System.out.println(date);
		}
	
	
	
	
}
