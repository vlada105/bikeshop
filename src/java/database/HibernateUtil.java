/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Vlada
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry servis;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            Configuration config = new Configuration();
            config.configure("/xml/hibernate.cfg.xml");
            StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
            srb.applySettings(config.getProperties());
            servis = srb.build();
            sessionFactory = config.buildSessionFactory(servis);
        }
        return sessionFactory;
    }
}
