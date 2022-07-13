package Model;

public class Broad {
private int id;
private String sender;
private String message;
public Broad(int int1, String string, String string2) {
	this.id=int1;
	this.sender=string;
	this.message=string2;
}
public Broad() {
	this.id=0;
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}
