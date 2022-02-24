package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "passport_id")
    private Integer passport_id;

    @JoinColumn(name = "position")
    @ManyToOne(cascade = CascadeType.ALL)
    private position position;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public employees(){}

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

    public org.example.entities.position getPosition() {
        return position;
    }

    public void setPosition(org.example.entities.position position) {
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
