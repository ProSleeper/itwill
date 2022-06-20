package com.ToDoList;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

public class Calendar_Panel extends JPanel {

	private final int GRID_SIZE = 7;
	String[] week = {"일", "월", "화", "수", "목", "금", "토"};
	String[] arrow = {"<<", ">>"};

	ArrayList<JButton> buttonArr = new ArrayList<>();
	JButton yearTitle = null;
	JButton monthTitle = null;
	JButton leftArrow = null;
	JButton rightArrow = null;

	public Calendar_Panel() {
		this.setBackground(Color.orange);
		this.setLayout(new GridLayout(0, 7, 5, 5));
		initCalendar();
		btnClick();
	}

	public void buttonClick(){
	}

	//캘린더 출력 초기화(키면 항상 오늘이 나오도록)
	public void initCalendar() {
		Calendar_Info.initializeCalendar();

		//월 이동 버튼 생성
		leftArrow = addButton(arrow[0]);
		this.add(new JLabel());
		this.add(new JLabel());
		monthTitle = addButton(String.valueOf(Calendar_Info.getCurMonth()));
		this.add(new JLabel());
		this.add(new JLabel());
		rightArrow = addButton(arrow[1]);
		//무식해도 차라리 이게 더 직관적이고 수정하기 편할듯

		for (int i = 0; i < GRID_SIZE; i++) {
			addButton(week[i]);
		}

		String viewDay = "";
		int dayOfWeek = Calendar_Info.getCurDayOfWeek();
		int countDay = 1;

		for (int i = 1; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if(dayOfWeek-- <= 0) {
					viewDay = Calendar_Info.monthOfMaxDay(Calendar_Info.getCurMonth(), countDay++);
				}
				buttonArr.add(addButton(viewDay));
			}
		}
	}

	public void setCalendar() {
		Calendar_Info.setCalendar(1970, 1);
		
		monthTitle.setText(""+(Calendar_Info.getSetMonth()));

		String viewDay = "";
		int dayOfWeek = Calendar_Info.getSetDayOfWeek();
		int countDay = 1;
		
		for (int i = 0; i < buttonArr.size(); i++) {
			buttonArr.get(i).setText("");
			if(dayOfWeek-- <= 0) {
				viewDay = Calendar_Info.monthOfMaxDay(Calendar_Info.getSetMonth(), countDay++);
				buttonArr.get(i).setText(viewDay);
			}
		}
	}

	public void btnClick() {
		rightArrow.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					setCalendar();
				}
			}
		});
	}
	

	public JButton addButton(String pName) {
		JButton jb = new JButton(pName);
		jb.setFont(new Font("helvetica", Font.BOLD, 17));
		this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		this.add(jb);
		return jb;
	}
}
