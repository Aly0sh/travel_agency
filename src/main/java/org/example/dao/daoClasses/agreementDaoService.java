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
public class agreementDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Integer agreement_number, Date registration_date, Tour tour, Client client){
        Agreement agreement = new Agreement();
        agreement.setAgreement_number(agreement_number);
        agreement.setName(tour.getName());
        agreement.setAddress(client.getAddress()+"");
        agreement.setTour_number(tour.getTour_number());
        agreement.setRegistration_date(registration_date);
        agreement.setCountry(tour.getCountry().getCountry());
        agreement.setTour_type(tour.getTour_type().getTour_type());
        agreement.setStart_date(tour.getStart_date());
        agreement.setEnd_date(tour.getEnd_date());
        agreement.setProgram_number(tour.getProgram_number().getProgram_number());
        agreement.setTour(tour);
        agreement.setClient(client);
        factory.getCurrentSession().save(agreement);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Agreement.class, id);
    }

    public void update(Integer agreement_number, Date registration_date, Tour tour, Client client, Long id){
        Session session = factory.getCurrentSession();
        Agreement agreement = session.get(Agreement.class, id);
        agreement.setAgreement_number(agreement_number);
        agreement.setName(tour.getName());
        agreement.setAddress(client.getAddress()+"");
        agreement.setTour_number(tour.getTour_number());
        agreement.setRegistration_date(registration_date);
        agreement.setCountry(tour.getCountry().getCountry());
        agreement.setTour_type(tour.getTour_type().getTour_type());
        agreement.setStart_date(tour.getStart_date());
        agreement.setEnd_date(tour.getEnd_date());
        agreement.setProgram_number(tour.getProgram_number().getProgram_number());
        agreement.setTour(tour);
        agreement.setClient(client);
        session.clear();
        session.update(agreement);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Agreement.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Agreement ").getResultList();
        return list;
    }
}
