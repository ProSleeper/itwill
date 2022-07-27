package com.day20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//정규화 표현식
//단어 바꾸기, 메일주소 검사, 

/*

 c[a-z]*  : c로 시작하는 영단어
 c[a-z] : c로 시작하는 두글자 영단어
 c[a-zA-Z0-9] : ca, cA, c4
 c. : c로 시작하는 두글자
 c.* c로 시작하는 모든 문자
 c. *t : ct, chhhht, c7777t

 [\\d]+ 또는 [0-9]+ : 하나 이상의 숫자


 */


public class Test1 {
	public static void main(String[] args) {

		String[] str = {"bat", "baby", "bonus", "c", "cA", "ca", "c0", "car", "combat", "count", "date", "disc"};

		Pattern p;

		p = Pattern.compile("c[a-z]*");

		for (String string : str) {
			Matcher m = p.matcher(string);

			if(m.matches()) {
				System.out.println(string);
			}
		}
		
		System.out.println("----------------------------------------------------");

		p = Pattern.compile("c.");

		for (String string : str) {
			Matcher m = p.matcher(string);

			if(m.matches()) {
				System.out.println(string);
			}
		}
		
		String[] mails = {"aaaa@aaaa.com", "@aaa.co.kr", "@bbb.ccc", "aaa@vvv.co.kr", "sss.co.kr", "abc@abc"};
			
		//[\\w]+ : 한글자 이상의 영, 숫자
		//@
		//(\\.[\\w]+) : 괄호 안에 있는 것은 반드시 한번은 사용.
		//\\. : 도트
		
		String pat = "[\\w]+@[\\w]+(\\.[\\w]+)+";
		
		for (String string : mails) {
			if(Pattern.matches(pat, string)) {
				System.out.println(string);
			}
		}

	}
}













