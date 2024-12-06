package com.ipd.libraryjavaee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ouvrages")
public class Ouvrage implements Serializable{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    private String title;
	    private String author;
	    private Date publicationDate;
	    private String genre;
	    
	    private String isbn;
	    private int copiesAvailable;
	    private String publisher;
	    private String language;

	    @ManyToMany(mappedBy = "ouvrages")
	    private Set<Reservation> reservations;

	    @OneToMany(mappedBy = "ouvrage")
	    private Set<Commentaire> commentaires;

		public Ouvrage() {
			super();
		}

		public Ouvrage(Long id, String title, String author, Date publicationDate, String genre, String isbn,
				int copiesAvailable, String publisher, String language, Set<Reservation> reservations,
				Set<Commentaire> commentaires) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.publicationDate = publicationDate;
			this.genre = genre;
			this.isbn = isbn;
			this.copiesAvailable = copiesAvailable;
			this.publisher = publisher;
			this.language = language;
			this.reservations = reservations;
			this.commentaires = commentaires;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Date getPublicationDate() {
			return publicationDate;
		}

		public void setPublicationDate(Date publicationDate) {
			this.publicationDate = publicationDate;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public int getCopiesAvailable() {
			return copiesAvailable;
		}

		public void setCopiesAvailable(int copiesAvailable) {
			this.copiesAvailable = copiesAvailable;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
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
