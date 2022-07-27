package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;


public class Num_1005_Topological_Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//테스트케이스 수 
		//건물의 수, 조건의 수
		//건물의 건설 시간(건물의 수 만큼)
		//건물의 조건(조건의 수 만큼)

		int testCase = sc.nextInt();	//테스트 케이스

		int bCount = 0;
		int bRequireCount = 0;
		HashMap<Integer, Integer> bTime = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> bAdjust = new HashMap<>();
		ArrayList<Integer> queue = new ArrayList<>();
		//		HashMap<Integer, Integer> bDegree = new HashMap<>();
		int[] bDegree = null;
		int target = 0;

		int[] sum = new int[testCase];
		
		
		
		for (int p = 0; p < testCase; p++) {
			bTime.clear();
			bAdjust.clear();
			queue.clear();

			bCount = sc.nextInt();
			bRequireCount = sc.nextInt();
			bDegree = new int[bCount + 1];


			//건설 시간 입력
			for (int i = 1; i <= bCount; i++) {
				int inputTime = sc.nextInt();
				bTime.put(i, inputTime);
				bDegree[i] = 0;
				bAdjust.put(i, new ArrayList<Integer>());
			}

			//배열로 했으니 0부터 시작
			//모든 번호는 -1씩 ㅎ
			for (int i = 1; i <= bRequireCount; i++)
			{
				Integer lBuild = sc.nextInt();
				Integer rBuild = sc.nextInt();

				bAdjust.get(lBuild).add(rBuild);

				bDegree[rBuild]++;
			}
			target = sc.nextInt();

			while(true) {
				for (int i = 1; i <= bCount; i++) {
					if (bDegree[i] == 0) {
						queue.add(i);	//여기 저장되는 i는 차수가 0인 정점
					}
				}

				if(queue.size() == 0) {
					break;
				}

				int max = - 1;
				int bNumber = 0;
				for (int i : queue) {	//차수가 0이 된 모든 정점을 돌면서 연결된 선을 없애면 된다.

					//queue에 있는 값이 target(4)이라면.
					//이 부분이 왜 필요하냐면 차수가 같고, 건설 시간이 같을때 같은 차수에서의 순서가
					//1,4 일때 아래에서 비교하면 1이 순서상 먼저이기 때문에 따로 처리를 해줘야 한다.

					if(i == target) {
						bNumber = i;
						bDegree[i] = -1;
						for (int j = 0; j < bCount + 1; j++) {
							bDegree[j] = -1;
						}
						break;
					}

					if (max < bTime.get(i)) {
						max = bTime.get(i);
						bNumber = i;
					}
					int arraySize = bAdjust.get(i).size();

					for (int j = 0; j < arraySize; j++) {
						int deleteLine = bAdjust.get(i).get(j);
						bDegree[deleteLine]--;
					}
					bDegree[i] = -1;
				}
				sum[p] += bTime.get(bNumber);
				queue.clear();
			}
		}
		for (int i = 0; i < testCase; i++) {
			System.out.println(sum[i]);
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







