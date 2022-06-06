package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ToolTipManager;

//ToDoList를 생성해주는 부분
public class CreateToDoList_Normal extends ToDo {
	
	public CreateToDoList_Normal() {
		
		//이 부분은 나중에 생성 매니저 같은 곧으로 옮기면 됨
		ToolTipManager ttm = ToolTipManager.sharedInstance();
		ttm.setInitialDelay(100);
		ttm.setDismissDelay(10000);
	}


	@Override
	ToDoList_Object createToDoList(String toDoText) {
		 return new ToDoList_Object(toDoText);
	}
}
