package org.example.dao.daoClasses;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
@Transactional
public class tourFlightsDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Integer flight_code, String air_company, Date departure_date, Time departure_time, String arrival_city, String departure_city, String directions, Tour tour){
        Tour_flights tour_flights = new Tour_flights();
        tour_flights.setFlight_code(flight_code);
        tour_flights.setAir_company(air_company);
        tour_flights.setTour_number(tour.getTour_number());
        tour_flights.setDeparture_date(departure_date);
        tour_flights.setDeparture_time(departure_time);
        tour_flights.setArrival_city(arrival_city);
        tour_flights.setDeparture_city(departure_city);
        tour_flights.setDirections(directions);
        tour_flights.setCountry(tour.getCountry().getCountry());
        tour_flights.setTour_type(tour.getTour_type().getTour_type());
        tour_flights.setStart_date(tour.getStart_date());
        tour_flights.setEnd_date(tour.getEnd_date());
        tour_flights.setProgram_number(tour_flights.getProgram_number());
        tour_flights.setTour(tour);
        tour_flights.setProgram_number(tour.getProgram_number().getProgram_number());
        factory.getCurrentSession().save(tour_flights);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Tour_flights.class, id);
    }

    public void update(Integer flight_code, String air_company, Date departure_date, Time departure_time, String arrival_city, String departure_city, String directions, Tour tour, Long id){
        Session session = factory.getCurrentSession();
        Tour_flights tour_flights = session.get(Tour_flights.class, id);
        tour_flights.setFlight_code(flight_code);
        tour_flights.setAir_company(air_company);
        tour_flights.setTour_number(tour.getTour_number());
        tour_flights.setDeparture_date(departure_date);
        tour_flights.setDeparture_time(departure_time);
        tour_flights.setArrival_city(arrival_city);
        tour_flights.setDeparture_city(departure_city);
        tour_flights.setDirections(directions);
        tour_flights.setCountry(tour.getCountry().getCountry());
        tour_flights.setTour_type(tour.getTour_type().getTour_type());
        tour_flights.setStart_date(tour.getStart_date());
        tour_flights.setEnd_date(tour.getEnd_date());
        tour_flights.setProgram_number(tour_flights.getProgram_number());
        tour_flights.setTour(tour);
        tour_flights.setProgram_number(tour.getProgram_number().getProgram_number());
        session.clear();
        session.update(tour_flights);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Tour_flights.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Tour_flights ").getResultList();
        return list;
    }
}
