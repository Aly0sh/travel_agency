package org.example.entities;

import javax.persistence.*;
import java.sql.Date;



@Entity
@Table(name = "air_tickets_trips")
public class Air_tickets_trips {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private Integer place;

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

    @Column
    private Integer trip_number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Air_tickets air_tickets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Trip trip;

    public Air_tickets_trips(){};

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

    public Integer getTrip_number() {
        return trip_number;
    }

    public void setTrip_number(Integer trip_number) {
        this.trip_number = trip_number;
    }
}
