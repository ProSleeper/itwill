package com.day19;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test5 extends Frame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private TextField[] tf = new TextField[4];

	private Label result = new Label("", Label.LEFT);

	private Button btn1, btn2;

	public Test5() {	//생성자

		String[] title= {"name","korea","english","math","total"};

		setTitle("성적");


		setLayout(null);

		for(int i=0;i<5;i++) {
			Label lbl=new Label();
			lbl.setText(title[i]);
			lbl.setBounds(10, (i+1)*30, 50, 20);
			add(lbl);

			if(i!=4) {
				tf[i]= new TextField();

				tf[i].setBounds(80, (i+1)*30, 70, 20);
				tf[i].addKeyListener(new KeyHandler());

				add(tf[i]);
			}else {
				result.setBounds(80, (i+1)*30, 70, 20);

				add(result);
			}
		}

		//결과버튼
		btn1=new Button("calc");
		btn1.setBounds(180, 30, 60, 20);
		add(btn1);
		btn1.addKeyListener(new KeyHandler());


		//종료버튼
		btn2=new Button("exit");
		btn2.setBounds(180, 60, 60, 20);
		add(btn2);
		btn2.addActionListener(this);


		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});


		setSize(260, 180);
		setResizable(false);
		setVisible(true);
	}



	public static void main(String[] args) {
		new Test5();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("퍼폼");
		Object ob=e.getSource();

		if(ob instanceof Button) {

			Button b = (Button)ob; 

			if(b==btn1) {

				execute();

			}else if (b==btn2) {
				System.exit(0);
			}
		}
	}

	private void execute() {
		int tot = 0;
		try {
			for(int i=1;i<=3;i++) {
				tot+=Integer.parseInt(tf[i].getText());
				//문자 읽어올때 getText로 데려오기

				result.setText(Integer.toString(tot));
			}
		} catch (Exception e2) {
			result.setText("error!");
		}

	}

	class KeyHandler extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {

			Object ob=e.getSource();
			if(e.getKeyCode()!=KeyEvent.VK_ENTER) {
				return;
			}

			if(ob instanceof Button) {
				Button b = (Button)ob;
				if(b==btn1) {

					execute();

				}return;
			}

			if(ob instanceof TextField) {

				TextField t = (TextField)ob;

				for(int i=0; i<tf.length;i++) {
					
					if((i!=3) && tf[i]==t ) {
						tf[i+1].requestFocus();
						return;
					}else if(tf[3]==t) {
						btn1.requestFocus();
						return;
					}
				}
			}
			//키보드 이벤트 발생
		}
	}
}


	

