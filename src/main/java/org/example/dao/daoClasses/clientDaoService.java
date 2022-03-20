package org.example.dao.daoClasses;

import org.example.dao.Dao;
import org.example.models.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class clientDaoService implements Dao {
    @Autowired
    private SessionFactory factory;

    public void create(String name, String address, Integer client_number, Integer phone){
        Client client = new Client();
        client.setName(name);
        client.setAddress(address);
        client.setClient_number(client_number);
        client.setPhone(phone);
        factory.getCurrentSession().save(client);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Client.class, id);
    }

    public void update(String name, String address, Integer client_number, Integer phone, Long id){
        Session session = factory.getCurrentSession();
        Client client = session.get(Client.class, id);
        client.setName(name);
        client.setAddress(address);
        client.setClient_number(client_number);
        client.setPhone(phone);
        session.clear();
        session.update(client);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Client.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Client ").getResultList();
        return list;
    }
}
