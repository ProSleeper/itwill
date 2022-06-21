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


//�۾� �߰��� �� �ߴ� ��Ʈ ����� ���
//Font font = new Font("helvetica", Font.PLAIN, 12);
//Map  attributes = font.getAttributes();
//attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
//Font newFont = new Font(attributes); 


