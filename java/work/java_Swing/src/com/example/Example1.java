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
        // 배치관리자
        frm.setLayout(new BorderLayout());     
        // 닫기버튼 프로그램종료
        frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
       
        // 패널1 생성
        JPanel pl1 = new JPanel();
        // 패널 크기 조절
        pl1.setPreferredSize(new Dimension(300, 500));
        pl1.setLayout(new FlowLayout());
        pl1.add(new JButton("패널1버튼1"));
        pl1.add(new JButton("패널1버튼2"));
       
        // 패널2 생성
        JPanel pl2 = new JPanel();
        // 2행 2열 과 간격을 2로 지정하고있다.
        pl2.setLayout(new GridLayout(2, 2, 2, 2));
        pl2.add(new JButton("패널2버튼1"));
        pl2.add(new JButton("패널2버튼2"));
        pl2.add(new JButton("패널2버튼3"));
        pl2.add(new JButton("패널2버튼4"));
       
        // 프레임에 패널 얹기
        frm.add(pl1, BorderLayout.NORTH);
        frm.add(pl2, BorderLayout.CENTER);
       
        frm.setVisible(true);
    }
 
}