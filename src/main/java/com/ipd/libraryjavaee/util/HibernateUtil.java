package com.ipd.libraryjavaee.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ipd.libraryjavaee.entities.AppRole;
import com.ipd.libraryjavaee.entities.AppUser;
import com.ipd.libraryjavaee.entities.Commentaire;
import com.ipd.libraryjavaee.entities.Membre;
import com.ipd.libraryjavaee.entities.Ouvrage;
import com.ipd.libraryjavaee.entities.Reservation;
import com.ipd.libraryjavaee.entities.Salle;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySetting("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                .applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/libraryjavaee")
                .applySetting("hibernate.connection.username", "root")
                .applySetting("hibernate.connection.password", "")
                .applySetting("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                .applySetting("hibernate.show_sql", "true")
                .applySetting("hibernate.hbm2ddl.auto", "update") // Use `update` for development
                .build();

            sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(AppUser.class)
                .addAnnotatedClass(AppRole.class)
                .addAnnotatedClass(Commentaire.class)
                .addAnnotatedClass(Membre.class)
                .addAnnotatedClass(Ouvrage.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(Salle.class)                
                .buildMetadata()
                .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed.");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
