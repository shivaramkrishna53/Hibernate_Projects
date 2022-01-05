package com.jpa.demo.JpaDemoProj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("");
        EntityManager em=emf.createEntityManager();
        Laptops l1=em.find(Laptops.class, 101);
        System.out.println(l1);
    }
}
