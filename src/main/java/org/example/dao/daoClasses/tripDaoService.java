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
public class tripDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Integer tripNumber, Agreement agreement, Tourist tourist){
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
        factory.getCurrentSession().save(trip);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Trip.class, id);
    }

    public void update(Integer tripNumber, Agreement agreement, Tourist tourist, Long id){
        Session session = factory.getCurrentSession();
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
        session.clear();
        session.update(trip);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Trip.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Trip ").getResultList();
        return list;
    }
}
