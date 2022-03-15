package org.example.services;

import org.example.models.Agreement;
import org.example.models.Client;
import org.example.models.Tour;
import org.example.models.Tour_flights;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.sql.Time;

public class tourFlightsService extends Service{
    public tourFlightsService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Integer flight_code, String air_company, Date departure_date, Time departure_time, String arrival_city, String departure_city, String directions, Tour tour){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(tour_flights);
        session.getTransaction().commit();
    }

    public Tour_flights read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Tour_flights tour_flights = session.get(Tour_flights.class, id);
        session.getTransaction().commit();
        return tour_flights;
    }

    public void update(Integer flight_code, String air_company, Date departure_date, Time departure_time, String arrival_city, String departure_city, String directions, Tour tour, Long id){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(tour_flights);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Tour_flights.class, id));
        session.getTransaction().commit();
    }
}
