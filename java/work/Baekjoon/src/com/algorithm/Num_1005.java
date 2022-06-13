package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

class Building{

}


public class Num_1005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//�׽�Ʈ���̽� �� 
		//�ǹ��� ��, ������ ��
		//�ǹ��� �Ǽ� �ð�(�ǹ��� �� ��ŭ)
		//�ǹ��� ����(������ �� ��ŭ)

		int testCase = sc.nextInt();
		int nOB = sc.nextInt();	//number of building
		int nRQ = sc.nextInt(); //number of requirements
		int nTarget = 0;



		//Integer ������ ��ȣ
		//String[2] index 0�� ������ ����Ű�� ����
		//index 1�� ������ ����Ű�� ������ ��
		//��� String���� �Ǵ��ϱ�� ��.
		HashMap<Integer, String[]> buildInfo = new HashMap<>();	//������ ����
		HashMap<Integer, Integer> buildTime = new HashMap<>();		//������ �Ǽ� �ð�

		//�Ǽ� �ð� �Է�
		for (int i = 0; i < nRQ; i++) {
			int buildingNumber = i + 1;
			int bTime = sc.nextInt();
			buildTime.put(buildingNumber, bTime);
			String[] temp = new String[2];
			temp[0] = "";
			temp[1] = "";
			buildInfo.put(i + 1, temp);
		}

		//�Ǽ� ���� �Է�
		for (int i = 0; i < nOB; i++) {
			int buildingNumber = sc.nextInt();
			String bRequire = String.valueOf(sc.nextInt());
			buildInfo.get(buildingNumber)[0]+=bRequire;
			buildInfo.get(Integer.parseInt(bRequire))[1]+="a";
		}
		
		nTarget = sc.nextInt();

		for (int p = 0; p < testCase; p++) {
			int sum = 0;
			HashMap<Integer, String[]> temp = null;
			while(true) {
				//�Է¹��� hashmap�� ��ȸ�ؼ� ���� ����Ű�� ���� 0�� �� �ǹ��� ������ ���ο� hashmap�� �����ϰ� �װ� �����ִ� �κ�.
				//�̷��� �� ������ ���� ������ ���� 0�� �� ���� ���� ��쿡�� �ѹ��� ó���ؾ� �ϱ� �����̴�.
				temp = new HashMap<>();	//������ ����
				Iterator<Entry<Integer, String[]>> entries = buildInfo.entrySet().iterator();
				while(entries.hasNext()){
					Entry<Integer, String[]> entry = entries.next();
					if(entry.getValue()[1].length() == 0) {
						temp.put(new Integer(entry.getKey()), entry.getValue().clone());
						entries.remove();
					}
				}

				
				//�Ʒ� �κ��� ���� ����Ű�� ���� 0���� ��� �ǹ��� �����ͼ� �ð��� ���ؼ� �ִ밪�� max�� �������ְ� �װ� sum�� �������ִ� �κ�
				//sum�� �������� ���� ť�� ���� �ű⿡ ��ȣ�� ��ȣ�� ���� �ð��� �־��ָ� �ɵ�.
				//���� ���� ����(���� �� 2,3�� ���� ������ 0�� �Ǵϱ�) max���� ���ؼ� ���� ���� ��ȣ�� �ð��� �־��ָ� �ɵ�
				int max = 0;
				for (Entry<Integer, String[]> key : temp.entrySet()) {
					//		System.out.println(key + " " + buildInfo.get(key)[1].length());
					if(max < buildTime.get(key.getKey())) {
						max = buildTime.get(key.getKey());
					}
					for (int i = 0; i < key.getValue()[0].length(); i++) {
						Integer tempNumber = Integer.parseInt(String.valueOf(key.getValue()[0].charAt(i)));
						int lastSize = buildInfo.get(tempNumber)[1].length();

						buildInfo.get(tempNumber)[1] = buildInfo.get(tempNumber)[1].substring(0, lastSize - 1);

					}
				}
				sum += max;
				if(buildInfo.size() == 0) {
					break;
				}
			}
			System.out.println("�� ������?");
		}
		
		//********************************** �߿�
		//ť�� �ִ� �κ� �����ϰ� testcase ����� �Է¹޴� �� �����ϸ� �ɵ�.
		
		System.out.println("�� ������?");
	}
}
