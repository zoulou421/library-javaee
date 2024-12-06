package com.ipd.libraryjavaee.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="salles")
public class Salle implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Integer capacity;
    private String location;
    
    private boolean available;

    @ManyToMany(mappedBy = "salles")
    private Set<Reservation> reservations;

    @OneToMany(mappedBy = "salle")
    private Set<Commentaire> commentaires;

	public Salle() {
		super();
	}

	public Salle(Long id, String name, Integer capacity, String location, boolean isAvailable,
			Set<Reservation> reservations, Set<Commentaire> commentaires) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.location = location;
		this.available = isAvailable;
		this.reservations = reservations;
		this.commentaires = commentaires;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean isAvailable) {
		this.available = isAvailable;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	

	
}
