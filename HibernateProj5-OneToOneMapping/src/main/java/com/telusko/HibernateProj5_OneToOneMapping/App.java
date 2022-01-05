package com.telusko.HibernateProj5_OneToOneMapping;

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
    	Student s1=new Student();
        Laptop l1=new Laptop();
        l1.setLid(18);
        l1.setLname("Dell");
        l1.setSt(s1);
       
       
        
        
        s1.setStid(1092);
        s1.setStname("jhonson");
        s1.setLaptop(l1);
     
        
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session ses=sf.openSession();
        Transaction tx=ses.beginTransaction();
        ses.save(l1);
        ses.save(s1);
        tx.commit();
    }
}
