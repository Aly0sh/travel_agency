package org.example.dao.daoClasses;

import org.example.dao.Dao;
import org.example.models.Employees;
import org.example.models.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class employeeDaoService implements Dao {
    @Autowired
    private SessionFactory factory;


    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Employees> employees = session.createQuery("from Employees ").getResultList();
        return employees;
    }

    public void create(Integer passport_id, String name, String address, Position position){
        Session session = factory.getCurrentSession();
        Employees employees = new Employees();
        employees.setPassport_id(passport_id);
        employees.setName(name);
        employees.setAddress(address);
        employees.setPosition(position);
        session.save(employees);
    }

    public void create(Employees employees){
        Session session = factory.getCurrentSession();
        session.save(employees);
    }

    public Employees read(Long id){
        Session session = factory.getCurrentSession();
        Employees employees = session.get(Employees.class, id);
        return employees;
    }

    public void update(Integer passport_id, String name, String address, Position position, Long id){
        Session session = factory.getCurrentSession();
        Employees employees = session.get(Employees.class, id);
        employees.setPassport_id(passport_id);
        employees.setName(name);
        employees.setAddress(address);
        employees.setPosition(position);
        session.save(employees);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Employees.class, id));
    }
}
