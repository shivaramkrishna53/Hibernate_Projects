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
        
        
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session ses=sf.openSession();
        Transaction tx=ses.beginTransaction();
        Student st=(Student)ses.get(Student.class,2);
//        System.out.println(st.getStid());
//        System.out.println(st.getStname());
        
		
//		  List<Laptop> lst=st.getLaptop(); 
//		  for(Laptop l:lst) 
//		  System.out.println(l);
		         
        tx.commit();
    }
}
