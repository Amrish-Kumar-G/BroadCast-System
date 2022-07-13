package View;

import java.util.Scanner;

import Controller.GlobalController;
import Model.Authentication;
import Model.Broad;
import Service.Authvalidation;

public class Chat {
public static void main(String args[]) {
	GlobalController globalcontroller=new GlobalController();
	Authvalidation valid=new Authvalidation();
	Broad broad=new Broad();
	Authentication auth=new Authentication();
	String username;
	String message;
	String name;
	String password;
	String nickname;
	String mobilenumber;
	Scanner ak = new Scanner(System.in);
	try {
	while(true) {
	System.out.println("1.Registration");
	System.out.println("2.Login");
	System.out.println("0.Exit");
	int choice=ak.nextInt();
	switch(choice) {
	case 1:
		System.out.println("enter name");
		name=ak.next();
		System.out.println("enter password");
		password=ak.next();
		System.out.println("enter nickname");
		nickname=ak.next();
		System.out.println("enter mobilenumber");
		mobilenumber=ak.next();
		auth.setName(name);
		auth.setPassword(password);
		auth.setNickname(nickname);
		auth.setMobilenumber(mobilenumber);
		valid.insertuser(name, password,nickname,mobilenumber);
		System.out.println("User added !!!");
		break;
	case 2:
	System.out.println("enter name");
	name=ak.next();
	System.out.println("enter password");
	password=ak.next();
	auth.setName(name);
	auth.setPassword(password);
	username=valid.authentication(name, password);
	if(username!="") {
	System.out.println("Login Successfull!!!");
	broad.setSender(username);
	System.out.println("Welcome to chat "+username);
	System.out.println("Press q to Quit Global Chat");
	while(true) {
		message=ak.nextLine();
		if(message.equals("q")){
			System.out.println("Global Chat exited");
			break;
		}
		if(!message.isEmpty()) {
			broad.setMessage(message);
			globalcontroller.SendMessage(broad);
		}
		//System.out.print(broad.getSender()+broad.getMessage());
	}
	}
	else {
		System.out.println("Login failed!!!");
	}
	break;
	case 0: System.exit(0);
	}
	}
	}finally {
		ak.close();
	}
	
}
}