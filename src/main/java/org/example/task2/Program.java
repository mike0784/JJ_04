package org.example.task2;

import org.example.models.Person;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class Program {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person per = new Person("Mike", 48);
            session.save(per);

            Person per1 = new Person("Ольга", 22);
            session.save(per1);

            Person per2 = new Person("Василий", 56);
            session.save(per2);


            System.out.println("Object per save successfully");

            Person obj1 = session.get(Person.class, per.getId());
            System.out.println("Object person retrieved successfully");
            System.out.println("Retrieved person object: " + obj1);

            obj1.setName("Nik");
            obj1.setAge(90);
            session.update(obj1);
            System.out.println("Object person update successfully");

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
