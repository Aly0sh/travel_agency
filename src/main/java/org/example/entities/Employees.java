package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "passport_id")
    private Integer passport_id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private List<Tour_tasks> tour_tasks;

    @OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Employees(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(Integer passport_id) {
        this.passport_id = passport_id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
}
