package org.example.dao.daoClasses;

import org.example.models.Category;
import org.example.models.Hotel_klass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class categoryDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(String category){
        Category category1 = new Category();
        category1.setCategory(category);
        factory.getCurrentSession().save(category1);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Category.class, id);
    }

    public void update(String category, Long id){
        Session session = factory.getCurrentSession();
        Category category1 = session.get(Category.class, id);
        category1.setCategory(category);
        session.clear();
        session.update(category1);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Category.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Category ").getResultList();
        return list;
    }
}
