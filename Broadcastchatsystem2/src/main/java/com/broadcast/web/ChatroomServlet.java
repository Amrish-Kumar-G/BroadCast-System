package com.broadcast.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.broadcast.bean.ChatroomBean;
import com.broadcast.database.LoginDao;

/**
 * Servlet implementation class ChatroomServlet
 */
@WebServlet("/chatroom")
public class ChatroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatroomServlet() {
        super();
        dao=new LoginDao();
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
		List ar=new ArrayList<>();
		ArrayList<String> ar1=new ArrayList<>();
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String message=request.getParameter("message");
		System.out.println(message);
		System.out.println(username);
		ChatroomBean chatroombean=new ChatroomBean();
		chatroombean.setSender(username);
		chatroombean.setMessage(message);
		LoginDao logindao=new LoginDao();
		int result=logindao.insertmessage(chatroombean);
		System.out.println(result);
		if(result==1) {
			List<ChatroomBean> list=logindao.showallmessages();
			session.setAttribute("messageslist", list);
			response.sendRedirect("chatroom.jsp");
//			ar=logindao.showallmessages();
//			for(ChatroomBean chat:ar) {
//				ar1.add(chat.getSender()+":"+chat.getMessage());
//			}
//			System.out.println(ar1);
//			System.out.println(ar);
//			request.setAttribute("messageslist",ar );
//			RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
//			rd.forward(request, response);
//			response.sendRedirect("chatroom.jsp");
		}
//		
	}
}
