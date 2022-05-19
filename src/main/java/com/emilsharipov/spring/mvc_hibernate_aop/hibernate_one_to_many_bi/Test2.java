package com.emilsharipov.spring.mvc_hibernate_aop.hibernate_one_to_many_bi;



import com.emilsharipov.spring.mvc_hibernate_aop.hibernate_one_to_many_bi.entity.Department;
import com.emilsharipov.spring.mvc_hibernate_aop.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

//            Department dep = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);


            session = factory.getCurrentSession();
            session.beginTransaction();

//            Department dep = session.get(Department.class, 8);
//
//            System.out.println(dep.getEmps());
//
//
//            session.persist(dep);
//            session.delete(dep);

            Department dep = session.get(Department.class, 9);


            System.out.println("dep");
            System.out.println(dep);

            System.out.println("emps");
            System.out.println(dep.getEmps());

            session.getTransaction().commit();


        }
        finally {
            session.close();
            factory.close();
        }




    }
}
