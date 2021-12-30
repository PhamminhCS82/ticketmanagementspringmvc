/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pminh
 */
@Entity
@Table(name = "order_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderTicket.findAll", query = "SELECT o FROM OrderTicket o"),
    @NamedQuery(name = "OrderTicket.findById", query = "SELECT o FROM OrderTicket o WHERE o.id = :id"),
    @NamedQuery(name = "OrderTicket.findByCreatedDate", query = "SELECT o FROM OrderTicket o WHERE o.createdDate = :createdDate"),
    @NamedQuery(name = "OrderTicket.findByIsPaid", query = "SELECT o FROM OrderTicket o WHERE o.isPaid = :isPaid")})
public class OrderTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_paid")
    private boolean isPaid;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(mappedBy = "idorder")
    private Collection<Ticket> ticketCollection;
    @Size(max = 45)
    @Column(name = "online_pay")
    private String onlinePay;
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public OrderTicket() {
    }

    public OrderTicket(Integer id) {
        this.id = id;
    }

    public OrderTicket(Integer id, boolean isPaid) {
        this.id = id;
        this.isPaid = isPaid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
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
        if (!(object instanceof OrderTicket)) {
            return false;
        }
        OrderTicket other = (OrderTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group11.pojos.OrderTicket[ id=" + id + " ]";
    }

    /**
     * @return the onlinePay
     */
    public String getOnlinePay() {
        return onlinePay;
    }

    /**
     * @param onlinePay the onlinePay to set
     */
    public void setOnlinePay(String onlinePay) {
        this.onlinePay = onlinePay;
    }

    /**
     * @return the totalPrice
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}
