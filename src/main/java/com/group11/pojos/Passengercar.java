/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pminh
 */
@Entity
@Table(name = "`passengercar`")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passengercar.findAll", query = "SELECT p FROM Passengercar p"),
    @NamedQuery(name = "Passengercar.findById", query = "SELECT p FROM Passengercar p WHERE p.id = :id"),
    @NamedQuery(name = "Passengercar.findByName", query = "SELECT p FROM Passengercar p WHERE p.name = :name"),
    @NamedQuery(name = "Passengercar.findByCarnumber", query = "SELECT p FROM Passengercar p WHERE p.carnumber = :carnumber"),
    @NamedQuery(name = "Passengercar.findByActive", query = "SELECT p FROM Passengercar p WHERE p.active = :active")})
public class Passengercar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "`id`")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "`carnumber`")
    private String carnumber;
    @Column(name = "`active`")
    private Short active;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "passengercar")
    private Collection<Seat> seatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passengercar")
    private Collection<Ticket> ticketCollection;
    @JoinColumn(name = "idtrip", referencedColumnName = "id")
    @OneToOne
    private Trip idtrip;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne
    private User user;
    
    public Passengercar() {
    }

    public Passengercar(Integer id) {
        this.id = id;
    }

    public Passengercar(Integer id, String carnumber) {
        this.id = id;
        this.carnumber = carnumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Seat> getSeatCollection() {
        return seatCollection;
    }

    public void setSeatCollection(Collection<Seat> seatCollection) {
        this.seatCollection = seatCollection;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }


    public Trip getIdtrip() {
        return idtrip;
    }

    public void setIdtrip(Trip idtrip) {
        this.idtrip = idtrip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passengercar)) {
            return false;
        }
        Passengercar other = (Passengercar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group11.pojos.Passengercar[ id=" + id + " ]";
    }

}
