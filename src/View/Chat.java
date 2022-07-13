package View;

import java.util.Scanner;

import Controller.GlobalController;
import Model.Broad;

public class Chat {
public static void main(String args[]) {
	GlobalController globalcontroller=new GlobalController();
	Broad broad=new Broad();
	String username;
	String message;
	Scanner ak = new Scanner(System.in);
	try {
	username=ak.next();
	broad.setSender(username);
	System.out.println("Welcome to chat");
	int i=1;
	while(i!=0) {
		i=ak.nextInt();
		ak.nextLine();
		message=ak.nextLine();
		broad.setMessage(message);
		//System.out.print(broad.getSender()+broad.getMessage());
		globalcontroller.SendMessage(broad);
	}
	}finally {
		ak.close();
	}
	
}
}
