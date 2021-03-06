package com.ToDoList;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


//지금 이 클래스만 유일하게 JPanel 2개을 가지고 있다.
//ShowToDo_Panel이 기본적으로 붙어 있는 패널이고
//scrollPanel은 스크롤을 구현한 패널이다.

//이유는 ShowToDo_Panel에 스크롤이 필요한데
//구현방법이 scrollPanel에 스크롤을 만든 후 ShowToDo_Panel에 추가 시켜서 만든다.

public class ShowToDo_Panel extends JPanel {

	private JPanel scrollPanel = null;
	private GridBagConstraints gbc;
	
	
	private final int iotdScrollSize = 33;
	private int arraySize = 0;

	// 체크박스와 버튼을 하나의 패널로
	public ShowToDo_Panel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		scrollPanelCreate();
	}
	
	private void scrollPanelCreate(){
		
		scrollPanel = new JPanel();
		
		//System.out.println(scrollPanel.getLayout());
		//scrollPanel.setLayout(gBag);
		gbc = new GridBagConstraints();
		
		
		
//		scrollPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 5));
		//scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));	//boxlayout으로 세로로 1개씩 정렬하고 싶은데 크기 고정하는 걸 모르겠다...
		
		
		JScrollPane scrollFrame = new JScrollPane(scrollPanel);
		scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
		scrollFrame.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollFrame.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setAutoscrolls(true);
		
		//scrollFrame.add(Box.createHorizontalStrut(1000));
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
	
	public void setDrawToDoList(IndicateOneToDo_Panel iotdp){
		//System.out.println("스크롤 패널 추가");
		//System.out.println(iotdp.getPreferredSize());
		this.arraySize++;
//		scrollPanel.add(iotdp);
		scrollPanel_Add(iotdp);
		scrollPanel.setPreferredSize(new Dimension( 437,30 + this.arraySize * iotdScrollSize));
	}
	
	public void reDrawToDoList(IndicateOneToDo_Panel iotdp){
		//System.out.println("패널 재출력 추가");
		//System.out.println(this.arraySize);
		this.arraySize++;
//		scrollPanel.add(iotdp);
		
		scrollPanel_Add(iotdp);
		scrollPanel.setPreferredSize(new Dimension( 437,30 + this.arraySize * iotdScrollSize));
	}
	
	public void setScrollEdit(){
		this.arraySize--;
		//System.out.println(this.arraySize);
		scrollPanel.setPreferredSize(new Dimension( 437,30 + this.arraySize * iotdScrollSize));
	}
	
	public void initScroll(int arraySize) {
		this.arraySize = arraySize;
		scrollPanel.setPreferredSize(new Dimension( 437,30 + this.arraySize * iotdScrollSize));
	}
	
	public JPanel getScrollPanel(){
		return scrollPanel;
	}
	
	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
	
	private void scrollPanel_Add(Component pComp) {
		//현재 한 화면에 15개의 todolist가 들어감.
		
		//System.out.println("몇번 오지?");
        gbc.fill= GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 0;
        gbc.gridy = arraySize;	//세로로 한칸씩 늘
        //gbc.gridwidth = 2;
        //gbc.gridheight = 1;
        gbc.weightx = 1;		//컴포넌트의 가로 비율 0이 아닌 값을 넣으면 가로를 전부 채운다.
//        gbc.weighty = 2;		//컴포넌트의 세로 비율, 가로와 설정은 같지만 fill이 현재 horizontal이라서 가로만 채운다.
        //gbc.anchor = GridBagConstraints.PAGE_END;
        scrollPanel.add(pComp,gbc);
        //scrollPanel.add(pComp);
	}
	
	
	
	//삭제 코드 추후에
//	public void DeleteToDoList(ToDoList_Object tdo)
//	{
//		System.out.println(tdo.getCheckBox().getText());
//	}
	
}
