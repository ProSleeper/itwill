package com.day3;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Test_JFrame {

	Test_JFrame()
	{
		
		
	}
	
	void showBox(String message) {
		
	}

	
	public static void main(String[] args) {
		JFrame frm = new JFrame();
		
		frm.setTitle("넌 집에 못간다~");
	
		
		frm.setSize(350, 300);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(null);
		 
		JButton btn1 = new JButton("집에 가고 싶니?");
		btn1.setBounds(30, 170, 200, 30);
		frm.getContentPane().add(btn1);
		
		JLabel lbl = new JLabel();
        lbl.setBounds(30, 200, 274, 50);
        lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
        frm.getContentPane().add(lbl);
		
		btn1.addActionListener(event -> {
			JOptionPane.showMessageDialog(null,"못감");
        });
		
		frm.setVisible(true);
		
	}
	
}
