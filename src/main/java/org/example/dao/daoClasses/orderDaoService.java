package org.example.dao.daoClasses;

import org.example.models.Employees;
import org.example.models.Order;
import org.example.models.Tour;
import org.example.models.Tour_tasks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class orderDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Integer orderNumber, Tour tour, Employees employees){
        Order order = new Order();
        order.setTour_number(tour.getTour_number());
        order.setPassport_id(employees.getPassport_id());
        order.setCountry(tour.getCountry().getCountry());
        order.setTour_type(tour.getTour_type().getTour_type());
        order.setStart_date(tour.getStart_date());
        order.setEnd_date(tour.getEnd_date());
        order.setProgram_number(tour.getProgram_number().getProgram_number());
        order.setOrder_number(orderNumber);
        order.setTour(tour);
        order.setEmployees(employees);
        factory.getCurrentSession().save(order);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Order.class, id);
    }

    public void update(Integer orderNumber, Tour tour, Employees employees, Long id){
        Session session = factory.getCurrentSession();
        Order order = session.get(Order.class, id);
        order.setTour_number(tour.getTour_number());
        order.setPassport_id(employees.getPassport_id());
        order.setCountry(tour.getCountry().getCountry());
        order.setTour_type(tour.getTour_type().getTour_type());
        order.setStart_date(tour.getStart_date());
        order.setEnd_date(tour.getEnd_date());
        order.setProgram_number(tour.getProgram_number().getProgram_number());
        order.setOrder_number(orderNumber);
        order.setTour(tour);
        order.setEmployees(employees);
        session.clear();
        session.update(order);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Order.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Order ").getResultList();
        return list;
    }
}
