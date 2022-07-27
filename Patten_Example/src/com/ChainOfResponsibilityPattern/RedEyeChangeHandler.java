package com.ChainOfResponsibilityPattern;
import java.util.ArrayList;


public class RedEyeChangeHandler extends ChangeHandler {

    public RedEyeChangeHandler(int hid)
    {
    	super(hid);
    }
    
    @Override
    public String ChangeRequest(ArrayList<Integer> mode, String picture){
        if (IncludeMode(mode))
        {
            picture = picture.replace("»¡°£´«", "Á¤»ó´«");
        }
        if (Successor != null)
        {
            picture = Successor.ChangeRequest(mode, picture);
        }
        return picture;
    }
}
