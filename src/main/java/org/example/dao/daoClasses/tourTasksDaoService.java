package org.example.dao.daoClasses;

import org.example.dao.Dao;
import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Transactional
@Repository
public class tourTasksDaoService implements Dao {
    @Autowired
    private SessionFactory factory;

    public void create(Integer task_number, String description, Date deadline, Tour tour, Employees employees){
        Tour_tasks tour_tasks = new Tour_tasks();
        tour_tasks.setTask_number(task_number);
        tour_tasks.setDescription(description);
        tour_tasks.setDeadline(deadline);
        tour_tasks.setTour(tour);
        tour_tasks.setEmployees(employees);
        tour_tasks.setPassport_id(employees.getPassport_id());
        tour_tasks.setTour_number(tour.getTour_number());
        tour_tasks.setStart_date(tour.getStart_date());
        tour_tasks.setEnd_date(tour.getEnd_date());
        tour_tasks.setProgram_number(tour.getProgram_number().getProgram_number());
        tour_tasks.setStatus(tour.getStatus());
        factory.getCurrentSession().save(tour_tasks);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Tour_tasks.class, id);
    }

    public void update(Integer task_number, String description, Date deadline, Tour tour, Employees employees, Long id){
        Session session = factory.getCurrentSession();
        Tour_tasks tour_tasks = session.get(Tour_tasks.class, id);
        tour_tasks.setTask_number(task_number);
        tour_tasks.setDescription(description);
        tour_tasks.setDeadline(deadline);
        tour_tasks.setTour(tour);
        tour_tasks.setEmployees(employees);
        tour_tasks.setPassport_id(employees.getPassport_id());
        tour_tasks.setTour_number(tour.getTour_number());
        tour_tasks.setStart_date(tour.getStart_date());
        tour_tasks.setEnd_date(tour.getEnd_date());
        tour_tasks.setProgram_number(tour.getProgram_number().getProgram_number());
        tour_tasks.setStatus(tour.getStatus());
        session.clear();
        session.update(tour_tasks);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Tour_tasks.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Tour_tasks ").getResultList();
        return list;
    }
}
