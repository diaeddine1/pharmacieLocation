/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hicham
 */
@Entity
public class Garde {

    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    public Garde() {
    }

    public int getId() {
        return id;
    }
    public Garde(String type) {
		super();
		this.type = type;
	}
    public Garde(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
