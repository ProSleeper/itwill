package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

public class CheckBox_Panel extends JPanel{

	public JCheckBox cb = null;
	
	public CheckBox_Panel() {
		this.setBackground(Color.red);
		this.setLayout(new BorderLayout());
		cb = new JCheckBox("<HTML>1843263fas46fdadsaff6878</HTML>");	//HTML�� �ٿ��� �׷���? �ڵ� �ٹٲ��� �ǳ�?
		
		
		cb.setToolTipText(cb.getText());
		ToolTipManager ttm = ToolTipManager.sharedInstance();
		ttm.setInitialDelay(100);
		ttm.setDismissDelay(10000);
		
		
		
		cb.setPreferredSize(new Dimension(400, 50));
		
		this.add(cb, BorderLayout.WEST);
	}
}
