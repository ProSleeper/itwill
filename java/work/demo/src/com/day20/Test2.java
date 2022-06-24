package com.day20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {


	public static String replaceAll(String pStr, String pOldStr, String pNewStr) {
		
		if(pStr == null) {
			return null;
		}

		Pattern p = Pattern.compile(pOldStr);
		Matcher m = p.matcher(pStr);

		StringBuffer sb = new StringBuffer();

		while (m.find()) {
			m.appendReplacement(sb, pNewStr);
		}


//		m.appendTail();

		return sb.toString();

	}

	public static void main(String[] args) {
		
		String str = "우리나라 대한민국 대한독립 대한의 건아...";
		
		String s = Test2.replaceAll(str, "대한", "大韓");
		
		System.out.println(s);
		
		
	}
}















