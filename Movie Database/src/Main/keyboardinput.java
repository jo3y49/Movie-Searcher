package Main;

import java.util.Scanner;

public class keyboardinput {
	private Scanner in;
	
	public keyboardinput(){
		in=new Scanner(System.in);
	}
		
	public String getKbLine(){
		return in.nextLine();
	}
	public int getKbInt(){
		return in.nextInt();
	}
	public void closeKeyboard(){
		in.close();
	}
}
