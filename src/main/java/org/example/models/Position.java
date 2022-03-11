package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "position")
    private List<Employees> employees;

    public Position(){}

    public Long getId() {
        return id;
    }

    public void addEmployeeToPosition(Employees employee){
        if(employees == null){
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
