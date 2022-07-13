package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Model.Broad;

public class Globaloperation {
	public void SendMessage(Broad broad) {
		try {
			Connection con=Globalconnect.getConnection();	
			PreparedStatement ps=con.prepareStatement("insert into global (sender,message) values(?,?)");
			ps.setString(1,broad.getSender());
			ps.setString(2, broad.getMessage());
			ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	public List<Broad> ReadMessage(){
		ArrayList<Broad> list=new ArrayList<>();
		try {
		Connection con=Globalconnect.getConnection();
		Statement statement=con.createStatement();
		ResultSet result=statement.executeQuery("Select * from global");
		while(result.next()) {
			list.add(new Broad(result.getInt(1),result.getString(2),result.getString(3)));
		}
		statement.close();
		con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public int Maxid() {
		int ans=0;
		try {
			Connection con=Globalconnect.getConnection();
			Statement statement=con.createStatement();
			PreparedStatement ps=con.prepareStatement("insert into global (sender,message) values(?,?)");
			ResultSet result=statement.executeQuery("select max(id) as maxid from global");
			while(result.next()) {
				ans=result.getInt("maxid");	
			}
			statement.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
	public List<Broad>ConsoleResult(int id,int max){
		ArrayList<Broad> list=new ArrayList<>();
		try {
		Connection con=Globalconnect.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from global where id>? and id<=?");
		ps.setInt(1,id);
		ps.setInt(2, max);
		ResultSet result=ps.executeQuery();
		while(result.next()) {
			list.add(new Broad(result.getInt(1),result.getString(2),result.getString(3)));
		}
		con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
