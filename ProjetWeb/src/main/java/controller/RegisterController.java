package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PharmacienService;
import service.UserService;
import util.Util;

import java.io.IOException;

import entities.Pharmacien;

/**
 * Servlet implementation class RegisterController
 */
   
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserService ps;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
        ps = new UserService();
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
		ps.create(new Pharmacien(request.getParameter("email"),Util.md5(request.getParameter("password")),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("email"),request.getParameter("telephone")));
		response.sendRedirect("Auth.jsp");
	}

}
