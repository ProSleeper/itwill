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


//�� Main_Frame�� �̱���ȭ ���Ѽ� ����ϸ� ���� UIManager������ �ȸ��� �ǰ�����.
//�̷� ������ �´� �ǰ��� �ǹ��� ��� �����Ѵ�.
public class Main_Frame extends JFrame{

	private Calendar_Panel cp;
	private ShowToDo_Panel sp;


	//����������
	public Main_Frame() {
		SetUI();
		createMenu();
		setTitle("���⸦ �巡���ϸ� â�� �̵��� �� �ֽ��ϴ�.");
		setLayout(new GridLayout(1, 1));	//�׸��巹�̾ƿ��� ���� ������ ������ �������� ����������. ���� panel�ٿ��� �� �ٿ�����
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


		item.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
			public void actionPerformed(ActionEvent e){

				String todoText = JOptionPane.showInputDialog("������ �Է��ϼ���");

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
