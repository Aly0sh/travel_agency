package org.example.services;

import org.example.models.Employees;
import org.example.models.Order;
import org.example.models.Tour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class orderService extends Service{
    public orderService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public void create(Integer orderNumber, Tour tour, Employees employees){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
    }

    public Order read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.getTransaction().commit();
        return order;
    }

    public void update(Integer orderNumber, Tour tour, Employees employees, Long id){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Order.class, id));
        session.getTransaction().commit();
    }
}
