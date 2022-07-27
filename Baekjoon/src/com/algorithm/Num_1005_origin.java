package com.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

class Building{
	int buildTime = 0;
	ArrayList<Building> requireBuiling = null;
	public Building(int pTime){
		buildTime = pTime;	//건설시간
		requireBuiling = new ArrayList<>(); //현재 건물을 짓기 위해 필요한 건물LIST
	}
	public void addBuilding(Building pBuilding) {	//조건 건물 추가
		requireBuiling.add(pBuilding);
	}
	public int recursiveBuilding(){
		if(requireBuiling.size() == 0) {	//재귀 탈출 조건(건물을 짓기위한 조건이 없는 건물을 만났을 때)
			return buildTime;
		}

		int max = 0;	//현재 건물을 짓기 위한 조건 건물들 중에서 제일 건설시간이 긴 것을 알아낼 변수
		int returnValue = 0;
		for (Building building : requireBuiling) {
			returnValue = building.recursiveBuilding();	//재귀 탈출 조건을 만날때까지 재귀
			max = max < returnValue ? returnValue : max;	//다른 값이 더 크다면 max값 변경
		}
		return buildTime + max;	//건설 시간값 누적
	}
}


public class Num_1005_origin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Building>[] testCase = null;	//테스트케이스 LIST배열

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
				testCase[i].add(new Building(sc.nextInt()));
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









//아무리 생각해도 이 부분을 수정하려면 DP+DFS로 풀어야 할 거 같은데~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//1
//6 6
//10 5 1 1 9 8
//1 2
//1 4
//2 3
//4 5
//3 6
//5 6
//6

//정답 28
//내 코드 32

//각 테크 레벨마다 건설 시간이 가장 긴 건물의
//건설 시간을 더하는 것이 최소 건설 시간을 보장하지 않습니다.



//1
//10 5
//1 2 3 4 5 6 7 8 9 10
//1 6
//2 7
//3 8
//4 9
//5 10
//6

//정답 7
//내 코드 11

//제출기록을 확인해봤는데 최종적으로는 문제를 해결하셨군요 축하드립니다.
//제가 코틀린을 몰라서 본 코드를 이해하진 못했지만, 혹시 저와 같은 문제를 가지고 계신 분들이 계실까 글을 남겨봅니다.
//저 역시 58%에서 틀렸는데요. 제가 틀린 이유는 "네트워크가 여러 개 존재하는 경우"를 고려하지 못해서입니다.
//해당 반례입니다.


//본 예시에서는 네트워크가 총 다섯 개 존재합니다.
//위상 정렬 알고리즘 상 1번부터 5번 건물을 다 짓고 난 후에 6번 건물이 지어질 것입니다.
//그러나 6번 건물을 짓기 위해서는 1번 건물만 지으면 되기 때문에 총 필요 시간은 (1+6) = 7초입니다.
//그러나 6번 건물을 짓기 전에 1~5번 건물을 모두 지었기 때문에
//6번 건물을 짓기 전 시간을 5초(1번 ~ 5번 건물을 짓는 시간의 최대값)이라고 가정하였고
//결과적으로 11초 (5+6)가 걸렸다고 판단했네요.
//혹시 58%에서 문제가 생긴 분들은 해당 반례를 고려해보는 것도 좋을 것 같습니다.
//감사합니다 :)

 






