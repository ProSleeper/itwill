package com.ToDoList;


//ToDoList�� �������ִ� �κ�
public class ToDoUIFactory {
	
	public ToDoUIFactory() {
		
		//�� �κ��� ���߿� ���� �Ŵ��� ���� ������ �ű�� ��
		
	}


	//���� �Ű������δ� data�� �޴� �κ��� �Ǿ�� �ҵ�
	IndicateOneToDo_Panel createToDoList(String toDoText) {
//		 return new ToDoList_Object(toDoText);
		return new IndicateOneToDo_Panel(toDoText);
	}
}