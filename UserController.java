package org.jsp.userspringapp.controller;

import java.util.Scanner;

import org.jsp.userspringapp.UserConfig;
import org.jsp.userspringapp.dao.UserDao;
import org.jsp.userspringapp.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserController {

	static Scanner s = new Scanner(System.in);
	static UserDao uDao;
	static {
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		uDao=context.getBean(UserDao.class);
	}
	
	public static void main(String[] args) {
		System.out.println("1. Save the User");
		System.out.println("2. Update the User");
		System.out.println("3. Find User By Id");
		int choice = s.nextInt();
		switch(choice) {
		case 1:{
			save();
			break;
		}
		case 2:{
			update();
			break;
		}
		case 3:{
			findById();
			break;
		}
		}
	}

	public static void findById() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the value of Id");
		int id = s.nextInt();
		User u = uDao.findUserById(id);
		System.out.println(u.getName() +"  "+ u.getPhone());
		
	}

	public static void update() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the id to update phone and email ");
		int id = s.nextInt();
		long phone = s.nextLong();
		String email = s.next();
		User u = uDao.findUserById(id);
		if(u!=null) {
			u=uDao.updateUser(u);
		}
		
	}

	public static void save() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the name, phone, email & password");
		String name = s.next();
		long phone = s.nextLong();
		String email = s.next();
		String password = s.next();
	    User u = new User();
	    u.setEmail(email);
	    u.setName(name);
	    u.setPassword(password);
	    u.setPhone(phone);
	    u=uDao.saveUser(u);
	    System.out.println("User Saved with the Id :"+u.getId());
		
	}
}
