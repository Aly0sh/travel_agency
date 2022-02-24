package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "event_tickets")
public class event_tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "place")
    private Integer place;

    @NotNull
    @JoinColumn(name = "city")
    @ManyToOne
    private events city;

    @Column(name = "start_date")
    private Date start_date;

    @NotNull
    @JoinColumn(name = "venue")
    @ManyToOne
    private events venue;

    @NotNull
    @JoinColumn(name = "start_time")
    @ManyToOne
    private events start_time;

    public event_tickets(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public events getCity() {
        return city;
    }

    public void setCity(events city) {
        this.city = city;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public events getVenue() {
        return venue;
    }

    public void setVenue(events venue) {
        this.venue = venue;
    }

    public events getStart_time() {
        return start_time;
    }

    public void setStart_time(events start_time) {
        this.start_time = start_time;
    }
}
