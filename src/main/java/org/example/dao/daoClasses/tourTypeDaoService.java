package org.example.dao.daoClasses;

import org.example.dao.Dao;
import org.example.models.Country;
import org.example.models.Position;
import org.example.models.Tour_type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class tourTypeDaoService implements Dao {
    @Autowired
    private SessionFactory factory;

    public void create(String tourType){
        Tour_type tour_type = new Tour_type();
        tour_type.setTour_type(tourType);
        factory.getCurrentSession().save(tour_type);
    }

    public Tour_type read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Tour_type.class, id);
    }

    public void update(String tourType, Long id){
        Session session = factory.getCurrentSession();
        Tour_type tour_type = session.get(Tour_type.class, id);
        tour_type.setTour_type(tourType);
        session.save(tour_type);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Tour_type.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Tour_type ").getResultList();
        return list;
    }
}
