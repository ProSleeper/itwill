package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Home_Panel extends JPanel{

	private Main_Frame mf;
	private final int MAXLABELCOUNT = 10;
	
	public Home_Panel(Main_Frame mf)  {
		this.mf = mf;
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(0, 0, 480, 520);
		this.setLayout(new GridLayout(MAXLABELCOUNT,1));
		
<<<<<<< HEAD
<<<<<<< HEAD
		for (int i = 0; i < 30; i++) {
			lb[i] = new JCheckBox((i+1) + " ��°");
			lb[i].setAlignmentX(Component.LEFT_ALIGNMENT);
			this.add(lb[i]);
=======
=======
>>>>>>> parent of 19cf22f (성능부족이라니...)
		JCheckBox[] lb = new JCheckBox[MAXLABELCOUNT];
		
		for (int i = 0; i < MAXLABELCOUNT; i++) {
			lb[i] = new JCheckBox();
<<<<<<< HEAD
>>>>>>> parent of 19cf22f (성능부족이라니...)
=======
>>>>>>> parent of 19cf22f (성능부족이라니...)
			
			//lb[i].setSize(100, 50);
			this.add(lb[i]);
			//lb[i].setSize(100, 50);
		}
<<<<<<< HEAD
<<<<<<< HEAD
		JScrollPane scrollbar = new JScrollPane();
		//scrollbar.setViewport(viewport);

		cn.add(scrollbar);
		cn.add(this);



		//		lb.setBounds(200,0, 100, 100);
		//		lb2.setBounds(100, 0, 100, 100);

		//		this.add(lb);
		//		this.add(lb2);
=======
=======
>>>>>>> parent of 19cf22f (성능부족이라니...)
		
		
		
//		lb.setBounds(200,0, 100, 100);
//		lb2.setBounds(100, 0, 100, 100);
		
//		this.add(lb);
//		this.add(lb2);
<<<<<<< HEAD
>>>>>>> parent of 19cf22f (성능부족이라니...)
=======
>>>>>>> parent of 19cf22f (성능부족이라니...)
	}
	
	void initialize(JFrame mainFrame) {
//		JPanel panel = new JPanel();
//
////		add(panel);
//		JLabel label = new JLabel("�ؽ�Ʈ�� �Է��Ͻÿ�.");
//		
//		panel.setLayout(new BorderLayout());
//		panel.add(label, BorderLayout.NORTH);
//		mainFrame.add(this);
//		System.out.println("�ֵ�ֵ�");
	}

}

//
///*
// * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
// *
// * Redistribution and use in source and binary forms, with or without
// * modification, are permitted provided that the following conditions
// * are met:
// *
// *   - Redistributions of source code must retain the above copyright
// *     notice, this list of conditions and the following disclaimer.
// *
// *   - Redistributions in binary form must reproduce the above copyright
// *     notice, this list of conditions and the following disclaimer in the
// *     documentation and/or other materials provided with the distribution.
// *
// *   - Neither the name of Oracle or the names of its
// *     contributors may be used to endorse or promote products derived
// *     from this software without specific prior written permission.
// *
// * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
// * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
// * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
// * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
// * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
// * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
// * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
// * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
// * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// */ 
//
//package layout;
//
///*
// * BoxLayoutDemo.java requires no other files.
// */
//
//import java.awt.Component;
//import java.awt.Container;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//
//public class BoxLayoutDemo {
//    public static void addComponentsToPane(Container pane) {
//        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
//
//        addAButton("Button 1", pane);
//        addAButton("Button 2", pane);
//        addAButton("Button 3", pane);
//        addAButton("Long-Named Button 4", pane);
//        addAButton("5", pane);
//    }
//
//    private static void addAButton(String text, Container container) {
//        JButton button = new JButton(text);
//        button.setAlignmentX(Component.CENTER_ALIGNMENT);
//        container.add(button);
//    }
//
//    /**
//     * Create the GUI and show it.  For thread safety,
//     * this method should be invoked from the
//     * event-dispatching thread.
//     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("BoxLayoutDemo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Set up the content pane.
//        addComponentsToPane(frame.getContentPane());
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
//}
