package org.example.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String city;

    @Column
    private String name;

    @Column(name = "arrival_date")
    private Date arrival_date;

    @Column
    private String category;

    @Column(name = "place")
    private Integer place;

    @Column(name = "departure_date")
    private Date departure_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Category room_category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel")
    private Hotel hotel;

    public Rooms(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getRoom_category() {
        return room_category;
    }

    public void setRoom_category(Category room_category) {
        this.room_category = room_category;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
