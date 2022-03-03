package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tour_tasks")
public class Tour_tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "task_number")
    private Integer task_number;

    @Column
    private Integer passport_id;

    @Column
    private Integer tour_number;

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

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "status")
    private byte[] status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Tour tour;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Employees employees;

    public Tour_tasks(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTask_number() {
        return task_number;
    }

    public void setTask_number(Integer task_number) {
        this.task_number = task_number;
    }

    public Integer getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(Integer passport_id) {
        this.passport_id = passport_id;
    }

    public Integer getTour_number() {
        return tour_number;
    }

    public void setTour_number(Integer tour_number) {
        this.tour_number = tour_number;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public byte[] getStatus() {
        return status;
    }

    public void setStatus(byte[] status) {
        this.status = status;
    }
}
