package org.example.dao.daoClasses;

import org.example.models.Program;
import org.example.models.Tour_type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class programDaoService {
    @Autowired
    private SessionFactory factory;

    public void create(Integer program_number, String description){
        Program program = new Program();
        program.setProgram_number(program_number);
        program.setDescription(description);
        factory.getCurrentSession().save(program);
    }

    public Object read(Long id){
        Session session = factory.getCurrentSession();
        return session.get(Program.class, id);
    }

    public void update(Integer program_number, String description, Long id){
        Session session = factory.getCurrentSession();
        Program program = session.get(Program.class, id);
        program.setDescription(description);
        program.setProgram_number(program_number);
        session.save(program);
    }

    public void delete(Long id){
        Session session = factory.getCurrentSession();
        session.delete(session.get(Program.class, id));
    }

    public List getAll() {
        Session session = factory.getCurrentSession();
        List<Object> list = session.createQuery("from Program ").getResultList();
        return list;
    }
}
