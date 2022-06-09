package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ToolTipManager;

//생성할 무언가가 많으면 이 factory를 쓰는 이유가 있을 거 같은데
//지금 딱 1개 생성이라서 그냥 DataManager에서 처리하자.


//ToDoList를 생성해주는 부분
public class ToDoDataFactory {
	
	public ToDoDataFactory() {
	}


	public ToDoList_Object createData(String toDoText) {
//		 return new ToDoList_Object(toDoText);
		return null;
	}
}
