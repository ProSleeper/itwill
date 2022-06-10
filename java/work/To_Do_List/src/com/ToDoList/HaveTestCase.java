package com.ToDoList;

import java.util.Random;

public class HaveTestCase {
	
	public static void test_ListCreate()
	{
		final int LIST_SIZE = 15;
		String testToDoWord = "get the support 추천6 champion scoring Terrestrial exclusive negotiation 외계인 비추천2 영어사전 2022-06-10 twin flight 득점왕 problem 폴라포낭 논리적인 Extra";
		String[] wordArray = testToDoWord.split(" ");
		String todoText = "";
		Random rd = new Random();
		int[] randNumber = new int[4];
		
		for (int i = 0; i < randNumber.length; i++) {
			randNumber[i] = rd.nextInt(wordArray.length);
		}
		
		for (int i = 0; i < LIST_SIZE; i++) {
			for (int j = 0; j < randNumber.length; j++) {
				randNumber[j] = rd.nextInt(wordArray.length);
				todoText += wordArray[randNumber[j]];
			}
			
			DataManager.getInstance().createData(todoText);
			UIManager.getInstance().createToDoPanel();
			todoText = "";
			
		}
		
//		
	}

}



