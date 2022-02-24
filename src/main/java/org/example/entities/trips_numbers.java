package org.example.entities;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "trips_numbers")
public class trips_numbers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String name;

    @Column(name = "arrival_date")
    private Date arrival_date;

    @Column(name = "passport_id")
    private Integer passport_id;

    @Column(name = "category")
    private String category;

    @Column(name = "address")
    private String address;

    @Column(name = "client_name")
    private String client_name;

    @Column(name = "tour_number")
    private Integer tour_number;

    @Column(name = "registration_date")
    private java.sql.Date registration_date;

    @NotNull
    @JoinColumn(name = "trip_number")
    @ManyToOne
    private trip trip_number;

    @NotNull
    @ManyToOne
    private rooms room;

    public trips_numbers(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(Integer passport_id) {
        this.passport_id = passport_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public Integer getTour_number() {
        return tour_number;
    }

    public void setTour_number(Integer tour_number) {
        this.tour_number = tour_number;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public trip getTrip_number() {
        return trip_number;
    }

    public void setTrip_number(trip trip_number) {
        this.trip_number = trip_number;
    }

    public rooms getRoom() {
        return room;
    }

    public void setRoom(rooms room) {
        this.room = room;
    }
}
