package com.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

class Building_valueSave extends Building{
	
	int keepValue = -1;	//DFS 를 했을 때 이미 검사한 부분은 다시 검사하지 않도록 값을 저장해두는 부분
	
	public Building_valueSave(int pTime) {
		super(pTime);
		// TODO Auto-generated constructor stub
	}

	
	public int recursiveBuilding(){
		if(keepValue != -1) {
			return keepValue;
		}
		if(requireBuiling.size() == 0) {	//재귀 탈출 조건(0건물을 짓기위한 조건이 없는 건물을 만났을 때)
			return buildTime;
		}

		int max = 0;	//현재 건물을 짓기 위한 조건 건물들 중에서 제일 건설시간이 긴 것을 알아낼 변수
		int returnValue = 0;
		for (Building building : requireBuiling) {
			returnValue = building.recursiveBuilding();	//재귀 탈출 조건을 만날때까지 재귀
			max = max < returnValue ? returnValue : max;	//다른 값이 더 크다면 max값 변경
		}
		
		keepValue = buildTime + max;
		return buildTime + max;	//건설 시간값 누적
	}
}



public class Num_1005_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Building_valueSave>[] testCase = null;	//테스트케이스 LIST배열

		int testCaseNumber = sc.nextInt();	//테스트 케이스 갯수 입력

		int buildingNumber = 0;
		int ruleNumber = 0;
		int[] target = null;


		testCase = new ArrayList[testCaseNumber];
		target = new int[testCaseNumber];

		//입력된 테스트 케이스 횟수만큼 반복.
		for (int i = 0; i < testCaseNumber; i++) {
			testCase[i] = new ArrayList<>();	
			buildingNumber = sc.nextInt();	//건물의 개수
			ruleNumber = sc.nextInt();		//제한 조건의 개수

			//건물의 건설시간 입력
			for (int j = 0; j < buildingNumber; j++) {
				testCase[i].add(new Building_valueSave(sc.nextInt()));
			}

			//제한 조건의 수만큼 입력
			for (int j = 0; j < ruleNumber; j++) {
				int requireBuildingNumber = sc.nextInt();	
				int ownNumber = sc.nextInt();

				//				requireBuildingNumber이 ownNumber건물을 짓기위한 필요 조건이다.


				//testCase[i].get(sc.nextInt() - 1).addBuilding(testCase[i].get(sc.nextInt() - 1));

				//배열은 0부터 시작하므로 -1
				//조건이 2 4 라면 ownNumber가 4이고 requireBuildingNumber가 2이다.
				//
				testCase[i].get(ownNumber - 1).addBuilding(testCase[i].get(requireBuildingNumber - 1));
			}

			//지어야하는 특정 건물 W
			target[i] = sc.nextInt();
		}

		//테스트 케이스만큼 출력
		for (int i = 0; i < testCaseNumber; i++) {
			System.out.println(testCase[i].get(target[i] - 1).recursiveBuilding());
		}
	}
}



