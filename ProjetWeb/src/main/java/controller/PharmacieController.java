package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PharmacieService;
import service.PharmacienService;
import service.ZoneService;

import java.io.IOException;

import entities.Pharmacie;
import entities.Pharmacien;
import entities.Zone;

/**
 * Servlet implementation class PharmacieController
 */
public class PharmacieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	PharmacieService ps = new PharmacieService();
	ZoneService zs = new ZoneService();
	PharmacienService phs = new PharmacienService();
    public PharmacieController() {
        super();
        // TODO Auto-generated constructor stub
        ps = new PharmacieService();
        zs = new ZoneService();
        phs = new PharmacienService();
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
		if (request.getParameter("id") == null && request.getParameter("op") == null) {
			String nom = request.getParameter("nom");
			String address = request.getParameter("address");
			String longitude = request.getParameter("longitude");
			String latitude = request.getParameter("latitude");
			Pharmacien ph = phs.findById(Integer.parseInt(request.getParameter("idp")));
			Zone zo = zs.findById(Integer.parseInt(request.getParameter("idz")));
			ps.create(new Pharmacie(nom,address,Double.parseDouble(longitude),Double.parseDouble(latitude),ph,zo));
			response.sendRedirect("pharmacie.jsp");
		} else if (request.getParameter("id") != null && request.getParameter("op").equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			ps.delete(ps.findById(id));
			response.sendRedirect("pharmacie.jsp");
		} else if (request.getParameter("id") != null && request.getParameter("op").equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String address = request.getParameter("address");
			String longitude = request.getParameter("longitude");
			String latitude = request.getParameter("latitude");
			Pharmacien ph = phs.findById(Integer.parseInt(request.getParameter("idp")));
			Zone zo = zs.findById(Integer.parseInt(request.getParameter("idz")));
			ps.update(new Pharmacie(id,nom,address,Double.parseDouble(longitude),Double.parseDouble(latitude),ph,zo));
			response.sendRedirect("pharmacie.jsp");
		}
	}

}
