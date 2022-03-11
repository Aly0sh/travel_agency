package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "program_number")
    private Integer program_number;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "program_number", cascade = CascadeType.ALL)
    private List<Tour> tour;

    public Program(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
