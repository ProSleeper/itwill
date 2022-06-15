package com.ToDoList;

import java.util.ArrayList;
import java.util.Date;

//��� ������ ����
public class DataManager {
	private static DataManager dm = null;
	ArrayList<ToDoList_Object> tdloList = null;

	private DataManager() {
		tdloList = new ArrayList<>();
//		setCalendar(); ���߿� �޷� ������ ������ �� �κ�
	}
	
	public static DataManager getInstance() {
		if(dm == null) {
			dm = new DataManager();
		}
		return dm;
	}
	
	public void setUIManager(UIManager dataManager) {
		
	}
	
	public void setFactoryClass(ToDoDataFactory tdlf) {
		
	}

	//����Ʈ ���� �̺�Ʈ�� �߻����� �� �� �޼��带 �����ؼ� ��������
	//������ ToDoListFactory ���� ������ ���ְ� �ؾ��ϴµ� ����� �����κ��� �ʹ� �۾Ƽ� ���⼭ ����
	//���� ����
	public void createData(String toDoText) {
		tdloList.add(new ToDoList_Object(toDoText));
	}
	
//	�����͸� ���� �Ѱ��ִ� �� �´� ���� �ƴϸ�
//  �� DataManager���� �����͸� ������ UIManager�� �����ؼ� �����͸� �ѷ��ִ� �� �´°��� ���� �𸣰ڴ�.
//	�ϴ� ���� ���� �����, ���Ŀ� � ��쿡�� �ᱹ DB�� ���� �����ؼ� �������״ϱ�
//	���⼭�� �� DataManager�� DB ��� �����ϰ� DB�� UIManager�� �ҷ��ͼ� ������ִ� ������� ����.
	public ArrayList<ToDoList_Object> getData(){
		return tdloList;
	}
	
}