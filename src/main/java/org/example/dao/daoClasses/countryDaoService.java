package org.example.dao.daoClasses;

import org.example.dao.Dao;
import org.example.models.Country;
import org.example.models.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class countryDaoService implements Dao {
    @Autowired
    private SessionFactory factory;

    public void create(String country){
        Country country1 = new Country();
        country1.setCountry(country);
        factory.getCurrentSession().save(country1);
    }

    public Country read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Country.class, id);
    }

    public void update(String country, Long id){
        Session session = factory.getCurrentSession();
        Country country1 = session.get(Country.class, id);
        country1.setCountry(country);
        session.save(country1);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        Country country = session.get(Country.class, id);
        session.delete(country);
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Country> countries = session.createQuery("from Country ").getResultList();
        return countries;
    }
}
