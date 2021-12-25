/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author pminh
 */
@Entity
@Table(name = "`trip`")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t"),
    @NamedQuery(name = "Trip.findById", query = "SELECT t FROM Trip t WHERE t.id = :id"),
    @NamedQuery(name = "Trip.findByName", query = "SELECT t FROM Trip t WHERE t.name = :name"),
    @NamedQuery(name = "Trip.findByTime", query = "SELECT t FROM Trip t WHERE t.time = :time"),
    @NamedQuery(name = "Trip.findByPrice", query = "SELECT t FROM Trip t WHERE t.price = :price")})
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "`id`")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "time")
    private String time;
    @Size(max = 45)
    @Column(name = "price")
    private Double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrip")
    private Collection<ActivateTrip> activateTripCollection;
    @JoinColumn(name = "idroute", referencedColumnName = "id")
    @ManyToOne
    private Route idroute;
    @OneToOne(mappedBy = "idtrip")
    private Passengercar passengerCar;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrip")
    @JsonIgnore
    private Collection<Comment> commentCollection;
    @OneToOne(mappedBy = "idtrip")
    private Passengercar passengercar;


    public Trip() {
    }

    public Trip(Integer id) {
        this.id = id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<ActivateTrip> getActivateTripCollection() {
        return activateTripCollection;
    }

    public void setActivateTripCollection(Collection<ActivateTrip> activateTripCollection) {
        this.activateTripCollection = activateTripCollection;
    }

    public Route getIdroute() {
        return idroute;
    }

    public void setIdroute(Route idroute) {
        this.idroute = idroute;
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
        if (!(object instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group11.pojos.Trip[ id=" + id + " ]";
    }

    /**
     * @return the passengerCar
     */
    public Passengercar getPassengerCar() {
        return passengerCar;
    }

    /**
     * @param passengerCar the passengerCar to set
     */
    public void setPassengerCar(Passengercar passengerCar) {
        this.passengerCar = passengerCar;
    }

    
}
