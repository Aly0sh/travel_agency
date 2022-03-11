package org.example.services;

import org.example.models.Country;
import org.example.models.Program;
import org.example.models.Tour;
import org.example.models.Tour_type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class tourService extends Service{

    public tourService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Integer tourNumber,
                       Tour_type tour_type,
                       Country country,
                       Date start_date,
                       Date end_date,
                       Program program,
                       String name,
                       String status){
        Session session = getSession();
        Tour tour = new Tour();
        tour.setTour_number(tourNumber);
        tour.setTour_type(tour_type);
        tour.setCountry(country);
        tour.setStart_date(start_date);
        tour.setEnd_date(end_date);
        tour.setProgram_number(program);
        tour.setName(name);
        tour.setStatus(status);
        session.beginTransaction();
        session.save(tour);
        session.getTransaction().commit();
    }

    public Tour read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Tour tour = session.get(Tour.class, id);
        session.getTransaction().commit();
        return tour;
    }

    public void update(Integer tourNumber,
                       Tour_type tour_type,
                       Country country,
                       Date start_date,
                       Date end_date,
                       Program program,
                       String name,
                       String status,
                       Long id){
        Session session = getSession();
        session.beginTransaction();
        Tour tour = session.get(Tour.class, id);
        tour.setTour_number(tourNumber);
        tour.setTour_type(tour_type);
        tour.setCountry(country);
        tour.setStart_date(start_date);
        tour.setEnd_date(end_date);
        tour.setProgram_number(program);
        tour.setName(name);
        tour.setStatus(status);
        session.save(tour);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Tour.class, id));
        session.getTransaction().commit();
    }
}
