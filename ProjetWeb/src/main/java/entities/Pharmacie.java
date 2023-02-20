/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author hicham
 */
@Entity
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String address;
    private double longitude;
    private double latitude;
    @ManyToOne
    private Pharmacien pharmacien;
    @ManyToOne
    private Zone zone;
    private String url;

    public Pharmacie() {
    }

    public Pharmacie(String nom, String address, double longitude, double latitude, Pharmacien pharmacien, Zone zone) {
		super();
		this.nom = nom;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.pharmacien = pharmacien;
		this.zone = zone;
	}

	public Pharmacie(int id, String nom, String address, double longitude, double latitude, Pharmacien pharmacien,
			Zone zone) {
		super();
		this.id = id;
		this.nom = nom;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.pharmacien = pharmacien;
		this.zone = zone;
	}

	public Pharmacie(String nom, String address, double longitude, double latitude) {
        this.nom = nom;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Pharmacien getPharmacien() {
		return pharmacien;
	}

	public void setPharmacien(Pharmacien pharmacien) {
		this.pharmacien = pharmacien;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
            
}
