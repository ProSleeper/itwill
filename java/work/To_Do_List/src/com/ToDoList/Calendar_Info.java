package com.ToDoList;

import java.util.Calendar;

public class Calendar_Info {
	private static Calendar_Info ci = null;
	private static int[] MonthCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	//�̰� ���� �͵� �ʿ����� ���

	//�Ʒ� cur�������� �� ó�� �ʱ�ȭ�ϰ� ������ �� �� �ִ� �뵵�� ����
	static private int 		curYear = 0;		//	�� (�⺻���� ����)
	static private boolean 	curIsLeaf = false;	//	������ ��������
	static private int 		curMonth = 0;		//	�� (�⺻���� �̹� ��)
	static private int 		curDayOfWeek = 0;	//	���� ����� ���� 1���� ����
	static private int 		curDay = 0;			//	�� (�⺻���� ����)


	//�Ʒ� set�������� ����ؼ� ����Ǵ� ��¥�� ���ؼ� ����.
	static private int 		setYear = 0;		
	static private boolean 	setIsLeaf = false;	
	static private int 		setMonth = 0;		
	static private int 		setDayOfWeek = 0;	
	static private int 		setDay = 0;			

	private Calendar_Info(){
		initializeCalendar();
	}

	public static Calendar_Info getInstance() {
		if(ci == null) {
			ci = new Calendar_Info();
		}
		return ci;
	}


	//�� ���߿� �ϼ��ϸ� ���� ����� �̱������� �����ٰ� ������
	public static void main(String[] args) {
		Calendar_Info.initializeCalendar();	//�޷� �ʱ�ȭ(������ ����)
	}

	public static void initializeCalendar(){
		long miliseconds = 0;
		int nDay = 0;
		int dayOfTheWeek = 0;
		int presentDay = 1970;//���� System.currentTimeMillis();�� �ð� ���Ѵ�. 1970��1��1�Ϻ��� ��������� �и��ʸ� ��ȯ���ش�. �׷��� 1970
		int countOfYear = 0;	//�����̸� 366 ����̸� 365�� ������ ����
		int yearOfMonth = 0;
		boolean isLeaf = true;


		miliseconds = System.currentTimeMillis();
		nDay = (int)(miliseconds/1000/60/60/24);
		nDay += 1; //������ ��¥�� ������ ���� �ʱ� ������ +1

		dayOfTheWeek = nDay;

		while (true) {
			countOfYear = ((presentDay % 4) != 0 || (presentDay % 100) == 0 && (presentDay % 400) != 0) ? 365 : 366; 

			if(nDay < countOfYear) {
				break;
			}

			nDay -= countOfYear;
			presentDay++;
		}

		if ((presentDay % 4) != 0 || (presentDay % 100) == 0 && (presentDay % 400) != 0) {
			isLeaf = false;
		}

		for (yearOfMonth = 0; yearOfMonth < MonthCount.length; yearOfMonth++) {

			if (nDay <= MonthCount[yearOfMonth] && !isLeaf || nDay <= 29 && isLeaf) {
				break;
			}

			if(yearOfMonth == 1 && isLeaf) {
				//����
				nDay -= 29;
				continue;
			}
			nDay-= MonthCount[yearOfMonth];
		}

		dayOfTheWeek = (dayOfTheWeek - nDay + 4) % 7;	//�� ���� ���� �̹����� ���� ������ �����.

		curYear = presentDay;		    //	�� (�⺻���� ����)
		curIsLeaf = isLeaf;			    //	������ ��������
		curMonth = yearOfMonth + 1;	    //	�� (�⺻���� �̹� ��)
		curDayOfWeek = dayOfTheWeek;    //	���� ����� ���� 1���� ����
		curDay = nDay;				    //	�� (�⺻���� ����)


		//�ٲ� ��
		setYear = curYear;				//	�� (�⺻���� ����)
		setIsLeaf = curIsLeaf;			//	������ ��������
		setMonth = curMonth;			//	�� (�⺻���� �̹� ��)
		setDayOfWeek = curDayOfWeek;	//	���� ����� ���� 1���� ����
		setDay = curDay;				//	�� (�⺻���� ����)
	}


	//��ư�� ������ 1�޾� �ٲ㼭 ������� �κ�
	public static void setCalendar(int pYear, int pMonth) {
		int nSetDay = (pYear - 1) * 365 + (pYear - 1) / 4 - (pYear - 1) / 100 + (pYear - 1) / 400;
		int nSetNine = (1969) * 365 + (1969) / 4 - (1969) / 100 + (1969) / 400;
		int yearOfDay = 0;	
		boolean leafYear = true;
		int dayOfTheWeek = 0;

		if ((pYear % 4) != 0 || (pYear % 100) == 0 && (pYear % 400) != 0) {
			leafYear = false;
		}
		nSetDay -= nSetNine;

		for (int i = 0; i < pMonth - 1; i++) {
			if (leafYear && i == 1) {
				yearOfDay += 29;
				continue;
			}
			yearOfDay += MonthCount[i];
		}

		nSetDay += yearOfDay;

		//nSetDay += 1;	//������ �� ������ 1 ������� �ϴµ� �ȴ����ִϱ� �� ���� ���´�. ��¥�� �ʹ� +-1 ���ܰ� ����.

		dayOfTheWeek = (nSetDay + 4) % 7;

		setYear = pYear;
		setIsLeaf = leafYear;
		setMonth = pMonth;
		setDayOfWeek = dayOfTheWeek;
	}

	public static void nextMonth(){

		int nYear = getSetYear();
		int nMonth = getSetMonth();

		nMonth += 1;

		if (nMonth > 12) {
			nMonth = 1;
			nYear += 1;
		}

		if (nYear < 1970) {
			nYear = 1970;
		}

		setCalendar(nYear, nMonth);
	}

	public static void prevMonth(){
		int nYear = getSetYear();
		int nMonth = getSetMonth();

		nMonth -= 1;
		
		if (nMonth < 1) {
			nMonth = 12;
			nYear -= 1;
		}

		if (nYear < 1970) {
			nYear = 1970;
		}
		
		setCalendar(nYear, nMonth);
	}


	public static String monthOfMaxDay(int pMonth, int pDay)
	{
		if((curIsLeaf || setIsLeaf) && pMonth == 2 && pDay == 29) {
			return "29";
		}

		if (MonthCount[pMonth - 1] < pDay) {
			return "";
		} 
		return String.valueOf(pDay);
	}

	public static int getCurYear() {
		return curYear;
	}

	public static void setCurYear(int curYear) {
		Calendar_Info.curYear = curYear;
	}

	public static boolean isCurLeaf() {
		return curIsLeaf;
	}

	public static void setCurLeaf(boolean curLeaf) {
		Calendar_Info.curIsLeaf = curLeaf;
	}

	public static int getCurMonth() {
		return curMonth;
	}

	public static void setCurMonth(int curMonth) {
		Calendar_Info.curMonth = curMonth;
	}

	public static int getCurDayOfWeek() {
		return curDayOfWeek;
	}

	public static void setCurDayOfWeek(int curDayOfWeek) {
		Calendar_Info.curDayOfWeek = curDayOfWeek;
	}

	public static int getCurDay() {
		return curDay;
	}

	public static void setCurDay(int curDay) {
		Calendar_Info.curDay = curDay;
	}

	public static int getSetYear() {
		return setYear;
	}

	public static void setSetYear(int setYear) {
		Calendar_Info.setYear = setYear;
	}

	public static boolean isSetIsLeaf() {
		return setIsLeaf;
	}

	public static void setSetIsLeaf(boolean setIsLeaf) {
		Calendar_Info.setIsLeaf = setIsLeaf;
	}

	public static int getSetMonth() {
		return setMonth;
	}

	public static void setSetMonth(int setMonth) {
		Calendar_Info.setMonth = setMonth;
	}

	public static int getSetDayOfWeek() {
		return setDayOfWeek;
	}

	public static void setSetDayOfWeek(int setDayOfWeek) {
		Calendar_Info.setDayOfWeek = setDayOfWeek;
	}

	public static int getSetDay() {
		return setDay;
	}

	public static void setSetDay(int setDay) {
		Calendar_Info.setDay = setDay;
	}
}
