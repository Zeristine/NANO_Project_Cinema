/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "ShowTime")
public class ShowTime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filmId")
    private Film film;

    @Temporal(TemporalType.DATE)
    @Column(name = "showDate")
    private Date showDate;

    @Column(name = "ticketprice")
    private double ticketPrice;

    @OneToMany(mappedBy = "showTime", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrderFilm> orders;

    public ShowTime() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Set<OrderFilm> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderFilm> orders) {
        this.orders = orders;
    }

    public int getTotalBookedTicket() {
        int count = 0;
        for (OrderFilm order : orders) {
            count += order.getTickets().size();
        }
        return count;
    }

    public List<String> getBookedSeats(){
        List<String> list = new ArrayList<>();
        for (OrderFilm order : orders) {
            for (Ticket ticket : order.getTickets()) {
                list.add(ticket.getPosition());
            }
        }
        return list;
    }
}
