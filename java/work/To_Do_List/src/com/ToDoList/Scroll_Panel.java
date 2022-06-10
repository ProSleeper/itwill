package com.ToDoList;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Scroll_Panel extends JPanel {

	private ArrayList<IndicateOneToDo_Panel> ip = new ArrayList<>();
	private JFrame jp;
	
	// üũ�ڽ��� ��ư�� �ϳ��� �гη�
	public Scroll_Panel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		scrollPanelCreate();
	}
	
	private void scrollPanelCreate(){
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 5));
//		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));	//boxlayout���� ���η� 1���� �����ϰ� ������ ũ�� �����ϴ� �� �𸣰ڴ�...
		JScrollPane scrollFrame = new JScrollPane(this);
		scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
		scrollFrame.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollFrame.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.setAutoscrolls(true);
		//jp.add(scrollFrame);
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
		iotdp.setPreferredSize(new Dimension((int)(this.getSize().width * 0.94), (int)(this.getSize().height * 0.10)));
		
		this.add(iotdp);
		this.setPreferredSize(new Dimension( 437,30 + arraySize * 57));
		this.revalidate();
	}
	
	public JPanel getScrollPanel()
	{
		return this;
	}
	
	
	//���� �ڵ� ���Ŀ�
//	public void DeleteToDoList(ToDoList_Object tdo)
//	{
//		System.out.println(tdo.getCheckBox().getText());
//	}
	
}
