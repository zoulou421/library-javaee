package com.ipd.libraryjavaee.util;

import org.hibernate.Session;
import com.ipd.libraryjavaee.entities.AppRole;
import com.ipd.libraryjavaee.entities.AppUser;

public class HibernateTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            // Create a new role
            AppRole role = new AppRole();
            role.setNom("ROLE_USER");

            // Create a new user
            AppUser user = new AppUser();
            user.setUserName("testuser");
            user.setPassword("password123");
            user.getRoles().add(role);

            // Save the user (role is cascaded)
            session.save(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
