package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tour_type")
public class Tour_type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "tour_type")
    private String tour_type;

    @OneToMany(mappedBy = "tour_type", cascade = CascadeType.ALL)
    private List<Tour> tour;

    public Tour_type(){}

    public Long getId() {
        return id;
    }

    public void addTour(Tour tour){
        if(this.tour == null){
            this.tour = new ArrayList<>();
        }
        this.tour.add(tour);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTour_type() {
        return tour_type;
    }

    public void setTour_type(String tour_type) {
        this.tour_type = tour_type;
    }
}
