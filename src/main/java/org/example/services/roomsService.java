package org.example.services;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class roomsService extends Service{
    public roomsService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Date arrival_date, Date departure_date, Integer place, Hotel hotel, Category category){
        Session session = getSession();
        Rooms rooms = new Rooms();
        rooms.setCity(hotel.getCity());
        rooms.setName(hotel.getName());
        rooms.setArrival_date(arrival_date);
        rooms.setCategory(category.getCategory());
        rooms.setPlace(place);
        rooms.setDeparture_date(departure_date);
        rooms.setRoom_category(category);
        rooms.setHotel(hotel);
        session.beginTransaction();
        session.save(rooms);
        session.getTransaction().commit();
    }

    public Rooms read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Rooms rooms = session.get(Rooms.class, id);
        session.getTransaction().commit();
        return rooms;
    }

    public void update(Date arrival_date, Date departure_date, Integer place, Hotel hotel, Category category, Long id){
        Session session = getSession();
        Rooms rooms = session.get(Rooms.class, id);
        rooms.setCity(hotel.getCity());
        rooms.setName(hotel.getName());
        rooms.setArrival_date(arrival_date);
        rooms.setCategory(category.getCategory());
        rooms.setPlace(place);
        rooms.setDeparture_date(departure_date);
        rooms.setRoom_category(category);
        rooms.setHotel(hotel);
        session.beginTransaction();
        session.save(rooms);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Rooms.class, id));
        session.getTransaction().commit();
    }
}
