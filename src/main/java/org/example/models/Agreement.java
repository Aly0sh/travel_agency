package org.example.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "agreement")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private Integer agreement_number;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Integer tour_number;

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

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client")
    private Client client;

    @OneToMany(mappedBy = "agreement_id", cascade = CascadeType.MERGE)
    private List<Trip> trips;

    public Agreement(){};

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgreement_number() {
        return agreement_number;
    }

    public void setAgreement_number(Integer agreement_number) {
        this.agreement_number = agreement_number;
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
