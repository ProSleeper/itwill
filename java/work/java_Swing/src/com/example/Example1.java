package com.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Example1{
 
    public static void main(String[] args) throws IOException, InterruptedException {
        JFrame frm = new JFrame("title");
        frm.setBounds(100, 100, 300, 200);
        // ��ġ������
        frm.setLayout(new BorderLayout());     
        // �ݱ��ư ���α׷�����
        frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
       
        // �г�1 ����
        JPanel pl1 = new JPanel();
        // �г� ũ�� ����
        pl1.setPreferredSize(new Dimension(300, 500));
        pl1.setLayout(new FlowLayout());
        pl1.add(new JButton("�г�1��ư1"));
        pl1.add(new JButton("�г�1��ư2"));
       
        // �г�2 ����
        JPanel pl2 = new JPanel();
        // 2�� 2�� �� ������ 2�� �����ϰ��ִ�.
        pl2.setLayout(new GridLayout(2, 2, 2, 2));
        pl2.add(new JButton("�г�2��ư1"));
        pl2.add(new JButton("�г�2��ư2"));
        pl2.add(new JButton("�г�2��ư3"));
        pl2.add(new JButton("�г�2��ư4"));
       
        // �����ӿ� �г� ���
        frm.add(pl1, BorderLayout.NORTH);
        frm.add(pl2, BorderLayout.CENTER);
       
        frm.setVisible(true);
    }
 
}