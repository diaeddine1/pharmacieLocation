/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author hicham
 */
@Entity
public class Pharmacien extends User{
    private String email;
    private String telephone;
    @OneToMany (mappedBy = "pharmacien",  fetch = FetchType.EAGER)
    private List<Pharmacie> pharmcies;

    public Pharmacien() {
    }

	

	public Pharmacien(int id, String login, String password, String nom, String prenom, String email, String telephone) {
		super(id, login, password, nom, prenom);
		this.email = email;
		this.telephone = telephone;
	}

	public Pharmacien(String login, String password, String nom, String prenom, String email, String telephone) {
		super(login, password, nom, prenom);
		this.email = email;
		this.telephone = telephone;
	}

	

	

   
    
    
    
}
