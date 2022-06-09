package com.ChainOfResponsibilityPattern;

import java.util.ArrayList;

public class SoftChangeHandler extends ChangeHandler {
	
	public SoftChangeHandler(int hid)
	{
		super(hid);
	}
	
	
	@Override
	public  String ChangeRequest(ArrayList<Integer> mode, String picture)
	{
		if (IncludeMode(mode))
		{
			picture = picture.replace("날카로운", "부드러운");
		}
		if (Successor != null)
		{
			picture = Successor.ChangeRequest(mode, picture);
		}
		return picture;
	}
}