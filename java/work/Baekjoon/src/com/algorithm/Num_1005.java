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

		//테스트케이스 수 
		//건물의 수, 조건의 수
		//건물의 건설 시간(건물의 수 만큼)
		//건물의 조건(조건의 수 만큼)

		int testCase = sc.nextInt();
		int nOB = sc.nextInt();	//number of building
		int nRQ = sc.nextInt(); //number of requirements
		int nTarget = 0;



		//Integer 정점의 번호
		//String[2] index 0은 정점이 가리키는 정점
		//index 1은 정점을 가리키는 정점의 수
		//모두 String으로 판단하기로 함.
		HashMap<Integer, String[]> buildInfo = new HashMap<>();	//정점의 정보
		HashMap<Integer, Integer> buildTime = new HashMap<>();		//정점의 건설 시간

		//건설 시간 입력
		for (int i = 0; i < nRQ; i++) {
			int buildingNumber = i + 1;
			int bTime = sc.nextInt();
			buildTime.put(buildingNumber, bTime);
			String[] temp = new String[2];
			temp[0] = "";
			temp[1] = "";
			buildInfo.put(i + 1, temp);
		}

		//건설 조건 입력
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
				//입력받은 hashmap을 순회해서 현재 가리키는 선이 0이 된 건물의 정보를 새로운 hashmap에 저장하고 그걸 지워주는 부분.
				//이렇게 한 이유는 같은 차수에 선이 0이 된 점이 많을 경우에는 한번에 처리해야 하기 때문이다.
				temp = new HashMap<>();	//정점의 정보
				Iterator<Entry<Integer, String[]>> entries = buildInfo.entrySet().iterator();
				while(entries.hasNext()){
					Entry<Integer, String[]> entry = entries.next();
					if(entry.getValue()[1].length() == 0) {
						temp.put(new Integer(entry.getKey()), entry.getValue().clone());
						entries.remove();
					}
				}

				
				//아래 부분이 나를 가리키는 선이 0개인 모든 건물을 가져와서 시간을 비교해서 최대값을 max에 저장해주고 그걸 sum에 저장해주는 부분
				//sum에 더해지게 말고 큐를 만들어서 거기에 번호와 번호에 따른 시간을 넣어주면 될듯.
				//물론 같은 차수(예를 들어서 2,3은 같은 차수에 0이 되니까) max에서 비교해서 높은 값의 번호와 시간을 넣어주면 될듯
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
			System.out.println("잘 나오니?");
		}
		
		//********************************** 중요
		//큐에 넣는 부분 구현하고 testcase 수대로 입력받는 거 구현하면 될듯.
		
		System.out.println("잘 나오니?");
	}
}
