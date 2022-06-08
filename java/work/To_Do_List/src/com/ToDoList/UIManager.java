package com.ToDoList;

import java.util.ArrayList;

import javax.swing.ToolTipManager;

//화면에 뿌려주는 모든 것을 관리
public class UIManager {
	private static UIManager um = null;
	private static DataManager dm = null;
	
	//UIManager가 가지고 있어야 할 패널
	//유일하게 있어야 할 패널: main, home, calender
	//list로 가지고 있을 패널: iotd, cb, eb
	//여기서 cb와 eb는 iotd가 가지고 있으니까 list는 iotd만 있으면 될듯
	private static Main_Frame mainFrame = null;
	
	private ToDoUIFactory tduf = null;
	private ArrayList<IndicateOneToDo_Panel> iotd = null;
	private ArrayList<ToDoList_Object> tdlo = null;
	
	//이 모든 패널들을 다 가지고 있는 게 맞나?
	//메인 하나만 가지고 있고 나머지는 하위로 처리하도록 두는 게 나으려나?

	private UIManager(){
		iotd = new ArrayList<>();
		tdlo = DataManager.getInstance().getData();	//데이터가 들어있는 ARRAYLIST가져옴.
		tduf = new ToDoUIFactory();
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
		mainFrame.SetUI();
	}
	
	public void createToDoPanel(){
		IndicateOneToDo_Panel localTDL = tduf.createToDoList(tdlo.get(tdlo.size() - 1).getText()); 
		iotd.add(localTDL);
		mainFrame.getHp().addToDoList(localTDL, iotd.size());
	}
	
	//dataList에 담긴 데이터를 panelList에 뿌려주는 부분을 만들면 될듯
	private void setData(){

	}
	
	private void setMainFrame(Main_Frame mainFrame) {
		
	}
	
	private void setDataManager(DataManager dataManager) {
			
	}
	
	private void TooltipSetting(){
		ToolTipManager ttm = ToolTipManager.sharedInstance();
		ttm.setInitialDelay(100);
		ttm.setDismissDelay(10000);
	}
	
}



//원래는 ToDoList_Object 가 가지고 있던 코드. 당장은 어디에 있어야 할지 모르겠어서 일단 복사만
//
//
//package com.ToDoList;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.font.TextAttribute;
//import java.util.Map;
//import java.util.Random;
//
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JOptionPane;
//
//public class ToDoList_Object {
//	
//	private String text;
//	private boolean isCheck;
//	private int[] date = null;
//	private int type = -1;
//	
//	private JCheckBox cb = null;
//	private JButton btn = null;
//	
//	private boolean todo = false;
//	
//	private Font activeFont = null;
//	private Font completedFont = null;
//	
//	
//	public ToDoList_Object(String toDoText) {
//		
//		checkboxCreate(toDoText);
//		buttonCreate();
//		setColor(Color.WHITE);
//		
//		
//		
//		//배경색 변경 나중에 다른 부분으로 이동
////		cb.setBackground(Color.LIGHT_GRAY);
////		btn.setBackground(Color.LIGHT_GRAY);
//	}
//	public void setCheckBox(){
//		
//	}
//	public void setButton(){
//		
//	}
//	public JCheckBox getCheckBox(){
//		return cb;
//	}
//	public JButton getButton(){
//		return btn;
//	}
//	
//	void checkboxCreate(String toDoText) {
//		cb = new JCheckBox(toDoText);
//		cb.setToolTipText(cb.getText());
//		cb.setPreferredSize(new Dimension(420, 50));
//		setCheckBoxAddListner();
//		strikeFontApply();
//	}
//	
//	void buttonCreate() {
//		btn = new JButton("...");
//		//지금은 딱히 코드가 없지만 나중에 버튼 클릭시 필요한 부분 코드가 생성될듯
//		setButtonAddListner();
//	}
//	
//	void strikeFontApply(){
//		Map attributes = new Font("helvetica", Font.PLAIN, 12).getAttributes();
//		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
//		completedFont = new Font(attributes);
//	}
//	
//	
//	
//	void setCheckBoxAddListner() {
//		cb.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
//			public void actionPerformed(ActionEvent e){
//
//				if(cb.isSelected()) {
//					cb.setFont(completedFont);
//					setColor(Color.LIGHT_GRAY);
//				}
//				else {
//					cb.setFont(activeFont);
//					setColor(Color.WHITE);
//				}
//			}
//		});
//	}
//	
//	void setButtonAddListner() {
//		btn.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
//			public void actionPerformed(ActionEvent e){
//				
//				String[] buttons = { "수정", "삭제"};
//
//				int num = JOptionPane.showOptionDialog(null, null, null, JOptionPane.YES_NO_CANCEL_OPTION,
//						JOptionPane.DEFAULT_OPTION, null, buttons, null);
//				if(num == 0) {
//					setEditCheckBoxText();
//				}
//				else {
//					
//				}
//			}
//		});
//	}
//	
//	void setEditCheckBoxText() {
//		Object todoText = JOptionPane.showInputDialog(null, "수정 해주세요", "수정", JOptionPane.DEFAULT_OPTION, null, null, cb.getText());
//		
//		if(todoText != null) {
//			if(!todoText.equals("")) {
//				cb.setText(todoText.toString());
//			}
//		}
//	}
//	
//	void setColor(Color color) {
//		cb.setBackground(color);
//		btn.setBackground(color);
//	}
//}

