package com.emilsharipov.spring.mvc_hibernate_aop.hibernate_one_to_many_uni;


import com.emilsharipov.spring.mvc_hibernate_aop.hibernate_one_to_many_uni.entity.Department;
import com.emilsharipov.spring.mvc_hibernate_aop.hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

//            Department dep = new Department("HR", 300, 1200);
//            Employee emp1 = new Employee("Artem", "Petrov", 800);
//            Employee emp2 = new Employee("Sergey", "Smirnov", 1000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
            session = factory.getCurrentSession();

            session.beginTransaction();

            session.delete(session.get(Department.class, 1));

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }




    }
}
