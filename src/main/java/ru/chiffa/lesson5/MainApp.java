package ru.chiffa.lesson5;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainApp {
    public static void main(String[] args) {
        try (SessionFactory factory = SessionFactoryProvider.sessionFactory()) {
            StudentDao studentDao = new StudentDao(factory);

            Transaction transaction = factory.getCurrentSession().beginTransaction();
            try {
                List<Student> list = IntStream.range(0, 1000)
                        .mapToObj(index -> new Student("name" + index, Math.random() * 5))
                        .collect(Collectors.toList());
                studentDao.saveOrUpdate(list);

                studentDao.saveOrUpdate(new Student("name", 1.0));

                studentDao.findById(1L);

                studentDao.findAll();

                studentDao.deleteById(1L);

                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }
}
