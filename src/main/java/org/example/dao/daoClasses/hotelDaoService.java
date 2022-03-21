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
public class hotelDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(String city, String name, Tour tour, Hotel_klass hotel_klass){
        Hotel hotel = new Hotel();
        hotel.setCity(city);
        hotel.setName(name);
        hotel.setTour_number(tour.getTour_number());
        hotel.setKlass(hotel_klass.getKlass());
        hotel.setCountry(tour.getCountry().getCountry());
        hotel.setTour_type(tour.getTour_type().getTour_type());
        hotel.setStart_date(tour.getStart_date());
        hotel.setEnd_date(tour.getEnd_date());
        hotel.setProgram_number(tour.getProgram_number().getProgram_number());
        hotel.setTour(tour);
        hotel.setHotel_klass(hotel_klass);
        factory.getCurrentSession().save(hotel);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Hotel.class, id);
    }

    public void update(String city, String name, Tour tour, Hotel_klass hotel_klass, Long id){
        Session session = factory.getCurrentSession();
        Hotel hotel = session.get(Hotel.class, id);
        hotel.setCity(city);
        hotel.setName(name);
        hotel.setTour_number(tour.getTour_number());
        hotel.setKlass(hotel_klass.getKlass());
        hotel.setCountry(tour.getCountry().getCountry());
        hotel.setTour_type(tour.getTour_type().getTour_type());
        hotel.setStart_date(tour.getStart_date());
        hotel.setEnd_date(tour.getEnd_date());
        hotel.setProgram_number(tour.getProgram_number().getProgram_number());
        hotel.setTour(tour);
        hotel.setHotel_klass(hotel_klass);
        session.clear();
        session.update(hotel);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Hotel.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Hotel ").getResultList();
        return list;
    }
}
