package org.example.services;

import org.example.models.Agreement;
import org.example.models.Client;
import org.example.models.Hotel_klass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class hotelClassService extends Service{

    public hotelClassService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(String klass){
        Session session = getSession();
        Hotel_klass hotel_klass = new Hotel_klass();
        hotel_klass.setKlass(klass);
        session.beginTransaction();
        session.save(hotel_klass);
        session.getTransaction().commit();
    }

    public Hotel_klass read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Hotel_klass hotel_klass = session.get(Hotel_klass.class, id);
        session.getTransaction().commit();
        return hotel_klass;
    }

    public void update(String klass, Long id){
        Session session = getSession();
        Hotel_klass hotel_klass = session.get(Hotel_klass.class, id);
        hotel_klass.setKlass(klass);
        session.beginTransaction();
        session.save(hotel_klass);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Hotel_klass.class, id));
        session.getTransaction().commit();
    }
}
