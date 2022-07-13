package Controller;

import Model.Broad;
import Service.Globaloperation;

public class GlobalController {
public void SendMessage(Broad broad) {
	Globaloperation globaloperation=new Globaloperation();
	System.out.print(broad.getSender()+broad.getMessage());
	globaloperation.SendMessage(broad);
}
}
