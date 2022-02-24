package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tour")
public class tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tour_number")
    private Long tour_number;

    @NotNull
    @JoinColumn(name = "tour_type")
    @ManyToOne(cascade = CascadeType.ALL)
    private tour_type tour_type;

    @NotNull
    @JoinColumn(name = "country")
    @ManyToOne(cascade = CascadeType.ALL)
    private country country;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @NotNull
    @JoinColumn(name = "program_number")
    @ManyToOne(cascade = CascadeType.ALL)
    private program program_number;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    public tour(){}

    public Long getTour_number() {
        return tour_number;
    }

    public void setTour_number(Long tour_number) {
        this.tour_number = tour_number;
    }

    public org.example.entities.tour_type getTour_type() {
        return tour_type;
    }

    public void setTour_type(org.example.entities.tour_type tour_type) {
        this.tour_type = tour_type;
    }

    public org.example.entities.country getCountry() {
        return country;
    }

    public void setCountry(org.example.entities.country country) {
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

    public program getProgram_number() {
        return program_number;
    }

    public void setProgram_number(program program_number) {
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
