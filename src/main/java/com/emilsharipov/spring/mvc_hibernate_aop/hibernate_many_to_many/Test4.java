package com.emilsharipov.spring.mvc_hibernate_aop.hibernate_many_to_many;


import com.emilsharipov.spring.mvc_hibernate_aop.hibernate_many_to_many.entity.Child;
import com.emilsharipov.spring.mvc_hibernate_aop.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {


            session = factory.getCurrentSession();

            Section section = new Section("Football");

//            Child child1 = new Child("Vasya", 5);
//            Child child2 = new Child("Ira", 10);
//            Child child3 = new Child("Semen", 8);
//
//            section.addChildToSection(child1);
//            section.addChildToSection(child2);
//            section.addChildToSection(child3);

            session.beginTransaction();

            Child child = session.get(Child.class, 4);

            child.removeSectionToChild(session.get(Section.class, 3));

            session.getTransaction().commit();


        }
        finally {
            session.close();
            factory.close();
        }

    }


}
