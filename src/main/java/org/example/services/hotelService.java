package org.example.services;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class hotelService extends Service{
    public hotelService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(String city, String name, Tour tour, Hotel_klass hotel_klass){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
    }

    public Hotel read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Hotel hotel = session.get(Hotel.class, id);
        session.getTransaction().commit();
        return hotel;
    }

    public void update(String city, String name, Tour tour, Hotel_klass hotel_klass, Long id){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Hotel.class, id));
        session.getTransaction().commit();
    }
}
