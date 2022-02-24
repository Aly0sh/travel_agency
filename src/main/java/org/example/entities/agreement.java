package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "agreement ")
public class agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long agreement_number;

    @NotNull
    @JoinColumn(name = "name")
    @ManyToOne
    private client name;

    @NotNull
    @JoinColumn(name = "address")
    @ManyToOne
    private client address;

    @JoinColumn(name = "tour_number")
    @ManyToOne
    private tour tour_number;

    @Column(name = "registration_date")
    private Date registration_date;

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

    public agreement(){};

    public client getName() {
        return name;
    }

    public void setName(client name) {
        this.name = name;
    }

    public client getAddress() {
        return address;
    }

    public void setAddress(client address) {
        this.address = address;
    }

    public tour getTour_number() {
        return tour_number;
    }

    public void setTour_number(tour tour_number) {
        this.tour_number = tour_number;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Long getAgreement_number() {
        return agreement_number;
    }

    public void setAgreement_number(Long agreement_number) {
        this.agreement_number = agreement_number;
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
