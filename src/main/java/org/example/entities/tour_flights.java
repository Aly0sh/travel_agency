package org.example.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tour_flights")
public class tour_flights {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_code")
    private Long flight_code;

    @Column(name = "air_company")
    private String air_company;

    @JoinColumn(name = "tour_number")
    @ManyToOne(cascade = CascadeType.ALL)
    private tour tour_number;

    @Column(name = "departure_date")
    private Date departure_date;

    @Column(name = "departure_time")
    private Date departure_time;

    @Column(name = "arrival_city")
    private String arrival_city;

    @Column(name = "departure_city")
    private String departure_city;

    @Column(name = "directions")
    private String directions;

    @Column(name = "country")
    private String country;

    @Column(name = "tour_type")
    private String tour_type;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "program_number")
    private Integer program_number;

    public tour_flights(){}

    public Long getFlight_code() {
        return flight_code;
    }

    public void setFlight_code(Long flight_code) {
        this.flight_code = flight_code;
    }

    public String getAir_company() {
        return air_company;
    }

    public void setAir_company(String air_company) {
        this.air_company = air_company;
    }

    public tour getTour_number() {
        return tour_number;
    }

    public void setTour_number(tour tour_number) {
        this.tour_number = tour_number;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTour_type() {
        return tour_type;
    }

    public void setTour_type(String tour_type) {
        this.tour_type = tour_type;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Integer getProgram_number() {
        return program_number;
    }

    public void setProgram_number(Integer program_number) {
        this.program_number = program_number;
    }
}
