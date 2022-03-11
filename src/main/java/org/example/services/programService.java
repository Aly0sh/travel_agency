package org.example.services;

import org.example.models.Program;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class programService extends Service{

    public programService(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public void create(Integer number, String description){
        Session session = getSession();
        Program program1 = new Program();
        program1.setProgram_number(number);
        program1.setDescription(description);
        session.beginTransaction();
        session.save(program1);
        session.getTransaction().commit();
    }

    public Program read(Long id){
        Session session = getSession();
        session.beginTransaction();
        Program program = session.get(Program.class, id);
        session.getTransaction().commit();
        return program;
    }

    public void update(Integer number, String description, Long id){
        Session session = getSession();
        session.beginTransaction();
        Program program = session.get(Program.class, id);
        program.setProgram_number(number);
        program.setDescription(description);
        session.save(program);
        session.getTransaction().commit();
    }

    public void delete(Long id){
        Session session = getSession();
        session.beginTransaction();
        session.delete(session.get(Program.class, id));
        session.getTransaction().commit();
    }
}
