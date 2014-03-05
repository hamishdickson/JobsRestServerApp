package com.jhc.figleaf.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * User: DicksonH
 * Date: 04/03/14
 * Time: 12:06
 */
public class HibernateUtils {
    private static SessionFactory factory;

    public static void setUp() {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        HibernateUtils.factory = factory;
    }
}
