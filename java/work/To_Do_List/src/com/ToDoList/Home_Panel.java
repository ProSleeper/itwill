package com.ToDoList;


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
	}
	
	void scrollPanelCreate(){
		scrollPanel = new JPanel();
		scrollPanel.setPreferredSize(new Dimension( 437,30));
		scrollPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 5));
		JScrollPane scrollFrame = new JScrollPane(scrollPanel);
		scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
		scrollFrame.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollFrame.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(800,540));
		this.add(scrollFrame);
	}
	
	public void addToDoList(ToDoList_Object tdo)
	{
		IndicateOneToDo_Panel local_iotdp = new IndicateOneToDo_Panel(tdo);
		ip.add(local_iotdp);
		scrollPanel.add(local_iotdp);
		scrollPanel.setPreferredSize(new Dimension( 437,30 + ip.size() * 57));
		System.out.println(ip.size());
		this.revalidate();
	}
	
}
