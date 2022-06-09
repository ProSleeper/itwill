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

	private ArrayList<IndicateOneToDo_Panel> ip = new ArrayList<>();
	private JPanel scrollPanel;
	
	// 체크박스와 버튼을 하나의 패널로
	public Home_Panel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		scrollPanelCreate();
	}
	
	private void scrollPanelCreate(){
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

	//이 메서드는 todolist한개 ui를 생성해주는 부분(아직 데이터를 넣는 부분은 없다.)
	//이것도 팩토리패턴으로 만들면 좋을 것 같긴한데, 딱 하나의 ui만 존재해서 현재는
	//팩토리패턴을 쓰는 것은 별로 같다.
//	public void addToDoList(ToDoList_Object tdo)
//	{
//		IndicateOneToDo_Panel local_iotdp = new IndicateOneToDo_Panel();
//		ip.add(local_iotdp);
//		scrollPanel.add(local_iotdp);
//		scrollPanel.setPreferredSize(new Dimension( 437,30 + ip.size() * 57));
//		this.revalidate();
//	}
	
	public void addToDoList(IndicateOneToDo_Panel iotdp , int arraySize)
	{
		scrollPanel.add(iotdp);
		scrollPanel.setPreferredSize(new Dimension( 437,30 + arraySize * 57));
		this.revalidate();
	}
	
	public JPanel scpan()
	{
		return scrollPanel;
	}
	
	
	//삭제 코드 추후에
//	public void DeleteToDoList(ToDoList_Object tdo)
//	{
//		System.out.println(tdo.getCheckBox().getText());
//	}
	
}
