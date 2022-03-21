package org.example.dao.daoClasses;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

@Repository
@Transactional
public class eventDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(String city, String venue, Time startTime, String name, Tour tour){
        Events event = new Events();
        event.setCity(city);
        event.setVenue(venue);
        event.setStart_time(startTime);
        event.setStart_date(tour.getStart_date());
        event.setTour_number(tour.getTour_number());
        event.setName(name);
        event.setCountry(tour.getCountry().getCountry());
        event.setTour_type(tour.getTour_type().getTour_type());
        event.setEnd_date(tour.getEnd_date());
        event.setProgram_number(tour.getProgram_number().getProgram_number());
        event.setTour(tour);
        factory.getCurrentSession().save(event);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Events.class, id);
    }

    public void update(String city, String venue, Time startTime, String name, Tour tour, Long id){
        Session session = factory.getCurrentSession();
        Events event = session.get(Events.class, id);
        event.setCity(city);
        event.setVenue(venue);
        event.setStart_time(startTime);
        event.setStart_date(tour.getStart_date());
        event.setTour_number(tour.getTour_number());
        event.setName(name);
        event.setCountry(tour.getCountry().getCountry());
        event.setTour_type(tour.getTour_type().getTour_type());
        event.setEnd_date(tour.getEnd_date());
        event.setProgram_number(tour.getProgram_number().getProgram_number());
        event.setTour(tour);
        session.clear();
        session.update(event);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Events.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Events ").getResultList();
        return list;
    }
}
