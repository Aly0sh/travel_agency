package org.example.services;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class tripService extends Service{
    public tripService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public void create(Integer tripNumber, Agreement agreement, Tourist tourist){
        Session session = getSession();
        Trip trip = new Trip();
        trip.setTrip_number(tripNumber);
        trip.setPassport_id(tourist.getPassport_id());
        trip.setName(tourist.getName());
        trip.setAddress(tourist.getAddress());
        trip.setTour_number(agreement.getTour_number());
        trip.setRegistration_date(agreement.getRegistration_date());
        trip.setTour_number(agreement.getTour_number());
        trip.setAgreement_id(agreement);
        trip.setTourist(tourist);
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
    }

    public Trip read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Trip trip = session.get(Trip.class, id);
        session.getTransaction().commit();
        return trip;
    }

    public void update(Integer tripNumber, Agreement agreement, Tourist tourist, Long id){
        Session session = getSession();
        session.beginTransaction();
        Trip trip = session.get(Trip.class, id);
        trip.setTrip_number(tripNumber);
        trip.setPassport_id(tourist.getPassport_id());
        trip.setName(tourist.getName());
        trip.setAddress(tourist.getAddress());
        trip.setTour_number(agreement.getTour_number());
        trip.setRegistration_date(agreement.getRegistration_date());
        trip.setTour_number(agreement.getTour_number());
        trip.setAgreement_id(agreement);
        trip.setTourist(tourist);
        session.save(trip);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Trip.class, id));
        session.getTransaction().commit();
    }

}
