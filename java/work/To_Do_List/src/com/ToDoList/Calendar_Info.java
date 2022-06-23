package com.ToDoList;

import java.util.Calendar;

public class Calendar_Info {
	private static Calendar_Info ci = null;
	private static int[] MonthCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	//이건 윤년 것도 필요할지 고민

	//아래 cur변수들은 맨 처음 초기화하고 오늘을 알 수 있는 용도로 쓰자
	static private int 		curYear = 0;		//	연 (기본값은 올해)
	static private boolean 	curIsLeaf = false;	//	연도가 윤년인지
	static private int 		curMonth = 0;		//	월 (기본값은 이번 달)
	static private int 		curDayOfWeek = 0;	//	현재 적용된 월의 1일의 요일
	static private int 		curDay = 0;			//	날 (기본값은 오늘)


	//아래 set변수들은 계속해서 변경되는 날짜를 위해서 쓰자.
	static private int 		setYear = 0;		
	static private boolean 	setIsLeaf = false;	
	static private int 		setMonth = 0;		
	static private int 		setDayOfWeek = 0;	
	static private int 		setDay = 0;		
	
	static private String clickDate = null;

	private Calendar_Info(){
		initializeCalendar();
	}

	public static Calendar_Info getInstance() {
		if(ci == null) {
			ci = new Calendar_Info();
		}
		return ci;
	}


	//맨 나중에 완성하면 메인 지우기 싱글턴으로 가져다가 쓸거임
	public static void main(String[] args) {
		Calendar_Info.initializeCalendar();	//달력 초기화(기준은 오늘)
	}

	public static void initializeCalendar(){
		long miliseconds = 0;
		int nDay = 0;
		int dayOfTheWeek = 0;
		int presentDay = 1970;//현재 System.currentTimeMillis();로 시간 구한다. 1970년1월1일부터 현재까지의 밀리초를 반환해준다. 그래서 1970
		int countOfYear = 0;	//윤년이면 366 평년이면 365을 저장할 변수
		int yearOfMonth = 0;
		boolean isLeaf = true;


		miliseconds = System.currentTimeMillis();
		nDay = (int)(miliseconds/1000/60/60/24);
		nDay += 1; //오늘은 날짜에 포함이 되지 않기 때문에 +1

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
				//윤년
				nDay -= 29;
				continue;
			}
			nDay-= MonthCount[yearOfMonth];
		}

		dayOfTheWeek = (dayOfTheWeek - nDay + 4) % 7;	//이 값은 현재 이번달의 시작 요일이 저장됨.

		curYear = presentDay;		    //	연 (기본값은 올해)
		curIsLeaf = isLeaf;			    //	연도가 윤년인지
		curMonth = yearOfMonth + 1;	    //	월 (기본값은 이번 달)
		curDayOfWeek = dayOfTheWeek;    //	현재 적용된 월의 1일의 요일
		curDay = nDay;				    //	날 (기본값은 오늘)


		//바뀔 값
		setYear = curYear;				//	연 (기본값은 올해)
		setIsLeaf = curIsLeaf;			//	연도가 윤년인지
		setMonth = curMonth;			//	월 (기본값은 이번 달)
		setDayOfWeek = curDayOfWeek;	//	현재 적용된 월의 1일의 요일
		setDay = curDay;				//	날 (기본값은 오늘)
		
		setClickDate(String.valueOf(curDay));
	}


	//버튼을 누르면 1달씩 바꿔서 출력해줄 부분
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

		//nSetDay += 1;	//솔직히 내 생각엔 1 더해줘야 하는데 안더해주니까 제 값이 나온다. 날짜란 너무 +-1 예외가 많다.

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
		
		if(DataManager.getInstance().CheckData("next") != null) {
			clickDate = String.format("%d-%02d-%s", getSetYear(), getSetMonth(), DataManager.getInstance().CheckData("next"));
			//System.out.println(clickDate + "  선택");
			return;
		}
		
		setClickDate(String.valueOf(1));
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
		
		if(DataManager.getInstance().CheckData("prev") != null) {
			clickDate = String.format("%d-%02d-%s", getSetYear(), getSetMonth(), DataManager.getInstance().CheckData("prev")); 
			//System.out.println(clickDate + "  선택");
			return;
		}
		setClickDate(String.valueOf(MonthCount[setMonth - 1]));
	}

	
	public static void nextYear(){
		int nYear = getSetYear();
		nYear += 1;

		setCalendar(nYear, getSetMonth());
		
		if(DataManager.getInstance().CheckData("next") != null) {
			clickDate = String.format("%d-%02d-%s", getSetYear(), getSetMonth(), DataManager.getInstance().CheckData("next"));
			//System.out.println(clickDate + "  선택");
			return;
		}
		
		setClickDate(String.valueOf(1));
	}

	public static void prevYear(){
		int nYear = getSetYear();

		nYear -= 1;
		
		if (nYear < 1970) {
			nYear = 1970;
		}
		setCalendar(nYear, getSetMonth());
		
		if(DataManager.getInstance().CheckData("prev") != null) {
			clickDate = String.format("%d-%02d-%s", getSetYear(), getSetMonth(), DataManager.getInstance().CheckData("prev"));
			//System.out.println(clickDate + "  선택");
			return;
		}
		
		setClickDate(String.valueOf(MonthCount[setMonth - 1]));
	}
	
	public static void setClickDate(String pDate){
		
		clickDate = String.format("%d-%02d-%s", getSetYear(), getSetMonth(), pDate); 
	}
	
	public static String getClickDate(){
		
		return clickDate;
	}

	public static String curMonthOfMaxDay(int pMonth, int pDay)
	{
		if(curIsLeaf  && pMonth == 2 && pDay > 28) {
			return "29";
		}
		if (MonthCount[pMonth - 1] < pDay) {
			return String.valueOf(MonthCount[pMonth - 1]);
		} 
		return String.valueOf(pDay);
	}
	
	public static String setMonthOfMaxDay(int pMonth, int pDay)
	{
		if(setIsLeaf && pMonth == 2 && pDay > 28) {
			return "29";
		}
		if (MonthCount[pMonth - 1] < pDay) {
			return String.valueOf(MonthCount[pMonth - 1]);
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
