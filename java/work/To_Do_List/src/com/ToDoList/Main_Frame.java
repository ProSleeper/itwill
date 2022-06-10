package com.ToDoList;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;


//이 Main_Frame을 싱글턴화 시켜서 사용하면 굳이 UIManager같은거 안만들어도 되겠지만.
//이런 형식이 맞는 건가의 의문은 계속 존재한다.
public class Main_Frame extends JFrame{

	private Calendar_Panel cp;
	private ShowToDo_Panel sp;


	//메인프레임
	public Main_Frame() {
		SetUI();
		createMenu();
		setTitle("여기를 드래그하면 창을 이동할 수 있습니다.");
		setLayout(new GridLayout(1, 1));	//그리드레이아웃은 딱히 설정의 제한이 강력하지 않은가보다. 대충 panel붙여도 다 붙여지네
		setVisible(true);
		setSize(960, 540);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void SetUI() {
		sp = new ShowToDo_Panel();
		cp = new Calendar_Panel();

		this.add(sp);
		this.add(cp);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar(); 
		JMenu screenMenu = new JMenu("File");
		JMenuItem item = new JMenuItem("Add");


		//screenMenu.add(new JMenuItem("Add"));
		screenMenu.add(item);
		//		screenMenu.add(new JMenuItem("ReShow"));
		//		screenMenu.addSeparator();
		//		screenMenu.add(new JMenuItem("Exit"));
		//
		mb.add(screenMenu);
		//		mb.add(new JMenu("Edit"));
		//		mb.add(new JMenu("Source"));
		//		mb.add(new JMenu("Project"));
		//		mb.add(new JMenu("Run"));
		setJMenuBar(mb);


		item.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){

				String todoText = JOptionPane.showInputDialog("할일을 입력하세요");

				if(todoText != null && !todoText.equals("")) {
					DataManager.getInstance().createData(todoText);
					UIManager.getInstance().createToDoPanel();
				}
			}
		});
	}

	public Calendar_Panel getCp() {
		return cp;
	}

	public void setCp(Calendar_Panel cp) {
		this.cp = cp;
	}

	public ShowToDo_Panel getSp() {
		return sp;
	}

	public void setSp(ShowToDo_Panel sp) {
		this.sp = sp;
	}




}
