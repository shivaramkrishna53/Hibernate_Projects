package com.telusko.HibernateProj2_savingofStudents;

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

        
        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sesfac=con.buildSessionFactory();
        Session ses=sesfac.openSession();
        Transaction tx=ses.beginTransaction();
        Student st1=(Student)ses.get(Student.class,119);
        tx.commit();
        System.out.println(st1);
    }
}
