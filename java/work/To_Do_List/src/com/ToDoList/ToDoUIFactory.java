package com.ToDoList;


//ToDoList를 생성해주는 부분
public class ToDoUIFactory {
	
	public ToDoUIFactory() {
		
		//이 부분은 나중에 생성 매니저 같은 곧으로 옮기면 됨
		
	}


	//차후 매개변수로는 data를 받는 부분이 되어야 할듯
	IndicateOneToDo_Panel createToDoList(String toDoText) {
//		 return new ToDoList_Object(toDoText);
		return new IndicateOneToDo_Panel(toDoText);
	}
}