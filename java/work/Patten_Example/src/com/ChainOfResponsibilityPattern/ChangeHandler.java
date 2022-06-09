package com.ChainOfResponsibilityPattern;

import java.util.ArrayList;

public abstract class ChangeHandler {

	public ChangeHandler Successor;
	final int hid;

	public ChangeHandler(int hid){
		this.hid = hid;
		Successor = null;
	}

	public abstract String ChangeRequest(ArrayList<Integer> mode, String picture);

	protected boolean IncludeMode(ArrayList<Integer> mode){
		for (Integer m : mode) {
			if (m == hid){
				return true;
			}
		}
		return false;
	}
	
	public ChangeHandler getSuccessor() {
		return Successor;
	}

	public void setSuccessor(ChangeHandler successor) {
		Successor = successor;
	}
}



