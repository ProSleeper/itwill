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
	
	// 체크박스와 버튼을 하나의 패널로
	public Home_Panel(Main_Frame mainFrame)  {
		this.mainFrame = mainFrame;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		scrollPanelCreate();
		for (int i = 1; i <= 20; i++) {
			addToDoList(new ToDoList_Object("toDoList 생성합니다. " + i + i + i + i + i + i + i + i + i + i + i));
		}
	}
	
	void scrollPanelCreate(){
		scrollPanel = new JPanel();
		scrollPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 5));
//		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));	//boxlayout으로 세로로 1개씩 정렬하고 싶은데 크기 고정하는 걸 모르겠다...
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
