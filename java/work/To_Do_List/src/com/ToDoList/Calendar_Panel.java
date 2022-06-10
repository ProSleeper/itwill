package com.ToDoList;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Calendar_Panel extends JPanel {

	private final int GRID_SIZE = 700;
	String[] week = {"일", "월","화", "수", "목", "금","토"};
	String[] arrow = {"<<", ">>"};


	//그리드백 레이아웃으로 바꿔야할듯.

	public Calendar_Panel() {
		this.setBackground(Color.orange);
		this.setLayout(new GridLayout(0, 7, 5, 5));
		JButton jb = null;

		
		
		String day = "";
		int dayInt = 1;
		long miliseconds = System.currentTimeMillis();
		Date date = new Date(miliseconds);
		System.out.println(miliseconds);
		
//		for (int i = 0; i < GRID_SIZE; i++) {
//			for (int j = 0; j < GRID_SIZE; j++) {
//					if(i > 1) {
//						day += dayInt++;
//					}
//					else if(i == 1) {
//						day = week[j];
//						jb = new JButton(day);
//						jb.setEnabled(false);
//						jb.setFont(new Font("helvetica", Font.BOLD, 18));
//						this.add(jb);
//						day = "";
//						continue;
//					}
//					else if(i == 0 && j == 0 || j == 6) {
//						day = arrow[j%5];
//					}
//					else {
//						if(j == 3) {
//							jb = new JButton("6");
//							jb.setFont(new Font("helvetica", Font.BOLD, 18));
//							this.add(jb);
//							day = "";
//
//							continue;
//						}
//						this.add(new JLabel());
//						continue;
//					}
//
//					jb = new JButton(day);
//					jb.setFont(new Font("helvetica", Font.BOLD, 17));
//					this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
//					this.add(jb);
//					day = "";
//				}
//		}
		
	for (int i = 0; i < GRID_SIZE; i++) {
		for (int j = 0; j < arrow.length; j++) {
			System.out.print("");
		}
	}
		
		Date dd = new Date();
		System.out.println(dd.getTime());

		//		System.out.println(dd.getTime() / 1000 / 60 / 60/ 24/ 365);
		//		System.out.println("일: " + dd.getTime() / 1000 / 60 / 60/ 24);
		//		System.out.println(dd.getTime() / 1000 / 60 / 60);

		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {

				if(i > 1) {
					day += dayInt++;
				}
				else if(i == 1) {
					day = week[j];
					jb = new JButton(day);
					jb.setEnabled(false);
					jb.setFont(new Font("helvetica", Font.BOLD, 18));
					this.add(jb);
					day = "";
					continue;
				}
				else if(i == 0 && j == 0 || j == 6) {
					day = arrow[j%5];
				}
				else {
					if(j == 3) {
						jb = new JButton("6");
						jb.setFont(new Font("helvetica", Font.BOLD, 18));
						this.add(jb);
						day = "";

						continue;
					}
					this.add(new JLabel());
					continue;
				}

				jb = new JButton(day);
				jb.setFont(new Font("helvetica", Font.BOLD, 17));
				this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
				this.add(jb);
				day = "";
			}
		}
	}
}