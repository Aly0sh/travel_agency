package org.example.dao.daoClasses;

import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class roomsDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Date arrival_date, Date departure_date, Integer place, Hotel hotel, Category category){
        Rooms rooms = new Rooms();
        rooms.setCity(hotel.getCity());
        rooms.setName(hotel.getName());
        rooms.setArrival_date(arrival_date);
        rooms.setCategory(category.getCategory());
        rooms.setPlace(place);
        rooms.setDeparture_date(departure_date);
        rooms.setRoom_category(category);
        rooms.setHotel(hotel);
        factory.getCurrentSession().save(rooms);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Rooms.class, id);
    }

    public void update(Date arrival_date, Date departure_date, Integer place, Hotel hotel, Category category, Long id){
        Session session = factory.getCurrentSession();
        Rooms rooms = session.get(Rooms.class, id);
        rooms.setCity(hotel.getCity());
        rooms.setName(hotel.getName());
        rooms.setArrival_date(arrival_date);
        rooms.setCategory(category.getCategory());
        rooms.setPlace(place);
        rooms.setDeparture_date(departure_date);
        rooms.setRoom_category(category);
        rooms.setHotel(hotel);
        session.clear();
        session.update(rooms);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Rooms.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Rooms ").getResultList();
        return list;
    }
}
