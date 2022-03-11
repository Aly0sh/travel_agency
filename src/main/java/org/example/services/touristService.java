package org.example.services;

import org.example.models.Tourist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class touristService extends Service{
    public touristService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Integer passport_id, String name, String address){
        Session session = getSession();
        Tourist tourist = new Tourist();
        tourist.setPassport_id(passport_id);
        tourist.setName(name);
        tourist.setAddress(address);
        session.beginTransaction();
        session.save(tourist);
        session.getTransaction().commit();
    }

    public Tourist read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Tourist tourist = session.get(Tourist.class, id);
        session.getTransaction().commit();
        return tourist;
    }

    public void update(Integer passport_id, String name, String address, Long id){
        Session session = getSession();
        session.beginTransaction();
        Tourist tourist = session.get(Tourist.class, id);
        tourist.setPassport_id(passport_id);
        tourist.setName(name);
        tourist.setAddress(address);
        session.save(tourist);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Tourist.class, id));
        session.getTransaction().commit();
    }
}
