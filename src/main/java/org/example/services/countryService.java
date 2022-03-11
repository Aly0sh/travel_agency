package org.example.services;

import org.example.models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class countryService extends Service{
    private Country country;

    public countryService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(String country){
        Session session = getSession();
        this.country = new Country();
        this.country.setCountry(country);
        session.beginTransaction();
        session.save(this.country);
        session.getTransaction().commit();
    }

    public Country read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Country country1 = session.get(Country.class, id);
        session.getTransaction().commit();
        return country1;
    }

    public void update(String country, Long id){
        Session session = getSession();
        session.beginTransaction();
        Country country1 = session.get(Country.class, id);
        session.save(country1);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        Country country1 = session.get(Country.class, id);
        session.delete(country1);
        session.getTransaction().commit();
    }


}
