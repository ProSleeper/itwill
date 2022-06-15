package com.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

class Building{
	int buildTime = 0;
	ArrayList<Building> requireBuiling = null;
	public Building(int pTime){
		buildTime = pTime;	//�Ǽ��ð�
		requireBuiling = new ArrayList<>(); //���� �ǹ��� ���� ���� �ʿ��� �ǹ�LIST
	}
	public void addBuilding(Building pBuilding) {	//���� �ǹ� �߰�
		requireBuiling.add(pBuilding);
	}
	public int recursiveBuilding(){
		if(requireBuiling.size() == 0) {	//��� Ż�� ����(�ǹ��� �������� ������ ���� �ǹ��� ������ ��)
			return buildTime;
		}

		int max = 0;	//���� �ǹ��� ���� ���� ���� �ǹ��� �߿��� ���� �Ǽ��ð��� �� ���� �˾Ƴ� ����
		int returnValue = 0;
		for (Building building : requireBuiling) {
			returnValue = building.recursiveBuilding();	//��� Ż�� ������ ���������� ���
			max = max < returnValue ? returnValue : max;	//�ٸ� ���� �� ũ�ٸ� max�� ����
		}
		return buildTime + max;	//�Ǽ� �ð��� ����
	}
}


public class Num_1005_origin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Building>[] testCase = null;	//�׽�Ʈ���̽� LIST�迭

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
				testCase[i].add(new Building(sc.nextInt()));
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

 






