package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {
	
	
	
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   ProductDAO productDAO = 	(ProductDAO) context.getBean("productDAO");
	   
	   Product product = 	(Product) context.getBean("product");
	   product.setId("PR001");
	   product.setName("MOTOROLA");
	   product.setDescription("MOBILE");
	   product.setPrice("20000");
	   
	   productDAO.saveOrUpdate(product);
	 
	  
	  
	  if(   productDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Product exist");
	  }
	  else
	  {
		  System.out.println("Product doesnot exist ..");
		  System.out.println();
	  }
		
		
		
	}

}





