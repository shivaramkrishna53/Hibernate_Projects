package com.telusko.HibernateProj1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class TestApp 
{
    public static void main( String[] args )
    {
        Employees emp1=new Employees();
        emp1.setEno(13232);
        emp1.setEname("sasdf");
        emp1.setEdept("softwares132");
        
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Employees.class);
        SessionFactory sesfac=cfg.buildSessionFactory();
        Session ses=sesfac.openSession();
        Transaction tx=ses.beginTransaction();
        ses.save(emp1);
        tx.commit();
        
    }
}
