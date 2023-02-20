package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PharmacieDeGardeService;
import service.PharmacieService;

import java.io.IOException;
import java.util.Date;

import entities.PharmacieDeGarde;
import entities.PharmacieGardePK;

/**
 * Servlet implementation class PharmacieDeGardeController
 */
public class PharmacieDeGardeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PharmacieDeGardeService pds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacieDeGardeController() {
        super();
        pds = new PharmacieDeGardeService();
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		int id = Integer.parseInt(request.getParameter("pharmacie"));
		int idgarde=Integer.parseInt(request.getParameter("garde"));
		Date datedebut = new Date(request.getParameter("datedebut"));
		Date datefin = new Date(request.getParameter("datefin"));
		
		//PharmacieGardePK phk = new PharmacieGardePK(id,idgarde,datedebut);
		
		//pds.create(new PharmacieDeGarde(phk,datefin));
	
	}

}
