package com.ToDoList;


//ToDoList를 생성해주는 부분
public class ToDoUIFactory {
	
	public ToDoUIFactory() {
		
		
		
	}

	//현재는 아무것도 없지만 추후에 다른 listObject 종류를 만든다고 한다면 상속을 통해서 만들면 되겠다.
	IndicateOneToDo_Panel createToDoList(String toDoText, boolean pCheck) {
//		 return new ToDoList_Object(toDoText);
		return new IndicateOneToDo_Panel(toDoText, pCheck);
	}
}