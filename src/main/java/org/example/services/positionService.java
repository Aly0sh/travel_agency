package org.example.services;

import org.example.models.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class positionService extends Service{
    private final SessionFactory factory = getFactory();
    private Position position;


    public positionService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(String position){
        this.position = new Position();
        this.position.setPosition(position);
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(this.position);
        session.getTransaction().commit();
    }

    public Position read(Long id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Position position1 = session.get(Position.class, id);
        session.getTransaction().commit();
        return position1;
    }

    public void update(String position, Long id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Position position1 = session.get(Position.class, id);
        position1.setPosition(position);
        session.save(position1);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Position position1 = session.get(Position.class, id);
        session.delete(position1);
        session.getTransaction().commit();
    }


}
