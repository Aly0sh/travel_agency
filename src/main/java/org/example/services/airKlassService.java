package org.example.services;

import org.example.models.Agreement;
import org.example.models.Air_klass;
import org.example.models.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class airKlassService extends Service{
    public airKlassService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(String klass){
        Session session = getSession();
        Air_klass air_klass = new Air_klass();
        air_klass.setKlass(klass);
        session.beginTransaction();
        session.save(air_klass);
        session.getTransaction().commit();
    }

    public Air_klass read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Air_klass air_klass = session.get(Air_klass.class, id);
        session.getTransaction().commit();
        return air_klass;
    }

    public void update(String klass, Long id){
        Session session = getSession();
        Air_klass air_klass = session.get(Air_klass.class, id);
        air_klass.setKlass(klass);
        session.beginTransaction();
        session.save(air_klass);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Air_klass.class, id));
        session.getTransaction().commit();
    }
}
