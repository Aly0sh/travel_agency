package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "room_category", cascade = CascadeType.ALL)
    private List<Rooms> rooms;

    public Category(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
