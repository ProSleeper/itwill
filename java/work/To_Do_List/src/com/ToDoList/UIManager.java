package com.ToDoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ToolTipManager;

//화면에 뿌려주는 모든 것을 관리
public class UIManager {
	private static UIManager um = null;

	//UIManager가 가지고 있어야 할 패널
	//유일하게 있어야 할 패널: main, home, calender
	//list로 가지고 있을 패널: iotd, cb, eb
	//여기서 cb와 eb는 iotd가 가지고 있으니까 list는 iotd만 있으면 될듯
	private static Main_Frame mainFrame = null;

	private ToDoUIFactory tduf = null;	//팩토리메서드 사용(딱 하나만 생성이라서 의미가 있나 싶다.)
	HashMap<String, ArrayList<IndicateOneToDo_Panel>> infoPanel = null;

	//이 모든 패널들을 다 가지고 있는 게 맞나?
	//메인 하나만 가지고 있고 나머지는 하위로 처리하도록 두는 게 나으려나?

	private UIManager(){
		tduf = new ToDoUIFactory();
		infoPanel = new HashMap<>();	//얘는 DM에서 가지고 있는 Hashmap을 이용해서 동일한 키지만 패널을 가지고 있을 맵
		TooltipSetting();
		//여기서 arraylist를 callValue 인지 callRef인지 확인이 필요함.
	}

	public static UIManager getInstance() {
		if(um == null) {
			um = new UIManager();
		}
		return um;
	}

	public static void main(String[] args) {
		mainFrame = new Main_Frame();
		DataManager.getInstance();
		//		HaveTestCase.test_ListCreate();	//테스트 생성코드
	}

	//dataList에 담긴 데이터를 panelList에 뿌려주는 부분을 만들면 될듯
	public void setData(){

	}

	public void setMainFrame(Main_Frame mainFrame) {

	}

	public void setDataManager(DataManager dataManager) {

	}

	private void TooltipSetting(){
		ToolTipManager ttm = ToolTipManager.sharedInstance();
		ttm.setInitialDelay(100);
		ttm.setDismissDelay(10000);
	}


	public void createToDoPanel(ToDoList_Object pAddTDL){
		//만들때 스크롤을 가장 아래로 내려서 최신으로 만들어 진 todolist를 보도록 차후 수정

		//이 반복문으로 생성해주는 것은 맞는데
		//add를 눌러서 직접 생성할때는 하나만 추가 해야 되는데
		//현재는 리스트에 있는 모든 오브젝트를 다시 추가해주어서
		//1개를 넣으면 총 1개, 1개 추가시 총 3개, 1개 추가시 6개, 1개 추가시 12개
		//이렇게 늘어난다. 피보나치였나 이게?


		//결국 여기는 날짜 버튼을 클리시에는 당연히 전부 추가시켜서 보여줘야하고
		//그 상태에서 add버튼은 딱 한개만 추가해야하는 코드로 변경 해야한다.

		IndicateOneToDo_Panel localTDL = tduf.createToDoList(pAddTDL.getText()); 
		
		if(infoPanel.containsKey(Calendar_Info.getClickDate())) {
			infoPanel.get(Calendar_Info.getClickDate()).add(localTDL);
		}
		else {
			ArrayList<IndicateOneToDo_Panel> tdloList = new ArrayList<>();
			tdloList.add(localTDL);
			infoPanel.put(Calendar_Info.getClickDate(), tdloList);
		}
		
		mainFrame.getSp().setDrawToDoList(localTDL);
		mainFrame.getSp().revalidate();
		mainFrame.getSp().repaint();
	}
	
	public void synchronizeDataToDoPanel(String pKey, ToDoList_Object pAddTDL){
		//만들때 스크롤을 가장 아래로 내려서 최신으로 만들어 진 todolist를 보도록 차후 수정

		//이 반복문으로 생성해주는 것은 맞는데
		//add를 눌러서 직접 생성할때는 하나만 추가 해야 되는데
		//현재는 리스트에 있는 모든 오브젝트를 다시 추가해주어서
		//1개를 넣으면 총 1개, 1개 추가시 총 3개, 1개 추가시 6개, 1개 추가시 12개
		//이렇게 늘어난다. 피보나치였나 이게?


		//결국 여기는 날짜 버튼을 클리시에는 당연히 전부 추가시켜서 보여줘야하고
		//그 상태에서 add버튼은 딱 한개만 추가해야하는 코드로 변경 해야한다.

		IndicateOneToDo_Panel localTDL = tduf.createToDoList(pAddTDL.getText()); 
		
		if(infoPanel.containsKey(pKey)) {
			infoPanel.get(pKey).add(localTDL);
		}
		else {
			ArrayList<IndicateOneToDo_Panel> tdloList = new ArrayList<>();
			tdloList.add(localTDL);
			infoPanel.put(pKey, tdloList);
		}
		
		if(pKey.equals(Calendar_Info.getClickDate())) {
			mainFrame.getSp().setDrawToDoList(localTDL);
		}
		
		mainFrame.getSp().revalidate();
		mainFrame.getSp().repaint();
	}

	public void reDrawToDoPanel(){

		mainFrame.getSp().getScrollPanel().removeAll();
		mainFrame.getSp().setArraySize(0);
		mainFrame.getSp().revalidate();
		mainFrame.getSp().repaint();
		
		if(infoPanel.get(Calendar_Info.getClickDate()) == null) {
			
			return;
		}
		
		for (IndicateOneToDo_Panel todo_info : infoPanel.get(Calendar_Info.getClickDate())) {
			mainFrame.getSp().reDrawToDoList(todo_info);
		}
		mainFrame.getSp().revalidate();
		mainFrame.getSp().repaint();
	}

	public void deleteToDoPanel(IndicateOneToDo_Panel delObj) {
		//삭제 버튼을 눌렀을 때 실행될 부분
		//실상은 추상이나 인터페이스를 쓴 콜백은 아니지만
		//느낌은 콜백느낌
		
		Iterator<IndicateOneToDo_Panel> iter = infoPanel.get(Calendar_Info.getClickDate()).iterator();
		
		
		while (iter.hasNext()) {
			IndicateOneToDo_Panel toDoList_Object = (IndicateOneToDo_Panel) iter.next();
			
			
			if(toDoList_Object == delObj) {

				//현재 붙어 있는 패널이 scroll패널이라서 거기서 지움
				//mainFrame.getSp().getScrollPanel().remove(iter);

				iter.remove();

				//스크롤 판정 부분을 수정해야 삭제하면 스크롤이 줄어듬

				mainFrame.getSp().setScrollEdit();
				mainFrame.getSp().getScrollPanel().remove(delObj);
			}
		}
		
		if(infoPanel.get(Calendar_Info.getClickDate()).size() == 0) {
			infoPanel.remove(Calendar_Info.getClickDate());
			DataManager.getInstance().getData().remove(Calendar_Info.getClickDate());
		}
		
		
		mainFrame.getSp().revalidate();
		mainFrame.getSp().repaint();	
	}
	
	
	
}