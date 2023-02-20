
import entities.Pharmacie;
import entities.Pharmacien;
import entities.User;
import entities.Ville;
import entities.Zone;
import service.PharmacieService;
import service.PharmacienService;
import service.UserService;
import service.VilleService;
import service.ZoneService;
import util.HibernateUtil;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hicham
 */
public class Test {
    public static void main(String args[]){
        HibernateUtil.getSessionFactory().openSession();
        //ZoneService zs = new ZoneService();
        //VilleService vs = new VilleService();
        UserService us = new UserService();
        User u = us.getByEmail("ali22@gmail.com");
        System.out.println(u.toString());
        //vs.create(new Ville("agadir"));
        //zs.create(new Zone("zone1",vs.findById(1)));
        PharmacieService ps = new PharmacieService();
        PharmacienService phs = new PharmacienService();
        ZoneService zs = new ZoneService();

    }
    
}
