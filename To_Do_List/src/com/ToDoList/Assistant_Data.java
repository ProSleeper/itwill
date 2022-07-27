package com.ToDoList;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

public class Assistant_Data {
	static public Font FontSelect(String type){
		switch (type) {
		case "strike":
			Map attributes = new Font("helvetica", Font.PLAIN, 16).getAttributes();
			attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
			return new Font(attributes);
		case "active":
		default:
			return new Font("helvetica", Font.PLAIN, 16);
		}
	}
}


//글씨 중간에 줄 긋는 폰트 만드는 방법
//Font font = new Font("helvetica", Font.PLAIN, 12);
//Map  attributes = font.getAttributes();
//attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
//Font newFont = new Font(attributes); 


