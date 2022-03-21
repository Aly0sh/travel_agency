package org.example.dao.daoClasses;

import org.example.models.Events;
import org.example.models.Hotel_klass;
import org.example.models.Tour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

@Repository
@Transactional
public class hotelKlassDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(String hotel_klass){
        Hotel_klass hotel_klass1 = new Hotel_klass();
        hotel_klass1.setKlass(hotel_klass);
        factory.getCurrentSession().save(hotel_klass1);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Hotel_klass.class, id);
    }

    public void update(String hotel_klass, Long id){
        Session session = factory.getCurrentSession();
        Hotel_klass hotel_klass1 = session.get(Hotel_klass.class, id);
        hotel_klass1.setKlass(hotel_klass);
        session.clear();
        session.update(hotel_klass1);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Hotel_klass.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Hotel_klass ").getResultList();
        return list;
    }
}
