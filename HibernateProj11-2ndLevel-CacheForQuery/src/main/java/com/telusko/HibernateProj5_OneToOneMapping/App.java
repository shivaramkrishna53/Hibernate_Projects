package com.telusko.HibernateProj5_OneToOneMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
        
        
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Employees.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session ses1=sf.openSession();
        Transaction tx=ses1.beginTransaction();
        Query q1=ses1.createQuery("from Employees where eno=13232");
        q1.setCacheable(true);
        Employees e1=(Employees)q1.uniqueResult();
        System.out.println(e1);
        
        tx.commit();
        ses1.close();
        
        Session ses2=sf.openSession();
        Transaction tx2=ses2.beginTransaction();
        Query q2=ses2.createQuery("from Employees where eno=13232");
        q2.setCacheable(true);
       Employees e2=(Employees)q2.uniqueResult();
        System.out.println(e2);
        
        tx2.commit();
        ses2.close();
        
       
    }
}
