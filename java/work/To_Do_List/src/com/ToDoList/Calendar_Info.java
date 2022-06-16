package com.ToDoList;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

	//달력 계산해서 출력하는 부분 작성
	static void setCalendar() {

		//만년달력
		Calendar cal = Calendar.getInstance();
		
		int thisYear = cal.get(Calendar.YEAR);
		int thisMonth = cal.get(Calendar.MONTH + 1);
		
		
		int sumDay = 0;
		
		//1970년부터 올해 - 1년까지의 일 수 계산
		for (int i = 1970; i < thisYear; i++) {
			//평년 조건(윤년일시)
			if(i % 4 != 0 || i % 100 == 0 && i % 400 != 0) {
				sumDay += 365;
				//System.out.println(i);
				continue;
			}
			sumDay += 366;
		}
		
		//1970년의 1월 1일은 목요일
		//저장되는 값은 오늘의 요일 0부터 6까지 0이면 일요일
		//-1은 1970년 1월 1일을 빼준것. 이유는 그 날짜부터 +1씩해서 계산하기 때문에
		//+4는 1970년의 1월 1일 요일이 목요일이기때문.
		//-15는 오늘이 16일인데 1일의 요일을 구하기 위해서 해줌
		int dayOfTheWeek = (sumDay + 167 - 1 + 4 - 15) % 7;	//이 값은 현재 이번달의 시작 요일이 저장됨.
		
		
		//System.out.println("내 계산" + (sumDay + 167 - 1));
		
		
		
		//콘솔 정렬은 잘 안되지만 이걸로 출력할 거 아니니 넘어갑시다.
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
		int nWeek = 0;	//이건 해당 월의 1일의 요일 값
		int nMonth = 0;
		int nYear = 0;
		
		System.out.println(nDay);
		
		
		//이 부분이 올해 -1년까지를 뺀 올해가 몇일째인지 구하는 코드
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
		
		
		
		System.out.println("잘 오나?");
		
//		for (int i = 1970; i < thisYear; i++) {
//			//평년 조건(윤년일시)
//			if(i % 4 != 0 || i % 100 == 0 && i % 400 != 0) {
//				sumDay += 365;
//				//System.out.println(i);
//				continue;
//			}
//			sumDay += 366;
//		}
//		
		//System.out.println("캘린더" + nDay);
		
//		왜 안줄여짐?
//
//		출력
//		year = cal.get(Calendar.YEAR);
//		m = cal.get(Calendar.MONTH) + 1;
//		week = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH); //이건 오늘이 현재 월의 몇주차인지 알려주는 상수
//		//week = cal.get(Calendar.WEEK_OF_MONTH);
//		day = cal.get(Calendar.DAY_OF_MONTH);
//		
//		cal.set(y, Calendar.MONTH, Calendar.DAY_OF_MONTH);	//이 셋으로 << >> 을 구현하면 될듯
//		
//		
//		cal.set(Calendar.DAY_OF_MONTH,1); //DAY_OF_MONTH를 1로 설정 (월의 첫날)
//		week = cal.get(Calendar.DAY_OF_WEEK); //그 주의 요일 반환 (일:1 ~ 토:7)
//		System.out.println(week);
//
//		int startDay = cal.getActualMinimum(Calendar.DATE);
//		int endDay = cal.getActualMaximum(Calendar.DATE);
//
//
//
//		System.out.printf("\t\t%d년 %d월 ",y, m);
//		System.out.println();
//
//
//		String[] weekArr = {"일", "월", "화", "수", "목", "금", "토"};
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
	//기준이 gmt라서 우리나라 시간을 구하려면 +9시간을 해줘야함.
	//출력 나오는 값하고 현재 우리나라 시간에 -9시간 해주면 됨.
	//System.out.println(date);

}
