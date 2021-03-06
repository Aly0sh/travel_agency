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
        getSession().save(this.position);
    }

    public Position read(Long id){
        Session session = factory.getCurrentSession();
        Position position1 = session.get(Position.class, id);
        return position1;
    }

    public void update(String position, Long id){
        Session session = factory.getCurrentSession();
        Position position1 = session.get(Position.class, id);
        position1.setPosition(position);
        session.save(position1);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        Position position1 = session.get(Position.class, id);
        session.delete(position1);
    }


}
