package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Air_tickets")
public class air_tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "place")
    private Integer place;

    @NotNull
    @JoinColumn(name = "flight_code")
    @ManyToOne
    private tour_flights flight_code;

    @Column(name = "air_company")
    private String air_company;

    @NotNull
    @JoinColumn(name = "klass")
    @ManyToOne
    private air_klass klass;

    public air_tickets(){}

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

    public tour_flights getFlight_code() {
        return flight_code;
    }

    public void setFlight_code(tour_flights flight_code) {
        this.flight_code = flight_code;
    }

    public String getAir_company() {
        return air_company;
    }

    public void setAir_company(String air_company) {
        this.air_company = air_company;
    }

    public air_klass getKlass() {
        return klass;
    }

    public void setKlass(air_klass klass) {
        this.klass = klass;
    }
}
