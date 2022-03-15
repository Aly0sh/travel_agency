package org.example.services;

import org.example.models.Air_tickets;
import org.example.models.Air_tickets_trips;
import org.example.models.Tourist;
import org.example.models.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class airTicketsTripsService extends Service{
    public airTicketsTripsService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Air_tickets air_tickets, Trip trip){
        Session session = getSession();
        Air_tickets_trips air_tickets_trips = new Air_tickets_trips();
        air_tickets_trips.setPlace(air_tickets.getPlace());
        air_tickets_trips.setFlight_code(air_tickets.getFlight_code());
        air_tickets_trips.setAir_company(air_tickets.getAir_company());
        air_tickets_trips.setPassport_id(trip.getPassport_id());
        air_tickets_trips.setName(trip.getName());
        air_tickets_trips.setAddress(trip.getAddress());
        air_tickets_trips.setTrip_number(trip.getTour_number());
        air_tickets_trips.setRegistration_date(trip.getRegistration_date());
        air_tickets_trips.setTrip_number(trip.getTrip_number());
        air_tickets_trips.setAir_tickets(air_tickets);
        air_tickets_trips.setTrip(trip);
        session.beginTransaction();
        session.save(air_tickets_trips);
        session.getTransaction().commit();
    }

    public Air_tickets_trips read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Air_tickets_trips air_tickets_trips = session.get(Air_tickets_trips.class, id);
        session.getTransaction().commit();
        return air_tickets_trips;
    }

    public void update(Air_tickets air_tickets, Trip trip, Long id){
        Session session = getSession();
        session.beginTransaction();
        Air_tickets_trips air_tickets_trips = session.get(Air_tickets_trips.class, id);
        air_tickets_trips.setPlace(air_tickets.getPlace());
        air_tickets_trips.setFlight_code(air_tickets.getFlight_code());
        air_tickets_trips.setAir_company(air_tickets.getAir_company());
        air_tickets_trips.setPassport_id(trip.getPassport_id());
        air_tickets_trips.setName(trip.getName());
        air_tickets_trips.setAddress(trip.getAddress());
        air_tickets_trips.setTrip_number(trip.getTour_number());
        air_tickets_trips.setRegistration_date(trip.getRegistration_date());
        air_tickets_trips.setTrip_number(trip.getTrip_number());
        air_tickets_trips.setAir_tickets(air_tickets);
        air_tickets_trips.setTrip(trip);
        session.save(air_tickets_trips);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Air_tickets_trips.class, id));
        session.getTransaction().commit();
    }
}
