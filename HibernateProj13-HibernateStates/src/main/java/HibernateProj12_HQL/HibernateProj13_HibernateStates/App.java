package HibernateProj12_HQL.HibernateProj13_HibernateStates;

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
    	Configuration cf=new Configuration().configure().addAnnotatedClass(Laptops.class);
    	SessionFactory sesfac=cf.buildSessionFactory();
        Session ses=sesfac.openSession();
        Transaction tr=ses.beginTransaction();
        Laptops l=new Laptops();  //new obj creation state
        l.setLid(101);            //transient state
        l.setLname("Dell");		  //transient state
        l.setLprice(60000);       //transient state
        ses.save(l);              //persistent state
        l.setLprice(50000);
        Laptops la=(Laptops)ses.get(Laptops.class,101);
        la.setLname("Apple");
        
        tr.commit();
        ses.delete(l);
        
        
    }
}
