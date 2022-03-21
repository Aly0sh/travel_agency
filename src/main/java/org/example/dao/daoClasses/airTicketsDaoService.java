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
public class airTicketsDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Integer place, Tour_flights tour_flights, Air_klass air_klass){
        Air_tickets air_tickets = new Air_tickets();
        air_tickets.setPlace(place);
        air_tickets.setFlight_code(tour_flights.getFlight_code());
        air_tickets.setAir_company(tour_flights.getAir_company());
        air_tickets.setKlass(air_klass.getKlass());
        air_tickets.setAir_klass(air_klass);
        air_tickets.setTour_flight(tour_flights);
        factory.getCurrentSession().save(air_tickets);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Air_tickets.class, id);
    }

    public void update(Integer place, Tour_flights tour_flights, Air_klass air_klass, Long id){
        Session session = factory.getCurrentSession();
        Air_tickets air_tickets = session.get(Air_tickets.class, id);
        air_tickets.setPlace(place);
        air_tickets.setFlight_code(tour_flights.getFlight_code());
        air_tickets.setAir_company(tour_flights.getAir_company());
        air_tickets.setKlass(air_klass.getKlass());
        air_tickets.setAir_klass(air_klass);
        air_tickets.setTour_flight(tour_flights);
        session.clear();
        session.update(air_tickets);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Air_tickets.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Air_tickets ").getResultList();
        return list;
    }
}
