package org.example.services;

import org.example.models.Agreement;
import org.example.models.Category;
import org.example.models.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class categoryService extends Service{
    public categoryService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(String category){
        Session session = getSession();
        Category category1 = new Category();
        category1.setCategory(category);
        session.beginTransaction();
        session.save(category1);
        session.getTransaction().commit();
    }

    public Category read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Category category = session.get(Category.class, id);
        session.getTransaction().commit();
        return category;
    }

    public void update(String category, Long id){
        Session session = getSession();
        Category category1 = session.get(Category.class, id);
        category1.setCategory(category);
        session.beginTransaction();
        session.save(category1);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Category.class, id));
        session.getTransaction().commit();
    }
}
