package com.niit.shoppingcartbackend;




import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   CategoryDAO categoryDAO = 	(CategoryDAO) context.getBean("categoryDAO");
	   
	   Category category = 	(Category) context.getBean("category");
	   category.setId("CG130");
	   category.setName("CGName130");
	   category.setDescription("CGDesc130");
	   
	   
	   categoryDAO.saveOrUpdate(category);
	 
	  
	  
	  if(   categoryDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Category exist");
	  }
	  else
	  {
		  System.out.println("Category doesnot exist ..");
		  System.out.println();
	  }
		
		
		
	}

}

