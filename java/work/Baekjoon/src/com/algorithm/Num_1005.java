package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;


public class Num_1005 {
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



