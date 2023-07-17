package org.jsp.userspringapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jsp.userspringapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	EntityManager manager;
	
	public User saveUser(User user) {
		EntityTransaction t = manager.getTransaction();
		manager.persist(user);
		t.begin();
		t.commit();
		return user;
	}
	
	public User updateUser(User user) {
		EntityTransaction t = manager.getTransaction();
		manager.merge(user);
		t.begin();
		t.commit();
		return user;
	}
	
	public User findUserById(int id) {
		return manager.find(User.class, id);
	}
}
