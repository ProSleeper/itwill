package com.ToDoList;


//ToDoList�� �������ִ� �κ�
public class ToDoUIFactory {
	
	public ToDoUIFactory() {
		
		
		
	}

	//����� �ƹ��͵� ������ ���Ŀ� �ٸ� listObject ������ ����ٰ� �Ѵٸ� ����� ���ؼ� ����� �ǰڴ�.
	IndicateOneToDo_Panel createToDoList(String toDoText) {
//		 return new ToDoList_Object(toDoText);
		return new IndicateOneToDo_Panel(toDoText);
	}
}