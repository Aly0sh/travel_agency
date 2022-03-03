package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private Integer tour_number;

    @Column
    private Integer passport_id;

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

    @Column(name = "order_number")
    private Integer order_number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Tour tour;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Employees employees;

    public Order(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTour_number() {
        return tour_number;
    }

    public void setTour_number(Integer tour_number) {
        this.tour_number = tour_number;
    }

    public Integer getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(Integer passport_id) {
        this.passport_id = passport_id;
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

    public Integer getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Integer order_number) {
        this.order_number = order_number;
    }
}
