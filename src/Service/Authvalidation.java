package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Model.Authentication;
public class Authvalidation {
	public String authentication(String name,String password) {
		String nickname="";
		ArrayList<Authentication> auth =new ArrayList<>();
		Connection connection= Globalconnect.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("Select * from auth where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet result=ps.executeQuery();
			if(result.next()) {
				nickname= result.getString("nickname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nickname;
	}
	public void insertuser(String name,String password,String nickname,String mobilenumber) {
		try {
			Connection con=Globalconnect.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into auth(name,password,nickname,mobilenumber) values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, nickname);
			ps.setString(4, mobilenumber);
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String deleteAccount(String name,String password) {
		String ans="";
		try {
			Connection con=Globalconnect.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from auth where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.executeUpdate();
			ans="deleted";
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
		
	}
}