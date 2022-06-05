package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;


public class Home_Panel extends JPanel{

	private Main_Frame mf;
	JFrame frame;
	JPanel jp_label, jp_btn;
	JScrollPane scroll;
	JLabel label;
	JButton btn ;
	int count =1;
	GridBagLayout Gbag = new GridBagLayout();
	GridBagConstraints gbc1;
	IndicateOneToDo_Panel ip;
	

	// 체크박스와 버튼을 하나의 패널로
	public Home_Panel(Main_Frame mf)  {
		this.mf = mf;
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		
		ArrayList<IndicateOneToDo_Panel> ip = new ArrayList<>();
		

		JPanel scrollPanel = new JPanel();
		//scrollPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		System.out.println(scrollPanel.getLayout());
		//scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
		
		
//		scrollPanel.setLayout(new BorderLayout());
		scrollPanel.setPreferredSize(new Dimension( 437,30));
		JScrollPane scrollFrame = new JScrollPane(scrollPanel);
		scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
		scrollFrame.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollFrame.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(800,540));
		this.add(scrollFrame);
		
		int tArea = 0;
		
		ip.add(new IndicateOneToDo_Panel());
		tArea++;
		scrollPanel.add(ip.get(0));
		
//		for (int i = 0; i < 10; i++) {
//			ip.add(new IndicateOneToDo_Panel());
//			tArea++;
//			scrollPanel.add(ip.get(i));
//		}
		scrollPanel.setPreferredSize(new Dimension( 437,30 + tArea * 55));
		
	}
}
