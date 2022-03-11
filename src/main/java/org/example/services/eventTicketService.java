package org.example.services;

import org.example.models.Agreement;
import org.example.models.Client;
import org.example.models.Event_tickets;
import org.example.models.Events;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class eventTicketService extends Service{
    public eventTicketService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Integer place, Events events){
        Session session = getSession();
        Event_tickets event_tickets = new Event_tickets();
        event_tickets.setPlace(place);
        event_tickets.setCity(events.getCity());
        event_tickets.setStart_date(events.getStart_date());
        event_tickets.setVenue(events.getVenue());
        event_tickets.setStart_time(events.getStart_time());
        event_tickets.setEvent(events);
        session.beginTransaction();
        session.save(event_tickets);
        session.getTransaction().commit();
    }

    public Event_tickets read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Event_tickets event_tickets = session.get(Event_tickets.class, id);
        session.getTransaction().commit();
        return event_tickets;
    }

    public void update(Integer place, Events events, Long id){
        Session session = getSession();
        Event_tickets event_tickets = session.get(Event_tickets.class, id);
        event_tickets.setPlace(place);
        event_tickets.setCity(events.getCity());
        event_tickets.setStart_date(events.getStart_date());
        event_tickets.setVenue(events.getVenue());
        event_tickets.setStart_time(events.getStart_time());
        event_tickets.setEvent(events);
        session.beginTransaction();
        session.save(event_tickets);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Event_tickets.class, id));
        session.getTransaction().commit();
    }
}
