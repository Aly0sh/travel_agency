package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private String address;

    @Column(name = "client_number")
    private Integer client_number;

    @Column(name = "phone")
    private Integer phone;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Agreement agreement;

    public Client(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getClient_number() {
        return client_number;
    }

    public void setClient_number(Integer client_number) {
        this.client_number = client_number;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

}
