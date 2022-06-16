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
		String day = "";
		int dayInt = 1;
		long miliseconds = System.currentTimeMillis();
		Date date = new Date(miliseconds);
		//System.out.println(miliseconds);
	}

	//�޷� ����ؼ� ����ϴ� �κ� �ۼ�
	static void setCalendar() {

		//����޷�
		Calendar cal = Calendar.getInstance();
		
		int thisYear = cal.get(Calendar.YEAR);
		int thisMonth = cal.get(Calendar.MONTH + 1);
		
		
		int sumDay = 0;
		
		//1970����� ���� - 1������� �� �� ���
		for (int i = 1970; i < thisYear; i++) {
			//��� ����(�����Ͻ�)
			if(i % 4 != 0 || i % 100 == 0 && i % 400 != 0) {
				sumDay += 365;
				//System.out.println(i);
				continue;
			}
			sumDay += 366;
		}
		
		//1970���� 1�� 1���� �����
		//����Ǵ� ���� ������ ���� 0���� 6���� 0�̸� �Ͽ���
		//-1�� 1970�� 1�� 1���� ���ذ�. ������ �� ��¥���� +1���ؼ� ����ϱ� ������
		//+4�� 1970���� 1�� 1�� ������ ������̱⶧��.
		//-15�� ������ 16���ε� 1���� ������ ���ϱ� ���ؼ� ����
		int dayOfTheWeek = (sumDay + 167 - 1 + 4 - 15) % 7;	//�� ���� ���� �̹����� ���� ������ �����.
		
		
		//System.out.println("�� ���" + (sumDay + 167 - 1));
		
		
		
		//�ܼ� ������ �� �ȵ����� �̰ɷ� ����� �� �ƴϴ� �Ѿ�ô�.
//		for (int i = 1; i <= 30 + dayOfTheWeek; i++) {
//			if(i <= dayOfTheWeek) {
//				System.out.printf("%s", "  ");
//				continue;
//			}
//			
//			if(((i - 1) % 7) == 0) {
//				System.out.println();
//			}
//			System.out.printf("%5d", i - dayOfTheWeek);
//		}
		
		
		int year = 0;
		int month = 0;
		int week = 0;
		int day = 0;
		
		int dayInt = 1;
		long miliseconds = System.currentTimeMillis();
		Date date = new Date(miliseconds);
		
		int nSecond = (int)(miliseconds/1000);
		int nMinute = 0;
		int nHour = 0;
		
		int nDay = (int)(miliseconds/1000/60/60/24);
		int nWeek = 0;	//�̰� �ش� ���� 1���� ���� ��
		int nMonth = 0;
		int nYear = 0;
		
		System.out.println(nDay);
		
		
		//�� �κ��� ���� -1������� �� ���ذ� ����°���� ���ϴ� �ڵ�
		int seventy = 1970;
		while (true) {
			
			if((seventy % 4) != 0 || (seventy % 100) == 0 && (seventy % 400) != 0) {
				nDay -= 365;
				//System.out.println(i);
				if (nDay < 365) {
					break;
				}
				
			}
			else {
				nDay -= 366;
				if (nDay < 366) {
					break;
				}
			}
			seventy++;
		}
		
		int[] lyMonthCount = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] MonthCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		
		
		System.out.println("�� ����?");
		
//		for (int i = 1970; i < thisYear; i++) {
//			//��� ����(�����Ͻ�)
//			if(i % 4 != 0 || i % 100 == 0 && i % 400 != 0) {
//				sumDay += 365;
//				//System.out.println(i);
//				continue;
//			}
//			sumDay += 366;
//		}
//		
		//System.out.println("Ķ����" + nDay);
		
//		�� ���ٿ���?
//
//		���
//		year = cal.get(Calendar.YEAR);
//		m = cal.get(Calendar.MONTH) + 1;
//		week = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH); //�̰� ������ ���� ���� ���������� �˷��ִ� ���
//		//week = cal.get(Calendar.WEEK_OF_MONTH);
//		day = cal.get(Calendar.DAY_OF_MONTH);
//		
//		cal.set(y, Calendar.MONTH, Calendar.DAY_OF_MONTH);	//�� ������ << >> �� �����ϸ� �ɵ�
//		
//		
//		cal.set(Calendar.DAY_OF_MONTH,1); //DAY_OF_MONTH�� 1�� ���� (���� ù��)
//		week = cal.get(Calendar.DAY_OF_WEEK); //�� ���� ���� ��ȯ (��:1 ~ ��:7)
//		System.out.println(week);
//
//		int startDay = cal.getActualMinimum(Calendar.DATE);
//		int endDay = cal.getActualMaximum(Calendar.DATE);
//
//
//
//		System.out.printf("\t\t%d�� %d�� ",y, m);
//		System.out.println();
//
//
//		String[] weekArr = {"��", "��", "ȭ", "��", "��", "��", "��"};
//
//		for (int j = 0; j < weekArr.length; j++) {
//
//			System.out.printf("%3s\t", weekArr[j]);
//		}
//		System.out.println();
//
//		for (int j = 1; j < week; j++) {
//			System.out.print("\t");
//		}
//
//
//		for (int j = startDay; j <= endDay; j++) {
//			if ((week + j - 2) % 7 == 0) {
//				System.out.println();
//			}
//			System.out.printf("% 3d\t", j);
//		}
		

	}
	//������ gmt�� �츮���� �ð��� ���Ϸ��� +9�ð��� �������.
	//��� ������ ���ϰ� ���� �츮���� �ð��� -9�ð� ���ָ� ��.
	//System.out.println(date);

}
