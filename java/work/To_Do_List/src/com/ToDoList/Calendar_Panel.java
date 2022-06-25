package com.ToDoList;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


//2022-6-23일에 학원에서 배운 listener 이용하면 코드를 줄이거나 좀 더 효율적으로 짤 수 있을 듯
class MyFocuseListener implements FocusListener {

    @Override
    public void focusGained(FocusEvent e) {
    	//JButton aa = (JButton)e.getComponent();
        //System.out.println(e.getSource().getClass().getName());
        //System.out.println("MyFocuseListener.focusGained()");
        //System.out.println(aa.getText());
    }

    @Override
    public void focusLost(FocusEvent e) {
    	//JButton aa = (JButton)e.getComponent();
    	//System.out.println(aa.getText());
//    	//aa.setBackground(Color.black);
//    	aa.setOpaque(true);
//        System.out.println(e.getSource().getClass().getName());
//        System.out.println("MyFocuseListener.focusLost()");
//        aa.setBackground(Color.black);
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
		returnToToday.setFocusable(false);

		this.add(new JLabel());

		yearLabel = new JLabel(Calendar_Info.getCurYear() + "년");
		yearLabel.setFont(new Font("helvetica", Font.BOLD, 17));
		this.add(yearLabel);

		monthLabel = new JLabel(Calendar_Info.getCurMonth() + "월");
		monthLabel.setFont(new Font("helvetica", Font.BOLD, 17));
		this.add(monthLabel);

		//연,월 선택 이동 버튼
		prevArrow = addButton(arrow[0]);
		prevArrow.setFocusable(false);
		SwapYearMonth = addButton("月");
		SwapYearMonth.setFocusable(false);
		SwapYearMonth.setBackground(Color.YELLOW);
		nextArrow = addButton(arrow[1]);
		nextArrow.setFocusable(false);

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
				temp.requestFocus();		//포커스 얻는 부분이 안됨. 근데 항상 프로그램 시작시 5번째 열 1번째 버튼이 포커스를 가지고 있음(이유가 있을듯) 파악해보자
				
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

					
//					//jb.setFocusable(true);
//					System.out.println(jb.isFocusable());
					
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
