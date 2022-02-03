package ru.chiffa.lesson5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    public static SessionFactory sessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

}
