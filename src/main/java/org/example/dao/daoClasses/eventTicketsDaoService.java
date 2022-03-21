package org.example.dao.daoClasses;

import org.example.models.Event_tickets;
import org.example.models.Events;
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
public class eventTicketsDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Integer place, Events events){
        Event_tickets event_tickets = new Event_tickets();
        event_tickets.setPlace(place);
        event_tickets.setCity(events.getCity());
        event_tickets.setStart_date(events.getStart_date());
        event_tickets.setVenue(events.getVenue());
        event_tickets.setStart_time(events.getStart_time());
        event_tickets.setEvent(events);
        factory.getCurrentSession().save(event_tickets);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Event_tickets.class, id);
    }

    public void update(Integer place, Events events, Long id){
        Session session = factory.getCurrentSession();
        Event_tickets event_tickets = session.get(Event_tickets.class, id);
        event_tickets.setPlace(place);
        event_tickets.setCity(events.getCity());
        event_tickets.setStart_date(events.getStart_date());
        event_tickets.setVenue(events.getVenue());
        event_tickets.setStart_time(events.getStart_time());
        event_tickets.setEvent(events);
        session.clear();
        session.update(event_tickets);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Event_tickets.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Event_tickets ").getResultList();
        return list;
    }
}
