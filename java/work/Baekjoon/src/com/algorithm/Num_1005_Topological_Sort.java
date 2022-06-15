package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;


public class Num_1005_Topological_Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//�׽�Ʈ���̽� �� 
		//�ǹ��� ��, ������ ��
		//�ǹ��� �Ǽ� �ð�(�ǹ��� �� ��ŭ)
		//�ǹ��� ����(������ �� ��ŭ)

		int testCase = sc.nextInt();	//�׽�Ʈ ���̽�

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


			//�Ǽ� �ð� �Է�
			for (int i = 1; i <= bCount; i++) {
				int inputTime = sc.nextInt();
				bTime.put(i, inputTime);
				bDegree[i] = 0;
				bAdjust.put(i, new ArrayList<Integer>());
			}

			//�迭�� ������ 0���� ����
			//��� ��ȣ�� -1�� ��
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
						queue.add(i);	//���� ����Ǵ� i�� ������ 0�� ����
					}
				}

				if(queue.size() == 0) {
					break;
				}

				int max = - 1;
				int bNumber = 0;
				for (int i : queue) {	//������ 0�� �� ��� ������ ���鼭 ����� ���� ���ָ� �ȴ�.

					//queue�� �ִ� ���� target(4)�̶��.
					//�� �κ��� �� �ʿ��ϳĸ� ������ ����, �Ǽ� �ð��� ������ ���� ���������� ������
					//1,4 �϶� �Ʒ����� ���ϸ� 1�� ������ �����̱� ������ ���� ó���� ����� �Ѵ�.

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

//�ƹ��� �����ص� �� �κ��� �����Ϸ��� DP+DFS�� Ǯ��� �� �� ������~~~~~~~~~~~~~~~~~~~~~~~~~~~~


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

//���� 28
//�� �ڵ� 32

//�� ��ũ �������� �Ǽ� �ð��� ���� �� �ǹ���
//�Ǽ� �ð��� ���ϴ� ���� �ּ� �Ǽ� �ð��� �������� �ʽ��ϴ�.



//1
//10 5
//1 2 3 4 5 6 7 8 9 10
//1 6
//2 7
//3 8
//4 9
//5 10
//6

//���� 7
//�� �ڵ� 11

//�������� Ȯ���غôµ� ���������δ� ������ �ذ��ϼ̱��� ���ϵ帳�ϴ�.
//���� ��Ʋ���� ���� �� �ڵ带 �������� ��������, Ȥ�� ���� ���� ������ ������ ��� �е��� ��Ǳ� ���� ���ܺ��ϴ�.
//�� ���� 58%���� Ʋ�ȴµ���. ���� Ʋ�� ������ "��Ʈ��ũ�� ���� �� �����ϴ� ���"�� ������� ���ؼ��Դϴ�.
//�ش� �ݷ��Դϴ�.


//�� ���ÿ����� ��Ʈ��ũ�� �� �ټ� �� �����մϴ�.
//���� ���� �˰��� �� 1������ 5�� �ǹ��� �� ���� �� �Ŀ� 6�� �ǹ��� ������ ���Դϴ�.
//�׷��� 6�� �ǹ��� ���� ���ؼ��� 1�� �ǹ��� ������ �Ǳ� ������ �� �ʿ� �ð��� (1+6) = 7���Դϴ�.
//�׷��� 6�� �ǹ��� ���� ���� 1~5�� �ǹ��� ��� ������ ������
//6�� �ǹ��� ���� �� �ð��� 5��(1�� ~ 5�� �ǹ��� ���� �ð��� �ִ밪)�̶�� �����Ͽ���
//��������� 11�� (5+6)�� �ɷȴٰ� �Ǵ��߳׿�.
//Ȥ�� 58%���� ������ ���� �е��� �ش� �ݷʸ� ����غ��� �͵� ���� �� �����ϴ�.
//�����մϴ� :)







