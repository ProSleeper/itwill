package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ToolTipManager;

//������ ���𰡰� ������ �� factory�� ���� ������ ���� �� ������
//���� �� 1�� �����̶� �׳� DataManager���� ó������.


//ToDoList�� �������ִ� �κ�
public class ToDoListFactory extends ToDo {
	
	public ToDoListFactory() {
		
		//�� �κ��� ���߿� ���� �Ŵ��� ���� ������ �ű�� ��
		ToolTipManager ttm = ToolTipManager.sharedInstance();
		ttm.setInitialDelay(100);
		ttm.setDismissDelay(10000);
	}

	@Override
	ToDoList_Object createToDoList(String toDoText) {
//		 return new ToDoList_Object(toDoText);
		return null;
	}
}
