package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "trip")
public class trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long trip_number;

    @NotNull
    @JoinColumn(name = "passport_id")
    @ManyToOne
    private tourist passport_id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "tour_number")
    private Integer tour_number;

    @Column(name = "registration_date")
    private java.sql.Date registration_date;

    public trip(){}

    public Long getTrip_number() {
        return trip_number;
    }

    public void setTrip_number(Long trip_number) {
        this.trip_number = trip_number;
    }

    public tourist getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(tourist passport_id) {
        this.passport_id = passport_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
