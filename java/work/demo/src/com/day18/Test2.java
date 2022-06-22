package com.day18;

import java.io.IOException;
import java.io.OutputStream;

//out
//



public class Test2 {
	public static void main(String[] args) throws IOException {
		OutputStream os = System.out;
		
		byte[] b = new byte[3];
		
		b[0] = 65;
		b[1] = 97;
		b[2] = 122;
		
		os.write(b);
		os.close();
		
		
		System.out.println("나 보이냐");
		
	}
}
