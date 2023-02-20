package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GradeService;

import java.io.IOException;

import entities.Garde;
import entities.Ville;

/**
 * Servlet implementation class GardeController
 */
public class GardeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private GradeService gs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GardeController() {
       gs = new GradeService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("id") == null && request.getParameter("op") == null) {
			String type = request.getParameter("type");
			gs.create(new Garde(type));
			response.sendRedirect("gardes.jsp");
		} else if (request.getParameter("id") != null && request.getParameter("op").equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			gs.delete(gs.findById(id));
			response.sendRedirect("gardes.jsp");
		} else if (request.getParameter("id") != null && request.getParameter("op").equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String type = request.getParameter("type");
			gs.update(new Garde(id, type));
			response.sendRedirect("gardes.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
