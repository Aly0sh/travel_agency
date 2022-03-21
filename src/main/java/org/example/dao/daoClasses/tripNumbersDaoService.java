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
public class tripNumbersDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Rooms rooms, Trip trip){
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
        factory.getCurrentSession().save(trips_numbers);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Trips_numbers.class, id);
    }

    public void update(Rooms rooms, Trip trip, Long id){
        Session session = factory.getCurrentSession();
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
        session.clear();
        session.update(trips_numbers);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Trips_numbers.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Trips_numbers ").getResultList();
        return list;
    }
}
