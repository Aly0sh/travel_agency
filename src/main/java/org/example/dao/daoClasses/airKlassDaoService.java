package org.example.dao.daoClasses;

import org.example.models.Air_klass;
import org.example.models.Hotel_klass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class airKlassDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(String klass){
        Air_klass air_klass = new Air_klass();
        air_klass.setKlass(klass);
        factory.getCurrentSession().save(air_klass);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Air_klass.class, id);
    }

    public void update(String klass, Long id){
        Session session = factory.getCurrentSession();
        Air_klass air_klass = session.get(Air_klass.class, id);
        air_klass.setKlass(klass);
        session.clear();
        session.update(air_klass);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Air_klass.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Air_klass ").getResultList();
        return list;
    }
}
