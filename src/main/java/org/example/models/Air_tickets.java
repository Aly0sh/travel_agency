package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Air_tickets")
public class Air_tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "place")
    private Integer place;

    @Column
    private Integer flight_code;

    @Column(name = "air_company")
    private String air_company;

    @Column
    private String klass;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Air_klass air_klass;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Tour_flights tour_flight;

    @OneToMany(mappedBy = "air_tickets", cascade = CascadeType.ALL)
    private List<Air_tickets_trips> air_tickets_trips;

    public Air_tickets(){}

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

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }
}
