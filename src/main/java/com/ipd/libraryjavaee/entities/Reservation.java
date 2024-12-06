package com.ipd.libraryjavaee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reservations")
public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    private Date date;
	    private Integer duration;
	    private String status;
	    
	    private Date reservationStartDate;
	    private Date reservationEndDate;
	    private boolean active;
	    
	    @Temporal(TemporalType.DATE)
	    private Date startDate;

	    @Temporal(TemporalType.DATE)
	    private Date endDate;
	    
	    private boolean confirmed;

	    @ManyToOne
	    @JoinColumn(name = "membre_id")
	    private Membre membre;

	    @ManyToMany
	    @JoinTable(
	      name = "reservation_salle", 
	      joinColumns = @JoinColumn(name = "reservation_id"), 
	      inverseJoinColumns = @JoinColumn(name = "salle_id"))
	    private Set<Salle> salles;

	    @ManyToMany
	    @JoinTable(
	      name = "reservation_ouvrage", 
	      joinColumns = @JoinColumn(name = "reservation_id"), 
	      inverseJoinColumns = @JoinColumn(name = "ouvrage_id"))
	    private Set<Ouvrage> ouvrages;

	    @OneToMany(mappedBy = "reservation")
	    private Set<Commentaire> commentaires;

		public Reservation() {
			super();
		}

		public Reservation(Long id, Date date, Integer duration, String status, Date reservationStartDate,
				Date reservationEndDate, boolean isActive, Membre membre, Set<Salle> salles, Set<Ouvrage> ouvrages,
				Set<Commentaire> commentaires) {
			super();
			this.id = id;
			this.date = date;
			this.duration = duration;
			this.status = status;
			this.reservationStartDate = reservationStartDate;
			this.reservationEndDate = reservationEndDate;
			this.active = isActive;
			this.membre = membre;
			this.salles = salles;
			this.ouvrages = ouvrages;
			this.commentaires = commentaires;
		}

		
		public Reservation(long id, Date date, Integer duration, String status, Date reservationStartDate,
				Date reservationEndDate, boolean isActive, Date startDate, Date endDate, Membre membre,
				Set<Salle> salles, Set<Ouvrage> ouvrages, Set<Commentaire> commentaires) {
			super();
			this.id = id;
			this.date = date;
			this.duration = duration;
			this.status = status;
			this.reservationStartDate = reservationStartDate;
			this.reservationEndDate = reservationEndDate;
			this.active = isActive;
			this.startDate = startDate;
			this.endDate = endDate;
			this.membre = membre;
			this.salles = salles;
			this.ouvrages = ouvrages;
			this.commentaires = commentaires;
		}

		
		public Reservation(long id, Date date, Integer duration, String status, Date reservationStartDate,
				Date reservationEndDate, boolean isActive, Date startDate, Date endDate, boolean isConfirmed,
				Membre membre, Set<Salle> salles, Set<Ouvrage> ouvrages, Set<Commentaire> commentaires) {
			super();
			this.id = id;
			this.date = date;
			this.duration = duration;
			this.status = status;
			this.reservationStartDate = reservationStartDate;
			this.reservationEndDate = reservationEndDate;
			this.active = isActive;
			this.startDate = startDate;
			this.endDate = endDate;
			this.confirmed = isConfirmed;
			this.membre = membre;
			this.salles = salles;
			this.ouvrages = ouvrages;
			this.commentaires = commentaires;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Integer getDuration() {
			return duration;
		}

		public void setDuration(Integer duration) {
			this.duration = duration;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getReservationStartDate() {
			return reservationStartDate;
		}

		public void setReservationStartDate(Date reservationStartDate) {
			this.reservationStartDate = reservationStartDate;
		}

		public Date getReservationEndDate() {
			return reservationEndDate;
		}

		public void setReservationEndDate(Date reservationEndDate) {
			this.reservationEndDate = reservationEndDate;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean isActive) {
			this.active = isActive;
		}

		public Membre getMembre() {
			return membre;
		}

		public void setMembre(Membre membre) {
			this.membre = membre;
		}

		public Set<Salle> getSalles() {
			return salles;
		}

		public void setSalles(Set<Salle> salles) {
			this.salles = salles;
		}

		public Set<Ouvrage> getOuvrages() {
			return ouvrages;
		}

		public void setOuvrages(Set<Ouvrage> ouvrages) {
			this.ouvrages = ouvrages;
		}

		public Set<Commentaire> getCommentaires() {
			return commentaires;
		}

		public void setCommentaires(Set<Commentaire> commentaires) {
			this.commentaires = commentaires;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public void setId(long id) {
			this.id = id;
		}

		public boolean isConfirmed() {
			return confirmed;
		}

		public void setConfirmed(boolean isConfirmed) {
			this.confirmed = isConfirmed;
		}

		
		
}
