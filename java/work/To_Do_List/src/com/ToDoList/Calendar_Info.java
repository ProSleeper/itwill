package com.ToDoList;

import java.util.Date;

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
			int tMonth = 0;	// 이건 변동값이라서 이렇게 구할수 가 없음
			int tYear = (tDay + 13) / 365 + 1970 ;
			int modYear = (tDay - 13) % 365;
			
			System.out.println("초: " + tSecond);
			System.out.println("분: " + tMinute);
			System.out.println("시: " + tHour);
			System.out.println("일: " + tDay);
			System.out.println("주: " + tWeek);
			System.out.println("년: " + tYear);
			System.out.println("남는 값: " + modYear);
			
			//기준이 gmt라서 우리나라 시간을 구하려면 +9시간을 해줘야함.
			//출력 나오는 값하고 현재 우리나라 시간에 -9시간 해주면 됨.
			//System.out.println(date);
		}
	
	
	
	
}
