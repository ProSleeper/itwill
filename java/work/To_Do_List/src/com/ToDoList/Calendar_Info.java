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
	}

	//달력 계산해서 출력하는 부분 작성
	static void setCalendar() {

		
		long miliseconds = System.currentTimeMillis();
		
		int nDay = (int)(miliseconds/1000/60/60/24);
		
		int dayOfTheWeek = nDay;
		
		
		
		//이 부분이 올해 -1년까지를 뺀 올해가 몇일째인지 구하는 코드
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
				//윤년
				nDay -= 29;
				continue;
			}
			
			nDay-= MonthCount[yearOfMonth];
		}	
		
		dayOfTheWeek = (dayOfTheWeek - nDay + 4) % 7;	//이 값은 현재 이번달의 시작 요일이 저장됨.
		
		System.out.println(dayOfTheWeek);		//월의 시작되는 요일
		System.out.println(nDay + 1);			//오늘
		System.out.println(yearOfMonth + 1);	//이번달
		System.out.println(presentDay);			//올해
		
		System.out.println("잘 오나?");
	
	}

}
