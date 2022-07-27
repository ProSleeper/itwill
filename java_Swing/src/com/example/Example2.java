package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//���� import�� �͵��� ��� �� �� �ʿ��ؼ� �߰���.. �ϰ� �Ѿ��. 

 
//���� �ڵ忡�� �� ���� �ִ� ���� ���� �ȵǴ� �κ� 2
@SuppressWarnings("serial")
class JPanel01 extends JPanel { // 1��° �г�
 
    private JButton jButton1;		
    private JScrollPane jScrollPane1;	// TextArea���� ����� ��ũ�� ����
    private JTextArea jTextArea1;		// TextArea���� ����
    private JPanelTest win;
 
    public JPanel01(JPanelTest win) {
        this.win = win;	//�� panel�� ��Ʈ�� �� �� �ֵ��� ������ JPanelTest win�� �Ű������� ���� win�� �־���.(���� �������µ� �ڹٴ� �̷��� ��ü�� �־��ָ� call by reference�� �Ű������� �־��ָ� ������ ��ü�� ����Ű�� �ȴ�.
        setLayout(null);
 
        jButton1 = new JButton("��ư");
        jButton1.setSize(70, 20);
        jButton1.setLocation(10, 10);
        add(jButton1);
 
        jTextArea1 = new JTextArea();
 
        jScrollPane1 = new JScrollPane(jTextArea1);	//��ũ���г� ����
        jScrollPane1.setSize(200, 150);				//ũ�� ����
        jScrollPane1.setLocation(10, 40);			//��ġ ����
        add(jScrollPane1);
 
        jButton1.addActionListener(new MyActionListener());
    }
 
    class MyActionListener implements ActionListener { // ��ư Ű ������ �г� 2�� ȣ��
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("panel02");
        }
    }
}
 
//���� �ڵ忡�� �� ���� �ִ� ���� ���� �ȵǴ� �κ� 2
@SuppressWarnings("serial")
class JPanel02 extends JPanel { // 2��° �г�
    private JTextField textField;			//�ؽ�Ʈ�ʵ� ����
    private JPasswordField passwordField;	//�н������ʵ� ����
    private JPanelTest win;					//�� Panel02�� ��Ʈ�� �� �� �ֵ��� win�� ����?
 
    public JPanel02(JPanelTest win) {
        setLayout(null);	//��� ���̾ƿ� ���� �ʱ�ȭ(�̰� ���ϸ� swing��ü���� ������ ���̾ƿ��� ������ ��ġ�� �ȴ�)
        this.win = win;		//������ ������ win�� �Ű������� �޾ƿ� win�� �̾��ش�? �־��ش�?
        JLabel lblLbl = new JLabel("���̵�:");	//���̵� ��
        lblLbl.setBounds(31, 40, 67, 15);		//���̵� ��ġ ����(���� �̷��� 4���� ���ڰ� ������ x, y, width, height ��� ���� �ȴ�.
        add(lblLbl);	//JFrame�� �߰� ���Ѽ� ȭ�鿡 �����ش�.(�̰� ���ϸ� ȭ�鿡 �Ⱥ��δ�.
 
        textField = new JTextField();	//TextField ����(�ؽ�Ʈ�� �Է¿��� TextField�� TextArea 2���� �ִٰ� �ϴµ� �������� ������ area, �� ������ ������ field�� ���ٰ� �Ѵ�.
        textField.setBounds(123, 40, 116, 21);	//��ġ ����
        add(textField);	//�� lblLbl�� �����ϰ� frame�� �߰� ��Ŵ
        textField.setColumns(10);	//�̰� �Ƹ� �ؽ�Ʈ�ʵ��� �⺻ ũ�⸦ 10ĭ���� ���شٴ� ���� �� ����.
 
        JLabel lblLbl_1 = new JLabel("��ȣ:");	//��ȣ ��
        lblLbl_1.setBounds(31, 84, 67, 15);		//��ġ ����
        add(lblLbl_1);	//�� lblLbl�� �����ϰ� frame�� �߰� ��Ŵ
 
        passwordField = new JPasswordField();	//�н������ʵ� ����
        passwordField.setBounds(123, 84, 116, 21);	//��ġ ����
        add(passwordField);	//�� lblLbl�� �����ϰ� frame�� �߰� ��Ŵ
 
        JButton btn = new JButton("��ư");	//��ư ����
        btn.setSize(70, 20);	//ũ�� ����
        btn.setLocation(10, 10);	//��ġ �����ε�..(���� setBoundsó�� �ѹ��� ������ �ȵǳ�? �ǰ���?)
        add(btn);	//frame�� �߰�
        btn.addActionListener(new MyActionListener());	//��ư�� ������ ���� ��ų �̺�Ʈ ����
    }
 
    //��ư�� ������ ������ �̺�Ʈ
    class MyActionListener implements ActionListener { // ��ư Ű ������ �г� 1�� ȣ��
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("panel01");
        }
    }
}
 
 
//���� �ڵ忡�� �� ���� �ִ� ���� ���� �ȵǴ� �κ� 1 serial�� �����غ��ǵ� �Ƹ� ����ȭ?
@SuppressWarnings("serial")			
class JPanelTest extends JFrame {
 
    public JPanel01 jpanel01 = null;		//�� ��ü���� ��Ʈ���� �г�1
    public JPanel02 jpanel02 = null;		//�г�2
 
    public void change(String panelName) { 	//�г� 1���� 2�� ���� �� �缳��
 
        if (panelName.equals("panel01")) {	//�г� �̸��� panel01�� ������
            getContentPane().removeAll();	//�̹� �׷��� �гο��� ���� �����
            getContentPane().add(jpanel01);	//jpanel01�� add�� �� 
            revalidate();					//�Ƹ� �� revalidate �� repaint�� Ȯ���ϰ� ȭ�鿡 �ٽ� �ѷ��ִ� ������ �� ����.
            repaint();						//���߿� ���� �Ǹ� �׶� Ȯ���ϰ� �����ϴ� �ɷ�.
        } else {
            getContentPane().removeAll();	//���� �����ϴ�.
            getContentPane().add(jpanel02);
            revalidate();
            repaint();
        }
    }
 
}
 
public class Example2 {
    public static void main(String[] args) {
 
        JPanelTest win = new JPanelTest();	//�г� 2���� ��Ʈ�� �ϱ� ���� Ŭ����. �ٵ� ��� ���� �г� 2���� ���ϰ� change ���ִ� �Լ��� ���� ���̴�.
 
        win.setTitle("frame test");			//�г� Ÿ��Ʋ
        win.jpanel01 = new JPanel01(win);	//��Ʈ�� �� �г�1 ���� �� �Ҵ�
        win.jpanel02 = new JPanel02(win);	//��Ʈ�� �� �г�2 ���� �� �Ҵ�
 
        win.add(win.jpanel01);				//������ �г��� frame�� �Ҵ�
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//x��ư�� ������ ���α׷��� ���� ����.(���ϸ� x�� ������ â�� �������� ���� ���α׷��� ��� ���ư���.
        win.setSize(300, 300);				//������ ������
        win.setVisible(true);				//������ Ȱ��ȭ(���̵���
    }
}
 
 