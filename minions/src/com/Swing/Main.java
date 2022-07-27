package com.Swing;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main extends Component implements ActionListener {   
   BufferedImage image;
   public void paint(Graphics g) {
      g.drawImage(image, 0, 0, null); //그림을 그리는 메소드
   }
   //디폴트 생성자
   public Main() {
      try {
    	  
         String filename="C:\\Users\\ITWILL\\Downloads\\미니언즈 그림파일\\메인3.jpg";// 파일위치
         image = ImageIO.read(new File(filename));   
         
      } catch (IOException e) { 
         e.printStackTrace();
      }
   }
   public Dimension getPreferredSize() {
      if (image == null) {
         return new Dimension(100,100); //그림 파일이 없을 경우 프레임의 크기를 100,100으로 만든다
      } else {
         return new Dimension(image.getWidth(null), image.getHeight(null)); //그림의 크기에 따라 화면의 크기를 변경한다.
      }
   }
   public static void main(String[] args) {  

      JFrame f = new JFrame("성적처리프로그램 ver1_4조꺼");

      JPanel jp=new JPanel();
      JPanel p1=new JPanel();
      
      Map<String,int[]>stuMap= new HashMap<>();
      
      p1.setBounds(450,700, 50, 120);
      jp.setBounds(500, 700, 380, 110);
      //TextField tf=new TextField(50);
      TextArea ta=new TextArea(50,50);

      Font pt=new Font("굴림",Font.PLAIN,19);
      
      JButton bu1=new JButton(new ImageIcon("C:\\Users\\ITWILL\\Downloads\\미니언즈 그림파일\\입력.jpg"));
      bu1.setBorderPainted(false);
      bu1.setFocusPainted(false);
      bu1.setBounds(30,100,380,270);
      bu1.setBackground(Color.WHITE);
      bu1.setOpaque(false);
      f.add(bu1);
      bu1.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e){
              JPanel pa = new JPanel();
              JFrame f2 = new JFrame("처리");      
              JButton c = new JButton("확인");//추가
             f2.setSize(1500,875);
              JLabel background1=new JLabel(new ImageIcon("C:\\Users\\ITWILL\\Downloads\\미니언즈 그림파일\\입력1.jpg"));
               f2.add(background1);
               JScrollPane sc= new JScrollPane();
              // setContentPane(sc);
               background1.setOpaque(true);
               f2.setVisible(true);
               
                 JTextField tname =new JTextField(15);
                 JTextField tkor =new JTextField(15);
                 
                 JTextField tmath =new JTextField(15);
                 JTextField teng =new JTextField(15);
                 
                 tname.setSize(10, 10);
                 tkor.setSize(10, 10);
                 tmath.setSize(10, 10);
                 teng.setSize(10, 10);
                 
                 //c.setBackground(Color.WHITE);
                 c.setOpaque(false);
                 c.setBounds(1200,310,195,33);
                 
                 pa.setLayout(null);
                 pa.add(c);//추가
                 

                 f2.add(tname);//이름 텍스트필드 위치
                 tname.setBounds(600,260,195,33);
                 
                 f2.add(tkor);//국어 텍스트필드 위치
                 tkor.setBounds(800,260,195,33);
                 
                 f2.add(tmath);//수학 텍스트필드 위치
                 tmath.setBounds(1000,260,195,33);
                 
                 f2.add(teng);//영어 텍스트필드 위치
                 teng.setBounds(1200,260,195,33);
                 
                 f2.add(pa);
                 
                 pa.setVisible(true);
                 f.setVisible(false);
                 f2.setVisible(true);
                 
                 f2.addWindowListener(new WindowAdapter(){
                     public void windowClosing(WindowEvent e) {
                       System.exit(0);
                     }
                  });
                 c.addActionListener(new ActionListener(){//기능추가

                     @Override
                     public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        int score[] = new int[4];
                        String name=String.valueOf(tname.getText());
                        score[0]= Integer.valueOf(tkor.getText());
                        score[1]= Integer.valueOf(tmath.getText());
                        score[2]= Integer.valueOf(teng.getText());
                        score[3]=score[0]+score[1]+score[2];
                        
                        stuMap.put(name, score);
                        f2.setVisible(false);
                        f.setVisible(true);
                     }
                     
                  });
              }
              });
      JButton bu2=new JButton(new ImageIcon("C:\\Users\\ITWILL\\Downloads\\미니언즈 그림파일\\삭제.jpg"));
      bu2.setBounds(30,400,380,270);
      bu2.setBackground(Color.WHITE);
      bu2.setOpaque(false);
      bu2.setBorderPainted(false);
      bu2.setFocusPainted(false);
      f.add(bu2);
      bu2.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e){
              JPanel pa = new JPanel();
              JFrame f3 = new JFrame("처리");      
              JButton c = new JButton("확인");//추가
             f3.setSize(1500,875);
              JLabel background1=new JLabel(new ImageIcon("C:\\Users\\ITWILL\\Downloads\\미니언즈 그림파일\\삭제1.jpg"));
               pa.add(background1);
               f3.add(pa);
               JScrollPane sc= new JScrollPane();
              // setContentPane(sc);
               background1.setOpaque(true);
               f3.setVisible(true);
               
               JTextField de = new JTextField(20);
                 
                 de.setSize(10, 10);
                 
                 //c.setBackground(Color.WHITE);
                 c.setOpaque(false);
                 c.setBounds(1100,310,195,33);
                 
                 f3.setLayout(null);
                 f3.add(c);//추가
                 
                 f3.add(de);
                 de.setBounds(850,232,460,35);
                 
                 f3.add(pa);
                 
                 pa.setVisible(true);
                 f.setVisible(false);
                 f3.setVisible(true);
                 
                 f3.addWindowListener(new WindowAdapter(){
                     public void windowClosing(WindowEvent e) {
                       System.exit(0);
                     }
                  });
                 c.addActionListener(new ActionListener(){//기능추가

                     @Override
                     public void actionPerformed(ActionEvent e) {
                     // TODO Auto-generated method stub
                    String name=String.valueOf(de.getText());
                       stuMap.remove(name);
                       
                       f3.setVisible(false);
                         f.setVisible(true);
                     }
                });
          }
          });
      JButton bu3=new JButton(new ImageIcon("C:\\Users\\ITWILL\\Downloads\\미니언즈 그림파일\\출력.jpg"));
      bu3.setBounds(1150, 100, 380, 270);
      bu3.setBackground(Color.WHITE);
      bu3.setOpaque(false);
      bu3.setBorderPainted(false);
      bu3.setFocusPainted(false);
      f.add(bu3);
      bu3.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e){
             JPanel pa = new JPanel();
              JFrame f4 = new JFrame("처리");      
              JButton c = new JButton("확인");//추가
              //pa.setSize(1500,875);
            f4.setSize(new Dimension(1500,875));
            pa.setSize(new Dimension(1500,875));
           
            f4.setMinimumSize(new Dimension(1500,875));
             JLabel background1=new JLabel(new ImageIcon("C:\\Users\\ITWILL\\Downloads\\미니언즈 그림파일\\출력2.jpg"));
              pa.add(background1);
              f4.add(pa);
               //JScrollPane sc= new JScrollPane();
               //setContentPane(sc);
              background1.setOpaque(true);
               f4.setVisible(true);
               f4.pack();
               //JTextField de = new JTextField(10);
               //JTextField de2 = new JTextField(10);
                 
                 //de.setSize(10, 10);
                // de.setSize(10, 10);
                 
                 c.setBackground(Color.WHITE);
                 c.setOpaque(false);
                 c.setBounds(1140,200,195,33);
                 
                 pa.setLayout(null);
                 
                 
                 //pa.add(de);
                // pa.add(de2);
                 f4.add(c);//추가
                 //de.setBounds(940,290,190,33);
                //.setBounds(1140,290,190,33);
                 f4.add(pa);
                 
                 
                 pa.setVisible(true);
                 f.setVisible(false);
                 f4.setVisible(true);
                 Map<Integer,String>sortMap = new TreeMap<Integer,String>(Collections.reverseOrder());
                for(String iter:stuMap.keySet())
                {
                 sortMap.put(stuMap.get(iter)[3],iter);
                }
              
                int i=1;
                
                JTextArea textArea1 =new JTextArea();//등수
                JTextArea textArea2=new JTextArea();//이름
                JTextArea textArea3=new JTextArea();//국어
                JTextArea textArea4=new JTextArea();//수학
                JTextArea textArea5=new JTextArea();//영어
                for(Integer iter:sortMap.keySet())
                {
                 textArea1.append(i+"\n");
                 //System.out.println(i+"등"+iter+" 점 "+ sortMap.get(iter));
                 i++;
                }
                //textArea1.setBackground(Color.white);
               //textArea2.setBackground(Color.white);
                for(Integer iter:sortMap.keySet())
                {
                   textArea2.append(sortMap.get(iter)+"\n");
                }
                for(Integer iter:sortMap.keySet())
                {
                   textArea3.append(stuMap.get(sortMap.get(iter))[0]+"\n");
                }
                for(Integer iter:sortMap.keySet())
                {
                   textArea4.append(stuMap.get(sortMap.get(iter))[1]+"\n");
                }
                for(Integer iter:sortMap.keySet())
                {
                   textArea5.append(stuMap.get(sortMap.get(iter))[2]+"\n");
                }
                pa.setLayout(null);
                JScrollPane scrollPane = new JScrollPane(textArea1);
               JScrollPane scrollPane2 = new JScrollPane(textArea2);
               textArea1.setBounds(583,310,175,300);//순위
               textArea2.setBounds(408,310,175,300);//이름
               textArea3.setBounds(759,310,175,300);//국어
               textArea4.setBounds(934,310,175,300);//영어
               textArea5.setBounds(1109,310,175,300);//수학
               textArea1.setFont(new Font("굴림",Font.PLAIN,20));
               textArea1.setDisabledTextColor(Color.black);
               textArea2.setFont(new Font("굴림",Font.PLAIN,20));
               textArea2.setDisabledTextColor(Color.black);
               textArea3.setFont(new Font("굴림",Font.PLAIN,20));
               textArea3.setDisabledTextColor(Color.black);
               textArea4.setFont(new Font("굴림",Font.PLAIN,20));
               textArea4.setDisabledTextColor(Color.black);
               textArea5.setFont(new Font("굴림",Font.PLAIN,20));
               textArea5.setDisabledTextColor(Color.black);
               
               textArea1.setEnabled(false);
               textArea2.setEnabled(false);
               textArea3.setEnabled(false);
               textArea4.setEnabled(false);
               textArea5.setEnabled(false);
               
                f4.add(textArea1);
                f4.add(textArea2);
                f4.add(textArea3);
                f4.add(textArea4);
                f4.add(textArea5);
                f4.add(pa);
                f4.pack();
                f4.setVisible(true);
               
               //f4.setVisible(false);
             // f.setVisible(true);
                 f4.addWindowListener(new WindowAdapter(){
                     public void windowClosing(WindowEvent e) {
                       System.exit(0);
                     }
                  });
                 c.addActionListener(new ActionListener(){//기능추가

                     @Override
                     public void actionPerformed(ActionEvent e) {
                     f4.setVisible(false);
                     f.setVisible(true);
                        
                     }
                });
          }
          });
      JButton bu4=new JButton(new ImageIcon("C:\\Users\\ITWILL\\Downloads\\미니언즈 그림파일\\종료.jpg"));
      f.add(bu4);
      bu4.setBorderPainted(false);
      bu4.setFocusPainted(false);
      bu4.setBounds(1150,400,380,270);
      bu4.setBackground(Color.WHITE);
      f.addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e) {
           System.exit(0);
         }
      });
      f.add(new Main());
      
      f.pack();
      
      f.setVisible(true);
      bu3.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
         
         
      }
         
      });
      bu4.addActionListener(new ActionListener(){

         @Override//종료하는부분
          public void actionPerformed(ActionEvent e) {
            
           
            JFrame f1 = new JFrame("bye~");
              f1.setSize(1500,875);
              JLabel background1=new JLabel(new ImageIcon("C:\\Users\\ITWILL\\Downloads\\미니언즈 그림파일\\BYE.jpg"));
               f1.add(background1);
               JScrollPane sc= new JScrollPane();
               //setContentPane(sc);
               background1.setOpaque(true);
               f1.setVisible(true);
              f.setVisible(false);
              f1.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                  System.exit(0);
                }
             });
          }
         
      });
      
   }
@Override
public void actionPerformed(ActionEvent arg0) {
   // TODO Auto-generated method stub   
}
}
