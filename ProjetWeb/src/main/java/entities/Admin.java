/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author hicham
 */
@Entity
public class Admin extends User{

    private String telephone;

    public Admin() {
    }

	public Admin(int id, String login, String password, String nom, String prenom, String telephone) {
		super(id, login, password, nom, prenom);
		this.telephone = telephone;
	}

	public Admin(String login, String password, String nom, String prenom, String telephone) {
		super(login, password, nom, prenom);
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

    
    
}
