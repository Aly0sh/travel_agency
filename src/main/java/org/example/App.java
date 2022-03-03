package org.example;

import org.example.entities.*;
import org.example.services.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Position.class)
                .addAnnotatedClass(Employees.class)
                .addAnnotatedClass(Tour_type.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(Tour.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Agreement.class)
                .addAnnotatedClass(Tourist.class)
                .addAnnotatedClass(Trip.class)
                .addAnnotatedClass(Events.class)
                .addAnnotatedClass(Event_tickets.class)
                .addAnnotatedClass(Trips_tickets.class)
                .addAnnotatedClass(Hotel_klass.class)
                .addAnnotatedClass(Hotel.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Rooms.class)
                .addAnnotatedClass(Trips_numbers.class)
                .addAnnotatedClass(Tour_flights.class)
                .addAnnotatedClass(Air_klass.class)
                .addAnnotatedClass(Air_tickets.class)
                .addAnnotatedClass(Air_tickets_trips.class)
                .addAnnotatedClass(Tour_tasks.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        positionService positionService = new positionService(factory);
        positionService.create("Заместитель директора");
        positionService.create("Составитель туров");
        positionService.create("Тур менеджер");
        positionService.create("Менеджер по турникам");
        positionService.update("Менеджер по продажам", 4L);
        positionService.create("Salo");
        positionService.delete(5L);
        countryService countryService = new countryService(factory);
        countryService.create("Киргизия");
        countryService.create("Россия");
        countryService.create("Казахстан");
        countryService.create("Украина");
        countryService.update("Монголия", 9L);
        countryService.create("Америка");
        countryService.delete(10L);
        tourTypeService tourTypeService = new tourTypeService(factory);
        tourTypeService.create("Горный");
        tourTypeService.create("Лесной");
        tourTypeService.create("Город");
        tourTypeService.update("Городской", 13L);
        tourTypeService.create("Дикий");
        tourTypeService.delete(14L);
        programService programService = new programService(factory);
        programService.create(1, "Программа включает в себя развлечения, шашлыки и дискотеку");
        programService.create(2, "Программа включает в себя семейный поход на свежей природе");
        programService.create(3, "Программа включает в себя курс по выживанию в диких условиях");
        programService.create(4, "Программа пока не придумана");
        programService.update(4, "Программа включает в себя поездку по достопремечательностям", 18L);
        programService.create(5, "Программа ни о чем");
        programService.delete(19L);
        factory.close();
    }
}
