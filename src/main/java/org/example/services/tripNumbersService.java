package org.example.services;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class tripNumbersService extends Service{
    public tripNumbersService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Rooms rooms, Trip trip){
        Session session = getSession();
        Trips_numbers trips_numbers = new Trips_numbers();
        trips_numbers.setCity(rooms.getCity());
        trips_numbers.setName(rooms.getName());
        trips_numbers.setArrival_date(rooms.getArrival_date());
        trips_numbers.setPassport_id(trip.getPassport_id());
        trips_numbers.setCategory(rooms.getCategory());
        trips_numbers.setAddress(trip.getAddress());
        trips_numbers.setClient_name(trip.getAgreement_id().getClient().getName());
        trips_numbers.setTour_number(rooms.getHotel().getTour_number());
        trips_numbers.setRegistration_date(trip.getRegistration_date());
        trips_numbers.setTrip(trip);
        trips_numbers.setRoom(rooms);
        session.beginTransaction();
        session.save(trips_numbers);
        session.getTransaction().commit();
    }

    public Trips_numbers read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Trips_numbers trips_numbers = session.get(Trips_numbers.class, id);
        session.getTransaction().commit();
        return trips_numbers;
    }

    public void update(Rooms rooms, Trip trip, Long id){
        Session session = getSession();
        Trips_numbers trips_numbers = session.get(Trips_numbers.class, id);
        trips_numbers.setCity(rooms.getCity());
        trips_numbers.setName(rooms.getName());
        trips_numbers.setArrival_date(rooms.getArrival_date());
        trips_numbers.setPassport_id(trip.getPassport_id());
        trips_numbers.setCategory(rooms.getCategory());
        trips_numbers.setAddress(trip.getAddress());
        trips_numbers.setClient_name(trip.getAgreement_id().getClient().getName());
        trips_numbers.setTour_number(rooms.getHotel().getTour_number());
        trips_numbers.setRegistration_date(trip.getRegistration_date());
        trips_numbers.setTrip(trip);
        trips_numbers.setRoom(rooms);
        session.beginTransaction();
        session.save(trips_numbers);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Trips_numbers.class, id));
        session.getTransaction().commit();
    }
}
