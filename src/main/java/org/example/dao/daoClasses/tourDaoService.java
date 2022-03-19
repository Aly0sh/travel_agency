package org.example.dao.daoClasses;

import org.example.dao.Dao;
import org.example.models.Country;
import org.example.models.Program;
import org.example.models.Tour;
import org.example.models.Tour_type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Transactional
@Repository
public class tourDaoService implements Dao {
    @Autowired
    private SessionFactory factory;


    public void create(Integer tour_number,
                       Tour_type tour_type,
                       Country country,
                       Date start_date,
                       Date end_date,
                       Program program_number,
                       String name,
                       String status
                       ){
        Tour tour = new Tour();
        tour.setTour_number(tour_number);
        tour.setTour_type(tour_type);
        tour.setCountry(country);
        tour.setStart_date(start_date);
        tour.setEnd_date(end_date);
        tour.setProgram_number(program_number);
        tour.setName(name);
        tour.setStatus(status);
        factory.getCurrentSession().save(tour);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Tour.class, id);
    }

    public void update(Integer tour_number,
                       Tour_type tour_type,
                       Country country,
                       Date start_date,
                       Date end_date,
                       Program program_number,
                       String name,
                       String status,
                       Long id){
        Session session = factory.getCurrentSession();
        Tour tour = session.get(Tour.class, id);
        tour.setTour_number(tour_number);
        tour.setTour_type(tour_type);
        tour.setCountry(country);
        tour.setStart_date(start_date);
        tour.setEnd_date(end_date);
        tour.setProgram_number(program_number);
        tour.setName(name);
        tour.setStatus(status);
        session.clear();
        session.update(tour);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Tour.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Tour ").getResultList();
        return list;
    }
}
