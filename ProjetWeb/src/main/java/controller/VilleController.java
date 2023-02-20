package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.VilleService;

import java.io.IOException;

import entities.Ville;

/**
 * Servlet implementation class VilleController
 */
public class VilleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VilleService vs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VilleController() {
		super();
		// TODO Auto-generated constructor stub
		vs = new VilleService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(request.getParameter("op").equalsIgnoreCase("delete"));
		if (request.getParameter("id") == null && request.getParameter("op") == null) {
			String nom = request.getParameter("nom");
			vs.create(new Ville(nom));
			response.sendRedirect("villes.jsp");
		} else if (request.getParameter("id") != null && request.getParameter("op").equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			vs.delete(vs.findById(id));
			response.sendRedirect("villes.jsp");
		} else if (request.getParameter("id") != null && request.getParameter("op").equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			vs.update(new Ville(id, nom));
			response.sendRedirect("villes.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
