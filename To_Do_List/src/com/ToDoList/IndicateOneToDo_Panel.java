package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//iotd 한줄씩을 가지고 있을 패널
public class IndicateOneToDo_Panel extends JPanel{

	private JCheckBox jcb = null;
	private JButton jb = null;
	private String doText = null;
	
	private Font activeFont;
	private Font completedFont;

	public IndicateOneToDo_Panel(String toDoText , boolean pCheck)  {
		this.setLayout(new BorderLayout());
		//		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBorder(new TitledBorder(new LineBorder(Color.black)));
		
		setDoText(toDoText);
		jcb = new JCheckBox();
		jb = new JButton("...");
		
		jcb.setMaximumSize(new Dimension(Integer.MAX_VALUE, jcb.getMinimumSize().height));

		activeFont = Assistant_Data.FontSelect("active");
		completedFont = Assistant_Data.FontSelect("strike");
		jcb.setSelected(pCheck);
		setCheckButton(pCheck);
		
		
		setCheckBoxAddListner();
		setButtonAddListener();
		
		//jcb.setFont(activeFont);
		//jcb.setBackground(Color.WHITE);
		jcb.setText(toDoText);
		
		jcb.setToolTipText(toDoText);	//툴팁 세팅이긴한데 이건 초기세팅만 이런거고, redraw나 텍스트 변경시에도 적용해주자
		
//		System.out.println(jcb.getPreferredSize());
		
		jcb.setPreferredSize(new Dimension(399, 23));
		
		
		this.add(jcb, BorderLayout.WEST);
		this.add(jb, BorderLayout.EAST);
		
		//ZOrder 세팅인데 위에 preferredSize를 설정해주면 굳이 필요가 없어보인다.
//		this.setComponentZOrder(jb, 0);
//		this.setComponentZOrder(jcb, 1);
		
	}

	public void setEditCheckBoxText() {
		Object todoText = JOptionPane.showInputDialog(null, "수정 해주세요", "수정", JOptionPane.YES_NO_CANCEL_OPTION, null, null, jcb.getText());
		
		if(todoText != null) {
			if(!todoText.equals("")) {
				jcb.setText(todoText.toString());
				setDoText(todoText.toString());
			}
		}
	}
	
	public void setButtonAddListener() {
		jb.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					setButtonClick();
				}
				else if(e.getButton() == MouseEvent.BUTTON3) {
					if(e.getClickCount() == 2) {
						System.out.println("오른쪽 더블클릭");
					}
				}
			}
		});
	}
	
	public void setButtonClick() {
		String[] buttons = {"수정", "삭제"};
		int select = JOptionPane.showOptionDialog(null, "실행할 작업을 눌러주세요..", "수정, 삭제",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);

		if(select == 0) {
			setEditCheckBoxText();
		}
		else if(select == 1) {
			//			System.out.println("삭제");
			UIManager.getInstance().deleteToDoPanel(this);
			//			
			//			this.remove(btn);
			//			this.revalidate();
			//			this.repaint();
		}
	}

	private void setCheckBoxAddListner() {
		jcb.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				//System.out.println(jcb.getText());
				setCheckButton(jcb.isSelected());
				setCheckedData(jcb.isSelected());
			}
		});
	}
	
	public void setCheckButton(boolean pCheck) {
		if(pCheck) {
			jcb.setFont(completedFont);
			jcb.setBackground(Color.LIGHT_GRAY);
		}
		else {
			jcb.setFont(activeFont);
			jcb.setBackground(Color.WHITE);
		}
	}
	
	public void setCheckedData(boolean pCheck){
		//System.out.println(pCheck);
		UIManager.getInstance().doneCheckList(this, pCheck);
	}

	public String getDoText() {
		return doText;
	}

	public void setDoText(String doText) {
		this.doText = doText;
	}
}
