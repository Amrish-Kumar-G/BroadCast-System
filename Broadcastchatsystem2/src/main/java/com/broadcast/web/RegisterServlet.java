package com.broadcast.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.broadcast.bean.RegisterBean;
import com.broadcast.database.LoginDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String confirmpassword=request.getParameter("confirmpassword");
		String nickname=request.getParameter("nickname");
		String mobilenumber=request.getParameter("mobilenumber");
		
		RegisterBean registerbean = new RegisterBean();
		registerbean.setName(name);
		registerbean.setPassword(password);
		registerbean.setConfirmpassword(confirmpassword);
		registerbean.setNickname(nickname);
		registerbean.setMobilenumber(mobilenumber);
		LoginDao logindao=new LoginDao();
		if(logindao.register(registerbean)==1)
		{
			response.sendRedirect("Success.jsp");
		}
		else {
			response.sendRedirect("Signup.jsp");
		}
	}

}
