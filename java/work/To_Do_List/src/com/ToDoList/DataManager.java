package com.ToDoList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;


//모든 데이터 관리
public class DataManager  {
	private static DataManager dm = null;
	
	HashMap<String, ArrayList<ToDoList_Object>> InfoDate = null;

	String path = null;
	File f = null;
	
	private DataManager() {
		path = System.getProperty("user.dir");
		f = new File("todolistData.db");
		loadData();
		synchronizeData();
		//InfoDate = new HashMap<>();	//key는 날짜 value는 해당 날짜가 가지고 있는 todolist ArrayList
	}
	
	public static DataManager getInstance() {
		if(dm == null) {
			dm = new DataManager();
		}
		return dm;
	}
	
	public void loadData() {
		try {
			if(!f.exists()) {
				InfoDate = new HashMap<>();
				return;
			}
			
			FileInputStream fis = new FileInputStream(path + "\\" + f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			InfoDate = (HashMap)ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception e) {
			System.out.println(e.toString());
			InfoDate = new HashMap<>();
//			System.out.println("불러오기 실패!!");
		}
//		System.out.println("불러오기 성공!!");
	}
	
	public void saveData() {
		try {
			
			//System.out.println(path + "\\" + f);
			
			FileOutputStream fos = new FileOutputStream(path + "\\" + f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(InfoDate);
		
			oos.close();
			fos.close();
			
		} catch (Exception e) {
//			System.out.println("저장 실패!!");
		}
//		System.out.println("저장 완료!!");
	}
	
	public void setUIManager(UIManager dataManager) {
		
	}
	
	public void setFactoryClass(ToDoDataFactory tdlf) {
		
	}

	//리스트 생성 이벤트가 발생했을 때 이 메서드를 실행해서 생성해줌
	//원래는 ToDoListFactory 에서 생성을 해주게 해야하는데 현재는 생성부분이 너무 작아서 여기서 생성
	//추후 수정
	public void createData(String toDoText) {
		
		ToDoList_Object tempTDL = null;
		
		//System.out.println("생성");
		//System.out.println(Calendar_Info.getClickDate());
		if(InfoDate.containsKey(Calendar_Info.getClickDate())) {
			tempTDL = new ToDoList_Object(toDoText);
			InfoDate.get(Calendar_Info.getClickDate()).add(tempTDL);
		}
		else {
			ArrayList<ToDoList_Object> tdloList = new ArrayList<>();
			tempTDL = new ToDoList_Object(toDoText);
			tdloList.add(tempTDL);
			InfoDate.put(Calendar_Info.getClickDate(), tdloList);
		}
		
		UIManager.getInstance().createToDoPanel(tempTDL);
	}
	
	public void synchronizeData() {
		
		if(InfoDate.size() == 0) {
			return;
		}
		
		for (String iterable_element : InfoDate.keySet()) {
			InfoDate.get(iterable_element).forEach((tdl) -> UIManager.getInstance().synchronizeDataToDoPanel(iterable_element, tdl));
		}
	}
	
	public String CheckData(String pMove) {
		
		int max = Integer.parseInt(Calendar_Info.setMonthOfMaxDay(Calendar_Info.getSetMonth(), 31));
		
		
		int min = 0;
		
		for (int i = 1; i <= 31; i++) {
			String temp = String.format("%d-%02d-%d", Calendar_Info.getSetYear(), Calendar_Info.getSetMonth(), i);
			
			if(InfoDate.containsKey(temp)) {
				
				if(min < 1) {
					min = i;
				}
				max = i;
			}
		}
		
		if(pMove.equals("next")) {
			if(min < 1) {
				min = 1;
			}
			
			return String.valueOf(min);
		}
		else {
			return String.valueOf(max);
		}
	}
	
//	데이터를 직접 넘겨주는 게 맞는 건지 아니면
//  이 DataManager에서 데이터를 가지고 UIManager에 접근해서 데이터를 뿌려주는 게 맞는건지 아직 모르겠다.
//	일단 내가 내린 결론은, 추후에 어떤 경우에도 결국 DB는 따로 저장해서 가져올테니까
//	여기서는 이 DataManager가 DB 라고 생각하고 DB를 UIManager가 불러와서 출력해주는 방식으로 하자.
	public HashMap<String, ArrayList<ToDoList_Object>> getData(){
		return InfoDate;
	}
	
}