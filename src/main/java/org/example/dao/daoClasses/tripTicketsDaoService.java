package org.example.dao.daoClasses;

import org.example.models.Event_tickets;
import org.example.models.Events;
import org.example.models.Trip;
import org.example.models.Trips_tickets;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class tripTicketsDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Event_tickets event_tickets, Trip trip){
        Trips_tickets trips_tickets = new Trips_tickets();
        trips_tickets.setPlace(event_tickets.getPlace());
        trips_tickets.setCity(event_tickets.getCity());
        trips_tickets.setStart_date(event_tickets.getStart_date());
        trips_tickets.setVenue(event_tickets.getVenue());
        trips_tickets.setStart_time(event_tickets.getStart_time());
        trips_tickets.setPassport_id(trip.getPassport_id());
        trips_tickets.setName(trip.getName());
        trips_tickets.setAddress(trip.getAddress());
        trips_tickets.setTour_number(trip.getTour_number());
        trips_tickets.setRegistration_date(trip.getRegistration_date());
        trips_tickets.setTrip(trip);
        trips_tickets.setEvent_tickets(event_tickets);
        factory.getCurrentSession().save(trips_tickets);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Trips_tickets.class, id);
    }

    public void update(Event_tickets event_tickets, Trip trip, Long id){
        Session session = factory.getCurrentSession();
        Trips_tickets trips_tickets = session.get(Trips_tickets.class, id);
        trips_tickets.setPlace(event_tickets.getPlace());
        trips_tickets.setCity(event_tickets.getCity());
        trips_tickets.setStart_date(event_tickets.getStart_date());
        trips_tickets.setVenue(event_tickets.getVenue());
        trips_tickets.setStart_time(event_tickets.getStart_time());
        trips_tickets.setPassport_id(trip.getPassport_id());
        trips_tickets.setName(trip.getName());
        trips_tickets.setAddress(trip.getAddress());
        trips_tickets.setTour_number(trip.getTour_number());
        trips_tickets.setRegistration_date(trip.getRegistration_date());
        trips_tickets.setTrip(trip);
        trips_tickets.setEvent_tickets(event_tickets);
        session.clear();
        session.update(trips_tickets);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Trips_tickets.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Trips_tickets ").getResultList();
        return list;
    }
}
