package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class Update {
	
	
	public static void main(String[] args) {
		
		
		Configuration cfg= null;
		Session ses=null;
		SessionFactory fact= null;
		Transaction tx= null;
		
		cfg= new Configuration();
		cfg=cfg.configure("cfg/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		
		
		fact=cfg.buildSessionFactory();
		
		ses=fact.openSession();
		
		tx=ses.beginTransaction();
		
		Query q=ses.createQuery("update Product p set p.productPrice=9999.99 where p.productId=3");
		
		int count =q.executeUpdate();
		
		tx.commit();
		
		System.out.println(count+" Record Updated");
		
	}

}
