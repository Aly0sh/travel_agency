package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "hotel")
public class hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "tour_number")
    @ManyToOne
    private tour tour_number;

    @NotNull
    @JoinColumn(name = "klass")
    @ManyToOne
    private hotel_klass klass;

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

    public hotel(){}

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

    public tour getTour_number() {
        return tour_number;
    }

    public void setTour_number(tour tour_number) {
        this.tour_number = tour_number;
    }

    public hotel_klass getKlass() {
        return klass;
    }

    public void setKlass(hotel_klass klass) {
        this.klass = klass;
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