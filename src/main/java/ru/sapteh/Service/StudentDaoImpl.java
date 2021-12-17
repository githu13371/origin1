package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.Student;

import java.util.List;


public class StudentDaoImpl implements Dao<Student,Integer> {

    private final SessionFactory factory;
    private Object Student;

    public StudentDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Student findById(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Student.class,id);
        }
    }

    @Override
    public List<Student> findAll() {
        try(Session session = factory.openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }


    @Override
    public void update(Student student) {
        try (Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update(Student);
            transaction.commit();
        }

    }
    @Override
    public void delete(Student student) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update(Student);
            transaction.commit();
        }
    }



    @Override
    public void save(Student student) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(Student);
            transaction.commit();
        }
    }


}
