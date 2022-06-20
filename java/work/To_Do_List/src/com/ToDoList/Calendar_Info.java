package com.ToDoList;


public class Calendar_Info {

	//날짜를 구하는 공식 (일명 만년 달력)
	/*
	1. 기본적으로 오늘이 언제인지 알아야한다.(컴퓨터 내부적으로 혹은 웹에서 오늘이 언제인지, 기준일로부터 몇일째인지 등)
	2. 윤년을 구하는 공식을 사용해서 정확한 공식을 도출
	3. 年은 기준을 윤년공식으로 나누면 현재 년도가 나온다.(이때 올해는 아직 다 지나가지 않았기 때문에 2021년도까지만 구함
	4. 月은 올해를 기준으로 2022년도 1월1일을 기준으로 나누면 된다.
	5.週는 나눈 월을 가지고 7로 나누어서 구하면 된다.
	6. 日은 월을 기준으로 오늘이 며칠째인지 구하면 된다.
	7. 모든 일이 데이터(todolist)를 가지고 있지는 않으니 해당일을 클릭해서 todolist를 만들면 동적으로 생성되게 하자.
	8. 날짜버튼을 누르면 todolist가 출력된 showtodo패널에서 다 지우고 다시 그 날짜의 todolist를 출력해주면 된다.
	*/

	private static Calendar_Info ci = null;
	private static int[] MonthCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	//이건 윤년 것도 필요할지 고민


	//아래 값들은 set메서드로 설정하면 다 바뀔 수 있도록 구현
	static private int 		curYear = 0;		//	연 (기본값은 올해)
	static private boolean 	curIsLeaf = false;	//	연도가 윤년인지

	static private int 		curMonth = 0;		//	월 (기본값은 이번 달)
	static private int 		curDayOfWeek = 0;	//	현재 적용된 월의 1일의 요일

	static private int 		curDay = 0;			//	날 (기본값은 오늘)
	
	
	
	
	
	
	static private int 		setYear = 0;		//	연 (기본값은 올해)
	static private boolean 	setIsLeaf = false;	//	연도가 윤년인지

	static private int 		setMonth = 0;		//	월 (기본값은 이번 달)
	static private int 		setDayOfWeek = 0;	//	현재 적용된 월의 1일의 요일

	static private int 		setDay = 0;			//	날 (기본값은 오늘)
	
	
	

	private Calendar_Info(){
		initializeCalendar();
		setCalendar(2018, 5);
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
		boolean isLeaf = false;
		
		
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

		for (yearOfMonth = 0; yearOfMonth < MonthCount.length; yearOfMonth++) {

			if (nDay <= MonthCount[yearOfMonth]) {
				break;
			}

			if((countOfYear % 365) == 1 && yearOfMonth == 1) {
				//윤년
				nDay -= 29;
				continue;
			}
			nDay-= MonthCount[yearOfMonth];
		}

		dayOfTheWeek = (dayOfTheWeek - nDay + 4) % 7;	//이 값은 현재 이번달의 시작 요일이 저장됨.
		
		if ((presentDay % 4) != 0 || (presentDay % 100) == 0 && (presentDay % 400) != 0) {
			isLeaf = false;
		}
		else {
			isLeaf = true;
		}	 
		
		curYear = presentDay;		//	연 (기본값은 올해)
		curIsLeaf = isLeaf;			//	연도가 윤년인지
		curMonth = yearOfMonth + 1;	//	월 (기본값은 이번 달)
		curDayOfWeek = dayOfTheWeek;//	현재 적용된 월의 1일의 요일
		curDay = nDay;				//	날 (기본값은 오늘)

	}


	//버튼을 누르면 1달씩 바꿔서 출력해줄 부분
	public static void setCalendar(int pYear, int pMonth) {
		
//		int nSetDay = (pYear - 1) * 365 + (pYear - 1) / 4 - (pYear - 1) / 100 + (pYear - 1) / 400;
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



	public static String monthOfMaxDay(int pMonth, int pDay)
	{
		if(setIsLeaf && pMonth == 2 && pDay == 29) {
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
