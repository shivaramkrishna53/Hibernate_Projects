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
        //Laptops l=(Laptops)ses.get(Laptops.class,101);  //gets the actual object
       // Laptops l=(Laptops)ses.load(Laptops.class,101);   //gets the proxy object
        
//        Laptops l2=(Laptops)ses.get(Laptops.class,1003);  //returns null if no matching row found
//        System.out.println(l2);
        
        Laptops l3=(Laptops)ses.load(Laptops.class,1003);   // return exception(objectNotFoundException) if no row found
        System.out.println(l3);
        
    }
}
