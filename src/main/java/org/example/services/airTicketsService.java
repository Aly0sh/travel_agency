package org.example.services;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class airTicketsService extends Service{
    public airTicketsService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Integer place, Tour_flights tour_flights, Air_klass air_klass){
        Session session = getSession();
        Air_tickets air_tickets = new Air_tickets();
        air_tickets.setPlace(place);
        air_tickets.setFlight_code(tour_flights.getFlight_code());
        air_tickets.setAir_company(tour_flights.getAir_company());
        air_tickets.setKlass(air_klass.getKlass());
        air_tickets.setAir_klass(air_klass);
        air_tickets.setTour_flight(tour_flights);
        session.beginTransaction();
        session.save(air_tickets);
        session.getTransaction().commit();
    }

    public Air_tickets read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Air_tickets air_tickets = session.get(Air_tickets.class, id);
        session.getTransaction().commit();
        return air_tickets;
    }

    public void update(Integer place, Tour_flights tour_flights, Air_klass air_klass, Long id){
        Session session = getSession();
        Air_tickets air_tickets = session.get(Air_tickets.class, id);
        air_tickets.setPlace(place);
        air_tickets.setFlight_code(tour_flights.getFlight_code());
        air_tickets.setAir_company(tour_flights.getAir_company());
        air_tickets.setKlass(air_klass.getKlass());
        air_tickets.setAir_klass(air_klass);
        air_tickets.setTour_flight(tour_flights);
        session.beginTransaction();
        session.save(air_tickets);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Air_tickets.class, id));
        session.getTransaction().commit();
    }
}
