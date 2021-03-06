package HibernateProj12_HQL.HibernateProj12_HQL;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
    	Session ses=sf.openSession();
    	Transaction tx=ses.beginTransaction();
    	Employees emp=(Employees) ses.get(Employees.class,106);
    	System.out.println(emp);
//    	Random r=new Random();
//    	for(int i=1;i<=10;i++)
//    	{
//    		Employees e=new Employees();
//    		e.setEno(i);
//    		e.setEname("name"+ i);
//    		e.setEdept("dept"+ r.nextInt(100));
//    		ses.save(e);
//    	}
    	
    	//using hql
    	//for multiple rows fetching
    	Query q1=ses.createQuery("from Employees where eno>4");
    	List<Employees> emps=q1.list();
    	
    	for(Employees e:emps)
    	{
    		System.out.println(e);
    	}
    	
    	//for single row fetching
    	Query q2=ses.createQuery("from Employees where ename='name1'");
    	Employees e2 =(Employees) q2.uniqueResult();
    	System.out.println(e2);
    	
    	//for getting selected fileds of a table row
    	Query q3=ses.createQuery("select ename,edept from Employees where eno=10");
    	Object[] obj=(Object[]) q3.uniqueResult();
    	System.out.println(obj[0]+":::"+obj[1]);
    	
    	//for getting multiple rows of selected columns
    	Query q4=ses.createQuery("select ename,edept from Employees");
    	List<Object[]> empls =q4.list();
    	
    	for(Object[] e:empls)
    	{
    		System.out.println(e[0]+":::"+e[1]);
    	}
    	
    	Query qr=ses.createQuery("select eno,ename from Employees e where e.eno=10");
    	Object[] em=(Object[])qr.uniqueResult();
    	System.out.println(em[0]+":::"+em[1]);
    	
    	
    	int val=1;
    	Query q5=ses.createQuery("select sum(eno) from Employees e where e.eno> :val");
    	q5.setParameter("val", val);
    	long res=(long)q5.uniqueResult();
    	System.out.println(res);
//    	
    	//using sql query to get the results
    	System.out.println("============================================");
    	SQLQuery q6=ses.createSQLQuery("select * from employees where eno>5");

    	q6.addEntity(Employees.class);

    	List<Employees> empes=q6.list();
    	
    	for(Employees e:empes)
    	{
    		System.out.println(e);
    	}
    	
    	
    	System.out.println("============================================");
    	SQLQuery q7=ses.createSQLQuery("select eno,ename from employees where eno>9");
    	q7.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	List es=q7.list();
    	
    	for(Object o:es)
    	{
    		Map m=(Map)o;
    		System.out.println(m.get("eno")+":::::"+m.get("ename"));
    	}
    	
    	
    	tx.commit();
    	ses.close();
    }
}
