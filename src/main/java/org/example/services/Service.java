package org.example.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class Service {
    private final SessionFactory factory;
    private Session session;

    public Service(SessionFactory sessionFactory){
        factory = sessionFactory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public Session getSession(){
        session = getFactory().getCurrentSession();
        return session;
    }
}
