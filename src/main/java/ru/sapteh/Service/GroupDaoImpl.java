package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sapteh.Dao.Dao;
import ru.sapteh.model.Group;

import java.util.List;


public class GroupDaoImpl implements Dao<Group,Integer> {

    private final SessionFactory factory;
    private Object Group;

    public GroupDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Group findById(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Group.class,id);
        }
    }

    @Override
    public List<Group> findAll() {
        try(Session session = factory.openSession()) {
            return session.createQuery("from Group",Group.class).list();
        }
    }


    @Override
    public void update(Group group) {
        try (Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update(Group);
            transaction.commit();
        }

    }
    @Override
    public void delete(Group group) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update(Group);
            transaction.commit();
        }
    }



    @Override
    public void save (Group group) {
        try(Session session = factory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(Group);
            transaction.commit();
        }
    }


}