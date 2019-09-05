/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "TimeTable")
public class TimeTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "startWeekDay")
    private int startWeekDay;

    @Column(name = "endWeekDay")
    private int endWeekDay;

    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;

    @Column(name = "price")
    private double price;

    public TimeTable() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStartWeekDay() {
        return startWeekDay;
    }

    public void setStartWeekDay(int startWeekDay) {
        this.startWeekDay = startWeekDay;
    }

    public int getEndWeekDay() {
        return endWeekDay;
    }

    public void setEndWeekDay(int endWeekDay) {
        this.endWeekDay = endWeekDay;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
