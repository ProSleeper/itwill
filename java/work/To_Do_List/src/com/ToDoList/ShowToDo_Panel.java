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


//���� �� Ŭ������ �����ϰ� JPanel 2���� ������ �ִ�.
//ShowToDo_Panel�� �⺻������ �پ� �ִ� �г��̰�
//scrollPanel�� ��ũ���� ������ �г��̴�.

//������ ShowToDo_Panel�� ��ũ���� �ʿ��ѵ�
//��������� scrollPanel�� ��ũ���� ���� �� ShowToDo_Panel�� �߰� ���Ѽ� �����.

public class ShowToDo_Panel extends JPanel {

	private JPanel scrollPanel = null;
	private final int iotdScrollSize = 38;
	private int arraySize = 0;
	
	// üũ�ڽ��� ��ư�� �ϳ��� �гη�
	public ShowToDo_Panel() {
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
	
	public void setDrawToDoList(IndicateOneToDo_Panel iotdp)
	{
		this.arraySize++;
		scrollPanel.add(iotdp);
		scrollPanel.setPreferredSize(new Dimension( 437,30 + this.arraySize * iotdScrollSize));
		System.out.println(30 + this.arraySize * iotdScrollSize);
	}
	
	public void setScrollEdit()
	{
		this.arraySize--;
		scrollPanel.setPreferredSize(new Dimension( 437,30 + this.arraySize * iotdScrollSize));
	}
	
	public JPanel getScrollPanel()
	{
		return scrollPanel;
	}
	
	
	//���� �ڵ� ���Ŀ�
//	public void DeleteToDoList(ToDoList_Object tdo)
//	{
//		System.out.println(tdo.getCheckBox().getText());
//	}
	
}
