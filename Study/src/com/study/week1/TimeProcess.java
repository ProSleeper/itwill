package com.study.week1;

import java.util.Scanner;

class TimeP{
	
	//�̰� Ȥ�ö� ���Ŀ� ����ұ� �; ������
	//12�ð����� 24�ð��� ǥ���� enum
	enum TwentyFourSystem{
		twelve,
		twentyFour
	}

	int curHour = 0;
	int curMinute = 0;
	int curSecond = 0;	//�̰͵� ���Ŀ� �ʷ� ���� �ð��� �����ϴ� ���� ���Ҷ��� ���� ����. ������ �ص���.
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
		
		//���� �ð����� �־��� �ð��� ���ų� ���ϴ� ���� ����ϴ� �ڵ�
		//pHourMinute�� ���� �����̸� ���°��̰� ����̸� ���ϴ� ���̴�.
		//���ϴ� �͸� ������ ������ �� ���������µ� ���� �ͱ��� �ѹ��� ����ϱ� ���� �ڵ�.
		//�ߺ� �κ��� ���� �� �ִµ� ������ �����ϱ� ���ؼ� �׳� ��.
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
