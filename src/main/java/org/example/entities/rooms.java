package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rooms")
public class rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @JoinColumn(name = "city")
    @ManyToOne
    private hotel city;

    @NotNull
    @JoinColumn(name = "name")
    @ManyToOne
    private hotel name;

    @Column(name = "arrival_date")
    private Date arrival_date;

    @NotNull
    @JoinColumn(name = "category")
    @ManyToOne
    private category category;

    @Column(name = "place")
    private Integer place;

    @Column(name = "departure_date")
    private Date departure_date;

    public rooms(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public hotel getCity() {
        return city;
    }

    public void setCity(hotel city) {
        this.city = city;
    }

    public hotel getName() {
        return name;
    }

    public void setName(hotel name) {
        this.name = name;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public org.example.entities.category getCategory() {
        return category;
    }

    public void setCategory(org.example.entities.category category) {
        this.category = category;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }
}
