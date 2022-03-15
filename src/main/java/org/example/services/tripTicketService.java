package org.example.services;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class tripTicketService extends Service{
    public tripTicketService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Event_tickets event_tickets, Trip trip){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(trips_tickets);
        session.getTransaction().commit();
    }

    public Trips_tickets read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Trips_tickets trips_tickets = session.get(Trips_tickets.class, id);
        session.getTransaction().commit();
        return trips_tickets;
    }

    public void update(Event_tickets event_tickets, Trip trip, Long id){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(trips_tickets);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Trips_tickets.class, id));
        session.getTransaction().commit();
    }
}
