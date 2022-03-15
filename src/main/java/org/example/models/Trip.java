package org.example.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private Integer trip_number;

    @Column
    private Integer passport_id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "tour_number")
    private Integer tour_number;

    @Column(name = "registration_date")
    private java.sql.Date registration_date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tourist")
    private Tourist tourist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agreement")
    private Agreement agreement_id;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Trips_tickets> trips_tickets;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Trips_numbers> trips_numbers;


    public Trip(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTrip_number() {
        return trip_number;
    }

    public void setTrip_number(Integer trip_number) {
        this.trip_number = trip_number;
    }

    public Integer getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(Integer passport_id) {
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

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public Agreement getAgreement_id() {
        return agreement_id;
    }

    public void setAgreement_id(Agreement agreement_id) {
        this.agreement_id = agreement_id;
    }

    public List<Trips_tickets> getTrips_tickets() {
        return trips_tickets;
    }

    public void setTrips_tickets(List<Trips_tickets> trips_tickets) {
        this.trips_tickets = trips_tickets;
    }

    public List<Trips_numbers> getTrips_numbers() {
        return trips_numbers;
    }

    public void setTrips_numbers(List<Trips_numbers> trips_numbers) {
        this.trips_numbers = trips_numbers;
    }

}
