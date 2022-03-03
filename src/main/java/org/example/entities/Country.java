package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Tour> tour;

    public Country(){}

    public void addTour(Tour t){
        if (tour == null){
            tour = new ArrayList<>();
        }
        tour.add(t);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
