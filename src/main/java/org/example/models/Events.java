package org.example.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "venue")
    private String venue;

    @Column(name = "start_time")
    private Time start_time;

    @Column(name = "start_date")
    private Date start_date;

    @Column
    private Integer tour_number;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "tour_type")
    private String tour_type;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "program_number")
    private Integer program_number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Tour tour;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Event_tickets> event_tickets;

    public Events(){}

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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public List<Event_tickets> getEvent_tickets() {
        return event_tickets;
    }

    public void setEvent_tickets(List<Event_tickets> event_tickets) {
        this.event_tickets = event_tickets;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Integer getTour_number() {
        return tour_number;
    }

    public void setTour_number(Integer tour_number) {
        this.tour_number = tour_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
