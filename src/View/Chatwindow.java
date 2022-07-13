package View;

import Service.Globaloperation;

import java.util.ArrayList;
import java.util.List;

import Model.Broad;

class Readmessage extends Thread{
	public Globaloperation globaloperation;
	public int id=0;
	public Readmessage(Globaloperation globaloperation){
		this.globaloperation=globaloperation;
	}
	@Override
	public void run() {
		int id=1;
		while(true) {
		int max=globaloperation.Maxid();
		if(max>id) {
			List<Broad> list=new ArrayList<>();
			list=globaloperation.ConsoleResult(id, max);
			for(Broad broad:list) {
				System.out.println(broad.getSender()+":- "+broad.getMessage());
			}
			id=max;
		}
		}
		
	}
}
public class Chatwindow{
	public static void main(String args[]) {
		Globaloperation globaloperation=new Globaloperation();
		Readmessage readmessage=new Readmessage(globaloperation);
		readmessage.start();
	}
}