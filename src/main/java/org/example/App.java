package org.example;

import org.example.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(position.class)
                .addAnnotatedClass(employees.class)
                .addAnnotatedClass(tour_type.class)
                .addAnnotatedClass(program.class)
                .addAnnotatedClass(country.class)
                .addAnnotatedClass(tour.class)
                .addAnnotatedClass(tour_tasks.class)
                .addAnnotatedClass(order.class)
                .addAnnotatedClass(client.class)
                .addAnnotatedClass(agreement.class)
                .addAnnotatedClass(tourist.class)
                .addAnnotatedClass(trip.class)
                .addAnnotatedClass(events.class)
                .addAnnotatedClass(event_tickets.class)
                .addAnnotatedClass(trips_tickets.class)
                .addAnnotatedClass(hotel_klass.class)
                .addAnnotatedClass(hotel.class)
                .addAnnotatedClass(category.class)
                .addAnnotatedClass(rooms.class)
                .addAnnotatedClass(trips_numbers.class)
                .addAnnotatedClass(tour_flights.class)
                .addAnnotatedClass(air_klass.class)
                .addAnnotatedClass(air_tickets.class)
                .addAnnotatedClass(air_tickets_trips.class)
                .buildSessionFactory();

        try{
            Long l = Long.valueOf(2);
            Session session = factory.getCurrentSession();
            position position = new position();
            position.setPosition("Manager");
            employees employees = new employees();
            employees.setName("Kubatbekov Alaken");
            employees.setPosition(position);
            employees.setPassport_id(1);
            employees.setAddress("Matrosova 69");
            session.beginTransaction();
            session.save(position);
            session.save(employees);
            employees employee = session.get(employees.class, l);
            System.out.println(employee.getId()+"\t"+employee.getName()+"\t"+employee.getAddress()+"\t"+employee.getPosition().getPosition());
            employee.setName("Chandaev Bekjan");
            session.save(employee);
            employees employee2 = session.get(employees.class, l);
            System.out.println(employee2.getId()+"\t"+employee2.getName()+"\t"+employee2.getAddress()+"\t"+employee2.getPosition().getPosition());
            session.delete(employee2);
            employees employee3 = session.get(employees.class, l);
            System.out.println(employee3);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
