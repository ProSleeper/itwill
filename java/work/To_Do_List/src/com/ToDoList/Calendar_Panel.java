package com.ToDoList;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


class MyFocuseListener implements FocusListener {

    @Override
    public void focusGained(FocusEvent e) {
        //System.out.println(e.getSource().getClass().getName());
        System.out.println("MyFocuseListener.focusGained()");
    }

    @Override
    public void focusLost(FocusEvent e) {
    	JButton aa = (JButton)e.getComponent();
    	System.out.println(aa.getText());
    	aa.setBackground(Color.black);
    	aa.setOpaque(true);
        //System.out.println(e.getSource().getClass().getName());
        System.out.println("MyFocuseListener.focusLost()");
    }
}

public class Calendar_Panel extends JPanel {

	private final int BORDERSIZE 	= 20;
	private final int GRID_SIZE		= 7;

	String[] week = {"일", "월", "화", "수", "목", "금", "토"};
	String[] arrow = {"<<", ">>"};

	ArrayList<JButton> buttonArr = new ArrayList<>();
	JLabel yearLabel = null;
	JLabel monthLabel = null;

	JButton returnToToday = null;
	JButton SwapYearMonth = null;
	JButton prevArrow = null;
	JButton nextArrow = null;

	boolean isMoveMonth = true;

	public Calendar_Panel() {
		this.setBackground(Color.orange);
		this.setLayout(new GridLayout(0, 7, 5, 5));
		initCalendar();
		nextButtonClick();
		prevButtonClick();
		swapYearMonthClick();
		returnToTodayClick();
	}

	public void buttonClick(){
	}

	//캘린더 출력 초기화(키면 항상 오늘이 나오도록)
	public void initCalendar() {
		Calendar_Info.initializeCalendar();

		//this.add(new JLabel());
		returnToToday = addButton("⟳");
		returnToToday.setFont(new Font("helvetica", Font.BOLD, 20));

		this.add(new JLabel());

		yearLabel = new JLabel(Calendar_Info.getCurYear() + "년");
		yearLabel.setFont(new Font("helvetica", Font.BOLD, 17));
		this.add(yearLabel);

		monthLabel = new JLabel(Calendar_Info.getCurMonth() + "월");
		monthLabel.setFont(new Font("helvetica", Font.BOLD, 17));
		this.add(monthLabel);

		//월 이동 버튼 생성
		prevArrow = addButton(arrow[0]);
		SwapYearMonth = addButton("月");
		SwapYearMonth.setBackground(Color.YELLOW);
		nextArrow = addButton(arrow[1]);

		//무식해도 차라리 이게 더 직관적이고 수정하기 편할듯

		for (int i = 0; i < GRID_SIZE; i++) {
			addLabel(week[i]);
		}

		String viewDay = "";
		int startDayOfMonth = Calendar_Info.getCurDayOfWeek();
		int countDay = 1;

		boolean buttonActive = true;
		for (int i = 0; i < GRID_SIZE * (GRID_SIZE - 1); i++) {

			if(i >= startDayOfMonth && i < Integer.parseInt(Calendar_Info.curMonthOfMaxDay(Calendar_Info.getCurMonth(), 50)) + startDayOfMonth) {
				viewDay = Calendar_Info.curMonthOfMaxDay(Calendar_Info.getCurMonth(), countDay++);
				buttonActive = true;
			}
			else {
				viewDay = "";
				buttonActive = false;
			}

			JButton temp = addButton(viewDay);
			temp.setEnabled(buttonActive);

			if(viewDay.equals(String.valueOf((Calendar_Info.getCurDay())))) {
				temp.setOpaque(true);
				temp.setBackground(Color.MAGENTA);
			}
			else {
				temp.setOpaque(false);
			}

			buttonArr.add(temp);
		}
	}

	public void setCalendar() {
		yearLabel.setText(""+(Calendar_Info.getSetYear() + "년"));
		monthLabel.setText(""+(Calendar_Info.getSetMonth() + "월"));

		String viewDay = "";
		int dayOfWeek = Calendar_Info.getSetDayOfWeek();
		int countDay = 1;

		boolean buttonActive = true;
		for (int i = 0; i < GRID_SIZE * (GRID_SIZE - 1); i++) {

			if(i >= dayOfWeek && i < Integer.parseInt(Calendar_Info.setMonthOfMaxDay(Calendar_Info.getSetMonth(), 50)) + dayOfWeek) {
				viewDay = Calendar_Info.setMonthOfMaxDay(Calendar_Info.getSetMonth(), countDay++);
				buttonActive = true;
			}
			else {
				viewDay = "";
				buttonActive = false;
			}

			if((Calendar_Info.getSetYear() == Calendar_Info.getCurYear()) && (Calendar_Info.getSetMonth() == Calendar_Info.getCurMonth()) && viewDay.equals(String.valueOf((Calendar_Info.getCurDay())))) {
				buttonArr.get(i).setOpaque(true);
				buttonArr.get(i).setBackground(Color.MAGENTA);
			}
			else {
				buttonArr.get(i).setBackground(new JButton().getBackground());
				buttonArr.get(i).setOpaque(false);
			}

			buttonArr.get(i).setEnabled(buttonActive);
			buttonArr.get(i).setText(viewDay);
		}
		
		UIManager.getInstance().reDrawToDoPanel();
	}

	public void swapYearMonthClick() {
		SwapYearMonth.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(SwapYearMonth.getBackground() == Color.YELLOW) {
						SwapYearMonth.setBackground(Color.cyan);
						SwapYearMonth.setText("年");
						isMoveMonth = false;
						return;
					}

					SwapYearMonth.setBackground(Color.YELLOW);
					SwapYearMonth.setText("月");
					isMoveMonth = true;
				}
			}
		});
	}

	public void returnToTodayClick() {
		returnToToday.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					Calendar_Info.setCalendar(Calendar_Info.getCurYear(), Calendar_Info.getCurMonth());
					setCalendar();
				}
			}
		});
	}

	public void nextButtonClick() {
		nextArrow.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(isMoveMonth) {
						Calendar_Info.nextMonth();
					}
					else {
						Calendar_Info.nextYear();
					}

					setCalendar();
				}
			}
		});
	}
	
	public void prevButtonClick() {
		prevArrow.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(isMoveMonth) {
						Calendar_Info.prevMonth();
					}
					else {
						Calendar_Info.prevYear();
					}
					setCalendar();
				}
			}
		});
	}

	//기존 버튼 이벤트 등록
	//	public JButton addButton(String pName) {
	//		JButton jb = new JButton(pName);
	//		jb.setFont(new Font("helvetica", Font.BOLD, 17));
	//		this.setBorder(BorderFactory.createEmptyBorder(BORDERSIZE, BORDERSIZE, BORDERSIZE, BORDERSIZE));
	//		this.add(jb);
	//		return jb;
	//	}

	public JButton addButton(String pName) {
		JButton jb = new JButton(pName);
		jb.setFont(new Font("helvetica", Font.BOLD, 17));
		this.setBorder(BorderFactory.createEmptyBorder(BORDERSIZE, BORDERSIZE, BORDERSIZE, BORDERSIZE));
		this.add(jb);
		jb.addFocusListener(new MyFocuseListener());


		jb.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					String temp = String.format("%d-%02d-%s", Calendar_Info.getSetYear(), Calendar_Info.getSetMonth(), jb.getText());

					if(temp.length() > 8 && temp.replaceAll("[0-9-]", "").equals("")) {
						//날짜 클릭했을 때
						Calendar_Info.setClickDate(jb.getText());
						//						System.out.println("날짜 생성" + Calendar_Info.getClickDate());
						UIManager.getInstance().reDrawToDoPanel();
					}
				}
			}
		});

		return jb;
	}

	public void addLabel(String pName) {
		JLabel lWeek = new JLabel(pName);
		lWeek.setFont(new Font("helvetica", Font.BOLD, 17));
		lWeek.setHorizontalAlignment(JLabel.CENTER);
		lWeek.setOpaque(true);
		lWeek.setBackground(Color.pink);
		lWeek.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.add(lWeek);
	}
}
