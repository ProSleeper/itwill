package com.ChainOfResponsibilityPattern;
import java.util.ArrayList;

public class UIPart {

	ChangeHandler head = null;
	ChangeHandler tail = null;

	public void AddChangeHandler(ChangeHandler handler)
	{
		if(head != null)
		{		
			tail.Successor= handler;
			tail = handler;
		}
		else
		{
			head = tail = handler;
		}
	}

	public String ChangeRequest(ArrayList<Integer> mode, String subject)
	{
		if(head!=null)
		{
			return head.ChangeRequest(mode,subject);
		}
		return subject;
	}

	public static void main(String[] args) {
		String picture = "";
		ArrayList<Integer> mode = new ArrayList<>();
		ChangeHandler[] handlers = new ChangeHandler[3];
		
		handlers[0] = new GrayChangeHandler(0);
		handlers[1] = new SoftChangeHandler(1);
		handlers[2] = new RedEyeChangeHandler(2); 
		
		UIPart uipart = new UIPart();
		
		uipart.AddChangeHandler(handlers[0]);
		uipart.AddChangeHandler(handlers[1]);
		uipart.AddChangeHandler(handlers[2]);
		
		picture = uipart.ChangeRequest(mode,"Ä®¶ó »¡°£´« ³¯Ä«·Î¿î ¸ö¸Å");
		System.out.println(picture);
		mode.add(0);
		
		picture = uipart.ChangeRequest(mode,"Ä®¶ó »¡°£´« ³¯Ä«·Î¿î ¸ö¸Å");
		System.out.println(picture);
		mode.add(2);
		
		picture = uipart.ChangeRequest(mode,"Ä®¶ó »¡°£´« ³¯Ä«·Î¿î ¸ö¸Å");
		System.out.println(picture);
		mode.add(1);
		
		picture = uipart.ChangeRequest(mode,"Ä®¶ó »¡°£´« ³¯Ä«·Î¿î ¸ö¸Å");
		System.out.println(picture);
	}
}


