package com.ipd.libraryjavaee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commentaires")
public class Commentaire implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;
    private Date date;
    private Integer rating;
    
    private boolean approved;

    @ManyToOne
    @JoinColumn(name = "membre_id")
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;

	public Commentaire() {
		super();
	}

	public Commentaire(Long id, String content, Date date, Integer rating, boolean isApproved, Membre membre,
			Reservation reservation, Salle salle, Ouvrage ouvrage) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.rating = rating;
		this.approved = isApproved;
		this.membre = membre;
		this.reservation = reservation;
		this.salle = salle;
		this.ouvrage = ouvrage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean isApproved) {
		this.approved = isApproved;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	

}
