package com.ToDoList;

import java.awt.Dimension;
import java.util.ArrayList;

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
	private ArrayList<IndicateOneToDo_Panel> iotd = null;
	private ArrayList<ToDoList_Object> tdlo = null;
	
	//이 모든 패널들을 다 가지고 있는 게 맞나?
	//메인 하나만 가지고 있고 나머지는 하위로 처리하도록 두는 게 나으려나?

	private UIManager(){
		iotd = new ArrayList<>();
		tduf = new ToDoUIFactory();
		tdlo = DataManager.getInstance().getData();	//데이터가 들어있는 ARRAYLIST가져옴.
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
		HaveTestCase.test_ListCreate();
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
	
	
	public void createToDoPanel(){
		//만들때 스크롤을 가장 아래로 내려서 최신으로 만들어 진 todolist를 보도록 차후 수정
		IndicateOneToDo_Panel localTDL = tduf.createToDoList(tdlo.get(tdlo.size() - 1).getText()); 
		iotd.add(localTDL);
		mainFrame.getSp().setDrawToDoList(localTDL);
		mainFrame.getSp().revalidate();
		mainFrame.getSp().repaint();
	}
	
	public void deleteToDoPanel(IndicateOneToDo_Panel delObj) {
		//삭제 버튼을 눌렀을 때 실행될 부분
		//실상은 추상이나 인터페이스를 쓴 콜백은 아니지만
		//느낌은 콜백느낌
		
		for (int i = 0; i < iotd.size(); i++) {
			if(iotd.get(i) == delObj) {
			
				//현재 붙어 있는 패널이 scroll패널이라서 거기서 지움
				mainFrame.getSp().getScrollPanel().remove(iotd.get(i));
				
				iotd.remove(i);
				tdlo.remove(i);
			
				//스크롤 판정 부분을 수정해야 삭제하면 스크롤이 줄어듬
				
				mainFrame.getSp().setScrollEdit();
				mainFrame.getSp().getScrollPanel().revalidate();
				mainFrame.getSp().getScrollPanel().repaint();
				
			}
		}
	}
}