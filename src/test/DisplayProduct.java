package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class DisplayProduct {

	public static void main(String[] args) {
		
		Configuration cfg= null;
		Session ses= null;
		SessionFactory fact= null;
		Transaction tx=null;
		
		cfg= new Configuration();
		cfg=cfg.configure("cfg/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		
		fact =cfg.buildSessionFactory();
		
		ses=fact.openSession();
		
	    tx=ses.beginTransaction();
	    
	    Query q= ses.createQuery("select p from Product p");
		
		List<Product> productList= q.list();
		
		System.out.println("Product ID\t\tProduct Name\t\tProduct Price");
		System.out.println("----------------------------------------------------");
		for(Product p: productList){
			
			System.out.println(p.getProductId()+"\t\t\t"+p.getProductName()+"\t\t\t"+p.getProductPrice());
		}
		
	}
	
}
