package org.example.dao.daoClasses;

import org.example.dao.Dao;
import org.example.models.Position;
import org.example.services.positionService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class positionDaoService implements Dao {
    @Autowired
    private SessionFactory factory;

    public void create(String position){
        Position position1 = new Position();
        position1.setPosition(position);
        factory.getCurrentSession().save(position1);
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

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Position> positions = session.createQuery("from Position ").getResultList();
        return positions;
    }
}
