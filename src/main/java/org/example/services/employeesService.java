package org.example.services;

import org.example.models.Employees;
import org.example.models.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class employeesService extends Service{
    public employeesService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Integer passport_id, String name, String address, Position position){
        Session session = getSession();
        Employees employees = new Employees();
        employees.setPassport_id(passport_id);
        employees.setName(name);
        employees.setAddress(address);
        employees.setPosition(position);
        session.beginTransaction();
        session.save(employees);
        session.getTransaction().commit();
    }

    public Employees read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Employees employees = session.get(Employees.class, id);
        session.getTransaction().commit();
        return employees;
    }

    public void update(Integer passport_id, String name, String address, Position position, Long id){
        Session session = getSession();
        session.beginTransaction();
        Employees employees = session.get(Employees.class, id);
        employees.setPassport_id(passport_id);
        employees.setName(name);
        employees.setAddress(address);
        employees.setPosition(position);
        session.save(employees);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Employees.class, id));
        session.getTransaction().commit();
    }

}
