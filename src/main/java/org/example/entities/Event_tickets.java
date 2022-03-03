package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "event_tickets")
public class Event_tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "place")
    private Integer place;

    @Column
    private String city;

    @Column(name = "start_date")
    private Date start_date;

    @Column
    private String venue;

    @Column
    private Date start_time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event")
    private Events event;


    public Event_tickets(){}

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
}
