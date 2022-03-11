package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "air_klass")
public class Air_klass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "klass")
    private String klass;

    @OneToMany(mappedBy = "air_klass", cascade = CascadeType.ALL)
    private List<Air_tickets> air_tickets;

    public Air_klass(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }
}
