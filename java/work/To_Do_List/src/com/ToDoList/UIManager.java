package com.ToDoList;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ToolTipManager;

//ȭ�鿡 �ѷ��ִ� ��� ���� ����
public class UIManager {
	private static UIManager um = null;
	
	//UIManager�� ������ �־�� �� �г�
	//�����ϰ� �־�� �� �г�: main, home, calender
	//list�� ������ ���� �г�: iotd, cb, eb
	//���⼭ cb�� eb�� iotd�� ������ �����ϱ� list�� iotd�� ������ �ɵ�
	private static Main_Frame mainFrame = null;
	
	private ToDoUIFactory tduf = null;	//���丮�޼��� ���(�� �ϳ��� �����̶� �ǹ̰� �ֳ� �ʹ�.)
	private ArrayList<IndicateOneToDo_Panel> iotd = null;
	private ArrayList<ToDoList_Object> tdlo = null;
	
	//�� ��� �гε��� �� ������ �ִ� �� �³�?
	//���� �ϳ��� ������ �ְ� �������� ������ ó���ϵ��� �δ� �� ��������?

	private UIManager(){
		iotd = new ArrayList<>();
		tduf = new ToDoUIFactory();
		tdlo = DataManager.getInstance().getData();	//�����Ͱ� ����ִ� ARRAYLIST������.
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
		HaveTestCase.test_ListCreate();
	}
	
	//dataList�� ��� �����͸� panelList�� �ѷ��ִ� �κ��� ����� �ɵ�
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
		//���鶧 ��ũ���� ���� �Ʒ��� ������ �ֽ����� ����� �� todolist�� ������ ���� ����
		IndicateOneToDo_Panel localTDL = tduf.createToDoList(tdlo.get(tdlo.size() - 1).getText()); 
		iotd.add(localTDL);
		mainFrame.getSp().setDrawToDoList(localTDL);
		mainFrame.getSp().revalidate();
		mainFrame.getSp().repaint();
	}
	
	public void deleteToDoPanel(IndicateOneToDo_Panel delObj) {
		//���� ��ư�� ������ �� ����� �κ�
		//�ǻ��� �߻��̳� �������̽��� �� �ݹ��� �ƴ�����
		//������ �ݹ����
		
		for (int i = 0; i < iotd.size(); i++) {
			if(iotd.get(i) == delObj) {
			
				//���� �پ� �ִ� �г��� scroll�г��̶� �ű⼭ ����
				mainFrame.getSp().getScrollPanel().remove(iotd.get(i));
				
				iotd.remove(i);
				tdlo.remove(i);
			
				//��ũ�� ���� �κ��� �����ؾ� �����ϸ� ��ũ���� �پ��
				
				mainFrame.getSp().setScrollEdit();
				mainFrame.getSp().getScrollPanel().revalidate();
				mainFrame.getSp().getScrollPanel().repaint();
				
			}
		}
	}
}