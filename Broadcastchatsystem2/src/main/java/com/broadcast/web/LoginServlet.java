package com.broadcast.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.broadcast.bean.ChatroomBean;
import com.broadcast.bean.LoginBean;
import com.broadcast.database.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		LoginBean loginbean = new LoginBean();
		ChatroomBean chatroombean=new ChatroomBean();
		loginbean.setName(name);
		loginbean.setPassword(password);
		LoginDao logindao=new LoginDao();
		String username=logindao.validate(loginbean);
		if(username!="") {
//			chatroombean.setSender(username);
			System.out.println(username);
			HttpSession session=request.getSession();
			List<ChatroomBean> list= logindao.showallmessages();
			session.setAttribute("username", username);
			session.setAttribute("messageslist", list);
			
			response.sendRedirect("chatroom.jsp");
		}
		else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
