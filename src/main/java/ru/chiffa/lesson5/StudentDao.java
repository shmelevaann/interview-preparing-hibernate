package ru.chiffa.lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDao {
    private final SessionFactory factory;

    public StudentDao(SessionFactory factory) {
        this.factory = factory;
    }

    public Student findById(Long id) {
        Session session = factory.getCurrentSession();
        return session.get(Student.class, id);
    }

    public List<Student> findAll() {
        Session session = factory.getCurrentSession();
        return session.createQuery("from Student", Student.class).getResultList();

    }

    public void deleteById(Long id) {
        Session session = factory.getCurrentSession();
        session.remove(session.get(Student.class, id));
    }

    public void saveOrUpdate(Student student) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(student);
    }

    public void saveOrUpdate(List<Student> list) {
        Session session = factory.getCurrentSession();
        for (Student student : list) {
            session.saveOrUpdate(student);
        }
    }
}


