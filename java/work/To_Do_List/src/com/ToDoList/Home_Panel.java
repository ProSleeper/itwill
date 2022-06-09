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
	
	// üũ�ڽ��� ��ư�� �ϳ��� �гη�
	public Home_Panel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		scrollPanelCreate();
	}
	
	private void scrollPanelCreate(){
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

	//�� �޼���� todolist�Ѱ� ui�� �������ִ� �κ�(���� �����͸� �ִ� �κ��� ����.)
	//�̰͵� ���丮�������� ����� ���� �� �����ѵ�, �� �ϳ��� ui�� �����ؼ� �����
	//���丮������ ���� ���� ���� ����.
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
	
	
	//���� �ڵ� ���Ŀ�
//	public void DeleteToDoList(ToDoList_Object tdo)
//	{
//		System.out.println(tdo.getCheckBox().getText());
//	}
	
}
