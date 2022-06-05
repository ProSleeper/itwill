package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;

public class CheckBox_Panel extends JPanel{

	BorderLayout bl = null;
	public JCheckBox cb = null;
	
	public CheckBox_Panel() {
		//this.setBackground(Color.GREEN);
		bl = new BorderLayout();
		this.setLayout(bl);
		//this.setAlignmentX(Component.LEFT_ALIGNMENT );
		cb = new JCheckBox("Ã¹ ¹ø123132136184326381436846t46f84a6f8d46f846sd84fa6fd8468fas46fda8f4a68a4fdfÂ°3f");
		cb.setToolTipText(cb.getText());
		ToolTipManager ttm = ToolTipManager.sharedInstance();
		ttm.setInitialDelay(100);
		ttm.setDismissDelay(10000);
		
		
		
		cb.setPreferredSize(new Dimension(420, 50));
		
		this.add(cb, BorderLayout.WEST);
	}
}
