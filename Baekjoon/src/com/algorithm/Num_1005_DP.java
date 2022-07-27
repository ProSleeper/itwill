package com.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

class Building_valueSave extends Building{
	
	int keepValue = -1;	//DFS �� ���� �� �̹� �˻��� �κ��� �ٽ� �˻����� �ʵ��� ���� �����صδ� �κ�
	
	public Building_valueSave(int pTime) {
		super(pTime);
		// TODO Auto-generated constructor stub
	}

	
	public int recursiveBuilding(){
		if(keepValue != -1) {
			return keepValue;
		}
		if(requireBuiling.size() == 0) {	//��� Ż�� ����(0�ǹ��� �������� ������ ���� �ǹ��� ������ ��)
			return buildTime;
		}

		int max = 0;	//���� �ǹ��� ���� ���� ���� �ǹ��� �߿��� ���� �Ǽ��ð��� �� ���� �˾Ƴ� ����
		int returnValue = 0;
		for (Building building : requireBuiling) {
			returnValue = building.recursiveBuilding();	//��� Ż�� ������ ���������� ���
			max = max < returnValue ? returnValue : max;	//�ٸ� ���� �� ũ�ٸ� max�� ����
		}
		
		keepValue = buildTime + max;
		return buildTime + max;	//�Ǽ� �ð��� ����
	}
}



public class Num_1005_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Building_valueSave>[] testCase = null;	//�׽�Ʈ���̽� LIST�迭

		int testCaseNumber = sc.nextInt();	//�׽�Ʈ ���̽� ���� �Է�

		int buildingNumber = 0;
		int ruleNumber = 0;
		int[] target = null;


		testCase = new ArrayList[testCaseNumber];
		target = new int[testCaseNumber];

		//�Էµ� �׽�Ʈ ���̽� Ƚ����ŭ �ݺ�.
		for (int i = 0; i < testCaseNumber; i++) {
			testCase[i] = new ArrayList<>();	
			buildingNumber = sc.nextInt();	//�ǹ��� ����
			ruleNumber = sc.nextInt();		//���� ������ ����

			//�ǹ��� �Ǽ��ð� �Է�
			for (int j = 0; j < buildingNumber; j++) {
				testCase[i].add(new Building_valueSave(sc.nextInt()));
			}

			//���� ������ ����ŭ �Է�
			for (int j = 0; j < ruleNumber; j++) {
				int requireBuildingNumber = sc.nextInt();	
				int ownNumber = sc.nextInt();

				//				requireBuildingNumber�� ownNumber�ǹ��� �������� �ʿ� �����̴�.


				//testCase[i].get(sc.nextInt() - 1).addBuilding(testCase[i].get(sc.nextInt() - 1));

				//�迭�� 0���� �����ϹǷ� -1
				//������ 2 4 ��� ownNumber�� 4�̰� requireBuildingNumber�� 2�̴�.
				//
				testCase[i].get(ownNumber - 1).addBuilding(testCase[i].get(requireBuildingNumber - 1));
			}

			//������ϴ� Ư�� �ǹ� W
			target[i] = sc.nextInt();
		}

		//�׽�Ʈ ���̽���ŭ ���
		for (int i = 0; i < testCaseNumber; i++) {
			System.out.println(testCase[i].get(target[i] - 1).recursiveBuilding());
		}
	}
}



