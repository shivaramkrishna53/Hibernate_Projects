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
        
        
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Employees.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session ses1=sf.openSession();
        Transaction tx=ses1.beginTransaction();
        Employees e1=(Employees)ses1.get(Employees.class, 13232);
        System.out.println(e1);
        tx.commit();
        ses1.close();
        Session ses2=sf.openSession();
        Employees e2=(Employees)ses2.get(Employees.class,13232);
        System.out.println(e2);
       
    }
}
