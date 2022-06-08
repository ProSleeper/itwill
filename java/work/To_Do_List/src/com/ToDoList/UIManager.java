package com.ToDoList;

import java.util.ArrayList;

import javax.swing.ToolTipManager;

//ȭ�鿡 �ѷ��ִ� ��� ���� ����
public class UIManager {
	private static UIManager um = null;
	private static DataManager dm = null;
	
	//UIManager�� ������ �־�� �� �г�
	//�����ϰ� �־�� �� �г�: main, home, calender
	//list�� ������ ���� �г�: iotd, cb, eb
	//���⼭ cb�� eb�� iotd�� ������ �����ϱ� list�� iotd�� ������ �ɵ�
	private static Main_Frame mainFrame = null;
	
	private ToDoUIFactory tduf = null;
	private ArrayList<IndicateOneToDo_Panel> iotd = null;
	private ArrayList<ToDoList_Object> tdlo = null;
	
	//�� ��� �гε��� �� ������ �ִ� �� �³�?
	//���� �ϳ��� ������ �ְ� �������� ������ ó���ϵ��� �δ� �� ��������?

	private UIManager(){
		iotd = new ArrayList<>();
		tdlo = DataManager.getInstance().getData();	//�����Ͱ� ����ִ� ARRAYLIST������.
		tduf = new ToDoUIFactory();
		TooltipSetting();
		//���⼭ arraylist�� callValue ���� callRef���� Ȯ���� �ʿ���.
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
	
	//dataList�� ��� �����͸� panelList�� �ѷ��ִ� �κ��� ����� �ɵ�
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



//������ ToDoList_Object �� ������ �ִ� �ڵ�. ������ ��� �־�� ���� �𸣰ھ �ϴ� ���縸
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
//		//���� ���� ���߿� �ٸ� �κ����� �̵�
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
//		//������ ���� �ڵ尡 ������ ���߿� ��ư Ŭ���� �ʿ��� �κ� �ڵ尡 �����ɵ�
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
//		cb.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
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
//		btn.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
//			public void actionPerformed(ActionEvent e){
//				
//				String[] buttons = { "����", "����"};
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
//		Object todoText = JOptionPane.showInputDialog(null, "���� ���ּ���", "����", JOptionPane.DEFAULT_OPTION, null, null, cb.getText());
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

