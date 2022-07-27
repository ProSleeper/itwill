package com.ChainOfResponsibilityPattern;

import java.util.ArrayList;

public class GrayChangeHandler extends ChangeHandler {

	
	 public GrayChangeHandler(int hid)
     {
		super(hid);
     }
	 
	 @Override
     public String ChangeRequest(ArrayList<Integer> mode, String picture)
     {
         if(IncludeMode(mode))
         {
             picture = picture.replace("Ä®¶ó","Èæ¹é");
         }
         if (Successor != null)
         {
             picture = Successor.ChangeRequest(mode, picture);
         }
         return picture;
     }
}