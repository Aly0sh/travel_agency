package org.example.services;

import org.example.models.Employees;
import org.example.models.Tour;
import org.example.models.Tour_tasks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class tourTasksService extends Service{
    public tourTasksService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Integer task_number, String description, Date deadline, Tour tour, Employees employees){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(tour_tasks);
        session.getTransaction().commit();
    }

    public Tour_tasks read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Tour_tasks tour_tasks = session.get(Tour_tasks.class, id);
        session.getTransaction().commit();
        return tour_tasks;
    }

    public void update(Integer task_number, String description, Date deadline, Tour tour, Employees employees, Long id){
        Session session = getSession();
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
        session.beginTransaction();
        session.save(tour_tasks);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Tour_tasks.class, id));
        session.getTransaction().commit();
    }
}
