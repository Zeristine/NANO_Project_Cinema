/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "Account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "firstname", length = 50)
    private String firstname;

    @Column(name = "lastname", length = 50)
    private String lastname;

    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "avatar")
    private String avatar;
    
    @OneToMany(mappedBy = "account")
    private Set<OrderFilm> orders;

    @OneToMany(mappedBy = "account")
    private Set<Point> points;

    public Account() {
        this.orders = new HashSet<>();
        this.points = new HashSet<>();
    }

    public Account(String username, String password, String firstname, String lastname, Date birthdate, String phone, String avatar) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.avatar = avatar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<OrderFilm> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderFilm> orders) {
        this.orders = orders;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

}
