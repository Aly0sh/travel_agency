package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "hotel_klass")
public class hotel_klass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "klass")
    private String klass;

    public hotel_klass(){}

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
