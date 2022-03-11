package org.example.services;

import org.example.models.Agreement;
import org.example.models.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class clientService extends Service{
    public clientService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(String name, String address, Integer client_number, Integer phone){
        Session session = getSession();
        Client client = new Client();
        client.setName(name);
        client.setAddress(address);
        client.setClient_number(client_number);
        client.setPhone(phone);
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
    }

    public Client read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.getTransaction().commit();
        return client;
    }

    public void update(String name, String address, Integer client_number, Integer phone, Agreement agreement, Long id){
        Session session = getSession();
        Client client = session.get(Client.class, id);
        client.setName(name);
        client.setAddress(address);
        client.setClient_number(client_number);
        client.setPhone(phone);
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Client.class, id));
        session.getTransaction().commit();
    }
}
