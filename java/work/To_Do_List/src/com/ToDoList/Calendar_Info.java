package com.ToDoList;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	}

	//�޷� ����ؼ� ����ϴ� �κ� �ۼ�
	static void setCalendar() {

		
		long miliseconds = System.currentTimeMillis();
		
		int nDay = (int)(miliseconds/1000/60/60/24);
		
		int dayOfTheWeek = nDay;
		
		
		
		//�� �κ��� ���� -1������� �� ���ذ� ����°���� ���ϴ� �ڵ�
		int presentDay = 1970;
		int countOfYear = 0;
		
		int[] MonthCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		while (true) {
			countOfYear = ((presentDay % 4) != 0 || (presentDay % 100) == 0 && (presentDay % 400) != 0) ? 365 : 366; 
			
			if(nDay < countOfYear) {
				break;
			}
			
			nDay -= countOfYear;
			presentDay++;
		}
		
		
		int yearOfMonth = 0;
		
		for (yearOfMonth = 0; yearOfMonth < MonthCount.length; yearOfMonth++) {
			
			if (nDay <= MonthCount[yearOfMonth]) {
				break;
			}
			
			if((countOfYear % 365) == 1 && yearOfMonth == 1) {
				//����
				nDay -= 29;
				continue;
			}
			
			nDay-= MonthCount[yearOfMonth];
		}	
		
		dayOfTheWeek = (dayOfTheWeek - nDay + 4) % 7;	//�� ���� ���� �̹����� ���� ������ �����.
		
		System.out.println(dayOfTheWeek);		//���� ���۵Ǵ� ����
		System.out.println(nDay + 1);			//����
		System.out.println(yearOfMonth + 1);	//�̹���
		System.out.println(presentDay);			//����
		
		System.out.println("�� ����?");
	
	}

}
