package com.telusko.HibernateProj5_OneToOneMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laptop l1=new Laptop();
        l1.setLid(10122);
        l1.setLname("Dell");
        Laptop l2=new Laptop();
        l2.setLid(10222);
        l2.setLname("HP");
        
        List<Laptop> lap=new ArrayList<Laptop>();
        lap.add(l1);
        lap.add(l2);
        
        Student s1=new Student();
        s1.setStid(212);
        s1.setStname("rahul");
        s1.setLaptop(lap);
        
        Student s2=new Student();
        s2.setStid(222);
        s2.setStname("ram");
        s2.setLaptop(lap);
        
        List<Student> lst=new ArrayList<Student>();
        lst.add(s1);
        lst.add(s2);
        
        l1.setStuds(lst);
        l2.setStuds(lst);
        
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session ses=sf.openSession();
        Transaction tx=ses.beginTransaction();
        ses.save(l1);
        ses.save(l2); 
        ses.save(s1);
        ses.save(s2);
        tx.commit();
    }
}
