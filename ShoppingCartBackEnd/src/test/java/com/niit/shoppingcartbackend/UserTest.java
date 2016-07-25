package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserTest {
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   UserDAO userDAO = 	(UserDAO) context.getBean("userDAO");
	   
	   User user = 	(User) context.getBean("user");
	   user.setId("US001");
	   user.setName("XYZ");
	   user.setPassword("00000");
	   user.setMobile("1234567890");
	   user.setMail("xyz@gmail.com");
	   user.setAddress("HYDERABAD");
	   
	   
	   userDAO.saveOrUpdate(user);
	 
	  
	  
	  if(   userDAO.get("sdfsf") ==null)
	  {
		  System.out.println("User exist");
	  }
	  else
	  {
		  System.out.println("User doesnot exist ..");
		  System.out.println();
	  }
		
		
		
	}

}





