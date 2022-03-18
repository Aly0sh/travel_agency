package org.example.services;

import org.example.models.Agreement;
import org.example.models.Client;
import org.example.models.Tour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class agreementService extends Service{

    public agreementService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Integer agreement_number, Date registration_date, Tour tour, Client client){
        Session session = getSession();
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
        session.save(agreement);
    }

    public Agreement read(Long id){
        Session session = getSession();
        Agreement agreement = session.get(Agreement.class, id);
        return agreement;
    }

    public void update(Integer agreement_number, Date registration_date, Tour tour, Client client, Long id){
        Session session = getSession();
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
        session.save(agreement);
    }

    public void delete(Long id){
        Session session = getSession();
        session.delete(session.get(Agreement.class, id));
    }
}
