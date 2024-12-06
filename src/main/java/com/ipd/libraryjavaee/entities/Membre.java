package com.ipd.libraryjavaee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "membres")
public class Membre extends AppUser implements Serializable {

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "membership_date")
    private Date membershipDate;

    @Column(name = "suspended", nullable = false)
    private boolean suspended;

    @Column(name = "fine_balance", nullable = false)
    private double fineBalance;

    @OneToMany(mappedBy = "membre", fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy = "membre", fetch = FetchType.LAZY)
    private Set<Commentaire> commentaires = new HashSet<>();

    // Default Constructor
    public Membre() {
        super();
    }

    // Parameterized Constructor
    public Membre(String userName, String email, String password, String address, String phoneNumber,
                  Date membershipDate, boolean suspended, double fineBalance) {
        super(userName, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.membershipDate = membershipDate;
        this.suspended = suspended;
        this.fineBalance = fineBalance;
    }

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public double getFineBalance() {
        return fineBalance;
    }

    public void setFineBalance(double fineBalance) {
        this.fineBalance = fineBalance;
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

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membre membre = (Membre) o;
        return Objects.equals(getId(), membre.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
