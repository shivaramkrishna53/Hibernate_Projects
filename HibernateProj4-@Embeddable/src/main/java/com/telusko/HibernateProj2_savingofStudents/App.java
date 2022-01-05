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

    	FullName f1=new FullName();
    	f1.setFname("durgi");
    	f1.setMname("shiva ram");
    	f1.setLname("krishna");
    	
    	Student s1=new Student();
    	s1.setAge(12);
    	s1.setId(1092);
    	s1.setStudentname(f1);
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sesfac=con.buildSessionFactory();
        Session ses=sesfac.openSession();
        Transaction tx=ses.beginTransaction();
        ses.save(s1);
        tx.commit();
       
    }
}
