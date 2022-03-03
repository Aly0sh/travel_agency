package org.example.services;

import org.example.entities.Position;
import org.example.entities.Tour_type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class tourTypeService extends Service{
    private Tour_type tour_type;

    public tourTypeService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(String type){
        Session session = getSession();
        this.tour_type = new Tour_type();
        this.tour_type.setTour_type(type);
        session.beginTransaction();
        session.save(this.tour_type);
        session.getTransaction().commit();
    }

    public Tour_type read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Tour_type tour_type = session.get(Tour_type.class, id);
        session.getTransaction().commit();
        return tour_type;
    }

    public void update(String tourType, Long id){
        Session session = getSession();
        session.beginTransaction();
        Tour_type tour_type1 = session.get(Tour_type.class, id);
        tour_type1.setTour_type(tourType);
        session.save(tour_type1);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Tour_type.class, id));
        session.getTransaction().commit();
    }
}
