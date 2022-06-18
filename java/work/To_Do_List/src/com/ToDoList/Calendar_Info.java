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


	static int dayValue = 0;
	static boolean leafYear = false;


	public static void main(String[] args) {
		Calendar_Info ci = new Calendar_Info();
		ci.setCalendar();
		ci.setCalendar(dayValue);
	}

	public void initializeCalendar(){
	}

	//�޷� ����ؼ� ����ϴ� �κ� �ۼ�
	void setCalendar() {


		long miliseconds = System.currentTimeMillis();
		int nDay = (int)(miliseconds/1000/60/60/24);
		int[] MonthCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


		nDay += 1; //������ ��¥�� ������ ���� �ʱ� ������ +1

		int dayOfTheWeek = nDay;

		//�� �κ��� ���� -1������� �� ���ذ� ����°���� ���ϴ� �ڵ�
		int presentDay = 1970;
		int countOfYear = 0;

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
		dayValue = nDay;

		System.out.println(dayOfTheWeek);		//���� ���۵Ǵ� ����
		System.out.println(nDay);			//����
		System.out.println(yearOfMonth + 1);	//�̹���
		System.out.println(presentDay);			//����

		System.out.println("�� ����?");

	}
	boolean CheckLeafYear(int pDay) {


		long miliseconds = System.currentTimeMillis();
		int nDay = (int)(miliseconds/1000/60/60/24);
		int[] MonthCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


		nDay += 1; //������ ��¥�� ������ ���� �ʱ� ������ +1

		int dayOfTheWeek = nDay;

		//�� �κ��� ���� -1������� �� ���ذ� ����°���� ���ϴ� �ڵ�
		int presentDay = 1970;
		int countOfYear = 0;

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
		dayValue = nDay;

		System.out.println(dayOfTheWeek);		//���� ���۵Ǵ� ����
		System.out.println(nDay);			//����
		System.out.println(yearOfMonth + 1);	//�̹���
		System.out.println(presentDay);			//����

		System.out.println("�� ����?");
		return false;

	}


	//��ư�� �Է� ������ pValue��
	void setCalendar(int pValue) {

		long miliseconds = System.currentTimeMillis();
		int nDay = (int)(miliseconds/1000/60/60/24);
		int[] MonthCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


		//�׽�Ʈ�ڵ� 
		//1�̸� ��ư ������ 0�̸� �ȴ�����

		int button = 1;

		if (button == 1) {
			nDay += 31;
		}




		nDay += 1; //������ ��¥�� ������ ���� �ʱ� ������ +1
		//nDay -= (pValue - 1);	//����� ��¥ ������ �ϸ� ��	pValu�� �̹� ���� ���ñ��� ��¥�ε� ���� 18���϶� 18�� ���� ������ ������ ���� ������ ������ +1
		nDay = nDay - pValue + 1;
		int dayOfTheWeek = nDay;

		//�� �κ��� ���� -1������� �� ���ذ� ����°���� ���ϴ� �ڵ�
		int presentDay = 1970; //���� System.currentTimeMillis();�� �ð� ���Ѵ�. 1970��1��1�Ϻ��� ��������� �и��ʸ� ��ȯ���ش�. �׷��� 1970
		int countOfYear = 0;	//�����̸� 366 ����̸� 365�� ������ ��

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
		System.out.println(nDay);			//����
		System.out.println(yearOfMonth + 1);	//�̹���
		System.out.println(presentDay);			//����

		System.out.println("�� ����?");

	}

}
