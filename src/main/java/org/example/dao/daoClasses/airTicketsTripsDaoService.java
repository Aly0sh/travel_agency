package org.example.dao.daoClasses;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class airTicketsTripsDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Air_tickets air_tickets, Trip trip){
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
        factory.getCurrentSession().save(air_tickets_trips);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Air_tickets_trips.class, id);
    }

    public void update(Air_tickets air_tickets, Trip trip, Long id){
        Session session = factory.getCurrentSession();
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
        session.clear();
        session.update(air_tickets_trips);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Air_tickets_trips.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Air_tickets_trips ").getResultList();
        return list;
    }
}
