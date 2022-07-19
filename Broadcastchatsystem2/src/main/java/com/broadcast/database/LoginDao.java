package com.broadcast.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.broadcast.bean.ChatroomBean;
import com.broadcast.bean.LoginBean;
import com.broadcast.bean.RegisterBean;

public class LoginDao { 
	public void loaddriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error driver");
//			e.printStackTrace();
		}
	}
	public Connection getconnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/broad", "root","root");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
	public String validate(LoginBean loginbean) {
		String username="";
//		loaddriver();
		Connection con= getconnection();
		boolean status=false;
		try {
		PreparedStatement ps=con.prepareStatement("select * from auth where name=? and password=?");
		ps.setString(1, loginbean.getName());
		ps.setString(2, loginbean.getPassword());
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
		username=rs.getString("nickname");}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println(username);
		return username;
	}
	public int register(RegisterBean registerbean) {
		int result=0;
		Connection con=getconnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into auth (name,password,confirmpassword,nickname,mobilenumber) values(?,?,?,?,?)");
			ps.setString(1, registerbean.getName());
			ps.setString(2, registerbean.getPassword());
			ps.setString(3, registerbean.getConfirmpassword());
			ps.setString(4, registerbean.getNickname());
			ps.setString(5, registerbean.getMobilenumber());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}
	public int insertmessage(ChatroomBean chatroombean) {
		int result=0;
		Connection con=getconnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into global (sender,message) values(?,?)");
			ps.setString(1, chatroombean.getSender());
			ps.setString(2, chatroombean.getMessage());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<ChatroomBean> showallmessages() {
		ResultSet rs=null;
		List<ChatroomBean> ar=new ArrayList<ChatroomBean>();
		Connection con=getconnection();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from global");
			rs=stmt.executeQuery();
//			System.out.println(rs);
			while(rs.next()) {
				ChatroomBean cbean=new ChatroomBean();
				cbean.setSender(rs.getString("sender"));
				cbean.setMessage(rs.getString("message"));
				ar.add(cbean);
			}
//			System.out.println(ar);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
}
