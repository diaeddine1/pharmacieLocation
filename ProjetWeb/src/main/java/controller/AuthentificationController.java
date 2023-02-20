package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import util.Util;

import java.io.IOException;

import entities.User;

/**
 * Servlet implementation class AuthentificationController
 */
public class AuthentificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UserService us;
    public AuthentificationController() {
       us = new UserService();
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
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		log(email);
		String pass = request.getParameter("password");
		User u = us.getByEmail(email);
		if(u != null && u.getPassword().equals(Util.md5(pass))) {
			 HttpSession session = request.getSession();
             session.setAttribute("user", u);
             response.sendRedirect("dashbord.jsp");
		}else {
			 response.sendRedirect("Auth.jsp?msg=mot de passe incorrect");
		}
		
	}

}
