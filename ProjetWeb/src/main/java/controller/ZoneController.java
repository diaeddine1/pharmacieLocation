package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.VilleService;
import service.ZoneService;

import java.io.IOException;

import entities.Ville;
import entities.Zone;

/**
 * Servlet implementation class ZoneController
 */
public class ZoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ZoneService zs;
	private VilleService vs;
    public ZoneController() {
        super();
        // TODO Auto-generated constructor stub
        zs = new ZoneService();
        vs = new VilleService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("id") == null && request.getParameter("op") == null) {
			String nom = request.getParameter("nom");
			int ville = Integer.parseInt(request.getParameter("ville"));
			zs.create(new Zone(nom,vs.findById(ville)));
			response.sendRedirect("zones.jsp");
		} else if (request.getParameter("id") != null && request.getParameter("op").equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			zs.delete(zs.findById(id));
			response.sendRedirect("zones.jsp");
		} else if (request.getParameter("id") != null && request.getParameter("op").equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			int ville = Integer.parseInt(request.getParameter("ville"));
			zs.update(new Zone(id, nom,vs.findById(ville)));
			response.sendRedirect("zones.jsp");
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
