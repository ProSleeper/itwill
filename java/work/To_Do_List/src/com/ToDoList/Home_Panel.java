package com.ToDoList;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Home_Panel extends JPanel{

	ArrayList<IndicateOneToDo_Panel> ip = new ArrayList<>();
	JPanel scrollPanel;
	Main_Frame mainFrame;
	
	// üũ�ڽ��� ��ư�� �ϳ��� �гη�
	public Home_Panel(Main_Frame mainFrame)  {
		this.mainFrame = mainFrame;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		scrollPanelCreate();
		for (int i = 1; i <= 20; i++) {
			addToDoList(new ToDoList_Object("toDoList �����մϴ�. " + i + i + i + i + i + i + i + i + i + i + i));
		}
	}
	
	void scrollPanelCreate(){
		scrollPanel = new JPanel();
		scrollPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 5));
//		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));	//boxlayout���� ���η� 1���� �����ϰ� ������ ũ�� �����ϴ� �� �𸣰ڴ�...
		JScrollPane scrollFrame = new JScrollPane(scrollPanel);
		scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
		scrollFrame.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollFrame.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setAutoscrolls(true);
		this.add(scrollFrame);
	}

	public void addToDoList(ToDoList_Object tdo)
	{
		IndicateOneToDo_Panel local_iotdp = new IndicateOneToDo_Panel(tdo);
		ip.add(local_iotdp);
		scrollPanel.add(local_iotdp);
		scrollPanel.setPreferredSize(new Dimension( 437,30 + ip.size() * 57));
		this.revalidate();
	}
	
	public void DeleteToDoList(ToDoList_Object tdo)
	{
		System.out.println(tdo.getCheckBox().getText());
	}
	
}
