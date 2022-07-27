package com.day20;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test4 extends JFrame implements ActionListener {

	private JTextArea ta;
	
	private JTextField tf;
	
	public Test4() {
		ta = new JTextArea();
		add(ta);
		
		tf = new JTextField("https://");
		tf.addActionListener(this);
		add(tf, BorderLayout.NORTH);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
			
		});
		
		setTitle("HTML Viewer");
		setSize(400, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Test4();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			String str;
			
			URL url = new URL(tf.getText());
			
			ta.setText("");
			
			//InputStream is = url.openStream();
			//BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			while ((str = br.readLine()) != null) {
				if(ta.getText().equals("")){
					ta.setText(str);
				}
				else {
					ta.setText(ta.getText() + "\r\n" + str);
				}
			}
			
			is.close();
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		
		
	}

}
