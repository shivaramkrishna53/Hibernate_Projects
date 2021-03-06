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
public class App {
	public static void main(String[] args) {
		Laptop l1 = new Laptop();
		l1.setLid(1013);
		l1.setLname("Dell");
		Laptop l2 = new Laptop();
		l2.setLid(1022);
		l2.setLname("HP");
		Laptop l3 = new Laptop();
		l3.setLid(1034);
		l3.setLname("Lenovo");
		Laptop l4 = new Laptop();
		l4.setLid(1042);
		l4.setLname("Acer");
		Laptop l5 = new Laptop();
		l5.setLid(1053);
		l5.setLname("Sony");

		List<Laptop> laplst1 = new ArrayList<Laptop>();
		laplst1.add(l1);
		laplst1.add(l2);

		List<Laptop> laplst2 = new ArrayList<Laptop>();

		laplst2.add(l3);
		laplst2.add(l4);
		laplst2.add(l5);

		Student s1 = new Student();
		s1.setStid(12);
		s1.setStname("rahul");
		s1.setLaptop(laplst1);

		Student s2 = new Student();
		s2.setStid(22);
		s2.setStname("raju");
		s2.setLaptop(laplst2);

		
		 l1.setStud(s1);
		 l2.setStud(s1);
		 l3.setStud(s2);
		 l4.setStud(s2);
		 l5.setStud(s2);
		 
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		ses.save(l1);
		ses.save(l2);
		ses.save(l3);
		ses.save(l4);
		ses.save(l5);

		ses.save(s1);
		ses.save(s2);
		tx.commit();
	}
}
