package com.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.GridLayout; 

import javax.swing.JButton; 
import javax.swing.JFrame; 

public class Example1 extends JFrame { 
    public Example1() { // ������ 
        super("GridLayoutExam"); 
        // ���̾ƿ� ���� 
        super.setLayout(new GridLayout(0, 3)); // 3�� 2�� 
        // super.setLayout(new GridLayout(0,3)); //���� ������ 3���̰� ���� �þ�� 
        // super.setLayout(new GridLayout(2,0)); //���� ������ 2���̰� ���� �þ��. 
        // super.setLayout(new GridLayout()); //���࿡ ���� �þ��. 

        // �߰� 
        add(new JButton("��ư 1")); 
        add(new JButton("��ư 2")); 
        add(new JButton("��ư 3")); 
        add(new JButton("��ư 4")); 
        add(new JButton("��ư 5")); 
        add(new JButton("��ư 4")); 
        add(new JButton("��ư 5")); 
        // ũ�� 
        super.setSize(300, 400); 
        // ���̱� 
        super.setVisible(true); 
        // x ��ư Ȱ��ȭ 
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 

    public static void main(String[] args) { 
        new Example1(); 
    } 
} 