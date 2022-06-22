package com.ToDoList;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

//모든 데이터 관리
public class DataManager {
	private static DataManager dm = null;
	
	HashMap<String, ArrayList<ToDoList_Object>> InforBDate = null;

	private DataManager() {
		
		InforBDate = new HashMap<>();	//key는 날짜 value는 해당 날짜가 가지고 있는 todolist ArrayList
	}
	
	public static DataManager getInstance() {
		if(dm == null) {
			dm = new DataManager();
		}
		return dm;
	}
	
	public void setUIManager(UIManager dataManager) {
		
	}
	
	public void setFactoryClass(ToDoDataFactory tdlf) {
		
	}

	//리스트 생성 이벤트가 발생했을 때 이 메서드를 실행해서 생성해줌
	//원래는 ToDoListFactory 에서 생성을 해주게 해야하는데 현재는 생성부분이 너무 작아서 여기서 생성
	//추후 수정
	public void createData(String toDoText) {
		
		System.out.println(Calendar_Info.getClickDate());
		if(InforBDate.containsKey(Calendar_Info.getClickDate())) {
			InforBDate.get(Calendar_Info.getClickDate()).add(new ToDoList_Object(toDoText));
		}
		else {
			ArrayList<ToDoList_Object> tdloList = new ArrayList<>();
			tdloList.add(new ToDoList_Object(toDoText));
			InforBDate.put(Calendar_Info.getClickDate(), tdloList);
		}
	}
	
//	데이터를 직접 넘겨주는 게 맞는 건지 아니면
//  이 DataManager에서 데이터를 가지고 UIManager에 접근해서 데이터를 뿌려주는 게 맞는건지 아직 모르겠다.
//	일단 내가 내린 결론은, 추후에 어떤 경우에도 결국 DB는 따로 저장해서 가져올테니까
//	여기서는 이 DataManager가 DB 라고 생각하고 DB를 UIManager가 불러와서 출력해주는 방식으로 하자.
	public HashMap<String, ArrayList<ToDoList_Object>> getData(){
		return InforBDate;
	}
	
}