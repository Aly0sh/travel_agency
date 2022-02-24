package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "air_tickets_trips")
public class air_tickets_trips {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @JoinColumn(name = "place")
    @ManyToOne
    private air_tickets place;

    @Column(name = "flight_code")
    private Integer flight_code;

    @Column(name = "air_company")
    private String air_company;

    @Column(name = "passport_id")
    private Integer passport_id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "tour_number")
    private Integer tour_number;

    @Column(name = "registration_date")
    private Date registration_date;

    @NotNull
    @JoinColumn(name = "trip_number")
    @ManyToOne
    private trip trip_number;

    public air_tickets_trips(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public air_tickets getPlace() {
        return place;
    }

    public void setPlace(air_tickets place) {
        this.place = place;
    }

    public Integer getFlight_code() {
        return flight_code;
    }

    public void setFlight_code(Integer flight_code) {
        this.flight_code = flight_code;
    }

    public String getAir_company() {
        return air_company;
    }

    public void setAir_company(String air_company) {
        this.air_company = air_company;
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

    public trip getTrip_number() {
        return trip_number;
    }

    public void setTrip_number(trip trip_number) {
        this.trip_number = trip_number;
    }
}
