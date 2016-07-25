package com.niit.shoppingcartbackend;




import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTest {
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   SupplierDAO supplierDAO = 	(SupplierDAO) context.getBean("supplierDAO");
	   
	   Supplier supplier = 	(Supplier) context.getBean("supplier");
	   supplier.setId("SUP001");
	   supplier.setName("BAJAJ");
	   supplier.setAddress("HYDERABAD");
	   
	   
	   supplierDAO.saveOrUpdate(supplier);
	 
	  
	  
	  if(   supplierDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Supplier exist");
	  }
	  else
	  {
		  System.out.println("Supplier doesnot exist ..");
		  System.out.println();
	  }
		
		
		
	}

}


