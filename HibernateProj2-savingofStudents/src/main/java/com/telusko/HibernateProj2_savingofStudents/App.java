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
        Student st1=new Student();
        st1.setId(119);
        st1.setName("raju");
        st1.setAge(12);
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sesfac=con.buildSessionFactory();
        Session ses=sesfac.openSession();
        Transaction tx=ses.beginTransaction();
        ses.save(st1);
        tx.commit();
    }
}
