package org.example.dao.daoClasses;

import org.example.dao.Dao;
import org.example.models.Client;
import org.example.models.Tour;
import org.example.models.Tourist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class touristDaoService implements Dao {
    @Autowired
    private SessionFactory factory;

    public void create(Integer passport_id, String name, String address, Integer age){
        Tourist tourist = new Tourist();
        tourist.setPassport_id(passport_id);
        tourist.setName(name);
        tourist.setAddress(address);
        tourist.setAge(age);
        factory.getCurrentSession().save(tourist);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Tourist.class, id);
    }

    public void update(Integer passport_id, String name, String address, Integer age, Long id){
        Session session = factory.getCurrentSession();
        Tourist tourist = session.get(Tourist.class, id);
        tourist.setPassport_id(passport_id);
        tourist.setName(name);
        tourist.setAddress(address);
        tourist.setAge(age);
        session.clear();
        session.update(tourist);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Tourist.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Tourist ").getResultList();
        return list;
    }
}
