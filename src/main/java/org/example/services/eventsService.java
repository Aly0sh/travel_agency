package org.example.services;

import org.example.models.Agreement;
import org.example.models.Client;
import org.example.models.Events;
import org.example.models.Tour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Time;

public class eventsService extends Service{
    public eventsService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(String city, String venue, Time startTime, String name, Tour tour){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
    }

    public Events read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Events events = session.get(Events.class, id);
        session.getTransaction().commit();
        return events;
    }

    public void update(String city, String venue, Time startTime, String name, Tour tour, Long id){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Events.class, id));
        session.getTransaction().commit();
    }
}
