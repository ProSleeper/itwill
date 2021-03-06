package com.ToDoList;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


//이 Main_Frame을 싱글턴화 시켜서 사용하면 굳이 UIManager같은거 안만들어도 되겠지만.
//이런 형식이 맞는 건가의 의문은 계속 존재한다.
public class Main_Frame extends JFrame implements ActionListener{

	private Calendar_Panel cp;
	private ShowToDo_Panel sp;


	//메인프레임
	public Main_Frame() {
		SetUI();
		createMenu();
		setTitle("                                                              " + "TodoList");

		setLayout(new GridLayout(1, 1));	//그리드레이아웃은 딱히 설정의 제한이 강력하지 않은가보다. 대충 panel붙여도 다 붙여지네
		setVisible(true);
		setSize(960, 540);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//위 코드는 윈도우에서는 x를 눌러서 닫아도, alt+f4로 닫아도 작동하지만
		//mac에서는 따로 코드를 작성해줘야지 command+q를 해주는 이벤트를 캐치 할 수 있을 것 같다.
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				//파일 저장부분
				DataManager.getInstance().saveData();
				System.exit(0);
			}
		});


	}

	private void SetUI() {
		sp = new ShowToDo_Panel();
		cp = new Calendar_Panel(this);
		//this.getRootPane()

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


		//메뉴에서 Add버튼 누르면 생성시키는 팝업 띄우는 코드
		item.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){

				String todoText = JOptionPane.showInputDialog("할일을 입력하세요");

				if(todoText != null && !todoText.equals("")) {
					DataManager.getInstance().createData(todoText);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
