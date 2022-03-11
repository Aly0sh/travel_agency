package org.example.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private Integer tour_number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_type")
    private Tour_type tour_type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country")
    private Country country;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_number")
    private Program program_number;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "tour")
    private List<Agreement> agreements;

    @OneToMany(mappedBy = "tour")
    private List<Tour_flights> tour_flights;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<Events> events;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<Tour_tasks> tour_tasks;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Tour(){}

    public Integer getTour_number() {
        return tour_number;
    }

    public void setTour_number(Integer tour_number) {
        this.tour_number = tour_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tour_type getTour_type() {
        return tour_type;
    }

    public void setTour_type(Tour_type tour_type) {
        this.tour_type = tour_type;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public Program getProgram_number() {
        return program_number;
    }

    public void setProgram_number(Program program_number) {
        this.program_number = program_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
