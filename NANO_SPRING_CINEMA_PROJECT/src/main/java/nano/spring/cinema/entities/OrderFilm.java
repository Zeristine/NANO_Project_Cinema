/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "OrderFilm")
public class OrderFilm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "orderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "showtimeId")
    private ShowTime showTime;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @OneToMany(mappedBy = "order")
    private Set<Ticket> tickets;

    public OrderFilm() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

}
