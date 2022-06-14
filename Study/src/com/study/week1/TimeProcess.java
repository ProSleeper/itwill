package com.study.week1;

import java.util.Scanner;

class TimeP{
	
	//이건 혹시라도 차후에 사용할까 싶어서 만들어둔
	//12시간제와 24시간제 표현할 enum
	enum TwentyFourSystem{
		twelve,
		twentyFour
	}

	int curHour = 0;
	int curMinute = 0;
	int curSecond = 0;	//이것도 차후에 초로 만들 시간을 변경하는 것을 구할때를 위한 변수. 구현도 해두자.
	TwentyFourSystem timeSys = null;
	
	public TimeP(int pHour, int pMinute) {
		curHour = pHour;
		curMinute = pMinute;
		curSecond = 0;
		timeSys = TwentyFourSystem.twentyFour;
	}

	public void changeHour(int pHour) {
		changeMinute(pHour * 60);
	}

	public void changeMinute(int pHourMinute) {
		int tHour = curHour;
		int tMinute = curMinute;
		
		//현재 시각에서 주어진 시각을 빼거나 더하는 것을 계산하는 코드
		//pHourMinute의 값이 음수이면 빼는것이고 양수이면 더하는 것이다.
		//더하는 것만 있으면 공식이 더 간결해지는데 빼는 것까지 한번에 계산하기 위한 코드.
		//중복 부분을 줄일 수 있는데 공식을 보존하기 위해서 그냥 둠.
		curHour = ((1440 + tHour * 60 + tMinute + pHourMinute) / 60) % 24;
		curMinute = (1440 + tHour * 60 + tMinute + pHourMinute) % 60;
		
	}

	public void changeTime(int pHour, int pMinute) {

		changeMinute(pHour * 60 + pMinute);
	}
	
	
	public void printTime() {
		System.out.println(curHour + " " + curMinute);
	}
}

public class TimeProcess {
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int inputHour = 0;
		int inputMinute = 0;
		int varTime = 0;
		
		inputHour = Integer.parseInt(sc.next());
		inputMinute = Integer.parseInt(sc.next());
		varTime = Integer.parseInt(sc.next());
		
		TimeP tp = new TimeP(inputHour, inputMinute);
		tp.changeHour(varTime);
		tp.printTime();
		
	}
}
