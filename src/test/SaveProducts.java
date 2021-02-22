package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class SaveProducts {
	
	
	public static void main(String[] args) {
		
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Enter The Id");
		int id=sc1.nextInt();
				System.out.println("Enter The Product name");
		   String name=sc1.next();
		   System.out.println("Enter The Peice");
		   double price= sc1.nextDouble();
		   
		Configuration cfg=null;
		Session ses= null;
		SessionFactory fact= null;
		Transaction tx= null;
		
		
		cfg= new Configuration();
		cfg=cfg.configure("cfg/hibernate.cfg.xml");
		
		cfg=cfg.addAnnotatedClass(Product.class);
		
		fact=cfg.buildSessionFactory();
		
		ses=fact.openSession();
		
		Product p1 = new Product();
		
		p1.setProductId(id);
		p1.setProductName(name);
		p1.setProductPrice(price);
		
		
		
		
		tx=ses.beginTransaction();
		
		ses.save(p1);
		
		tx.commit();
		
		
		System.out.println("Recoed Inserted ");
		
		
		
		
	}

}
