/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pminh
 */
@Entity
@Table(name = "activate_trip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivateTrip.findAll", query = "SELECT a FROM ActivateTrip a"),
    @NamedQuery(name = "ActivateTrip.findById", query = "SELECT a FROM ActivateTrip a WHERE a.id = :id"),
    @NamedQuery(name = "ActivateTrip.findByActivateDate", query = "SELECT a FROM ActivateTrip a WHERE a.activateDate = :activateDate")})
public class ActivateTrip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activate_date")
    @Temporal(TemporalType.DATE)
    private Date activateDate;
    @JoinColumn(name = "idtrip", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Trip idtrip;

    public ActivateTrip() {
    }

    public ActivateTrip(Integer id) {
        this.id = id;
    }

    public ActivateTrip(Integer id, Date activateDate) {
        this.id = id;
        this.activateDate = activateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }

    public Trip getIdtrip() {
        return idtrip;
    }

    public void setIdtrip(Trip idtrip) {
        this.idtrip = idtrip;
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
        if (!(object instanceof ActivateTrip)) {
            return false;
        }
        ActivateTrip other = (ActivateTrip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group11.pojos.ActivateTrip[ id=" + id + " ]";
    }
    
}
