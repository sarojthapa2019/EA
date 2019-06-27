package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl  extends GenericDaoImpl<User> implements UserDao {

	{super.setDaoType(User.class);}

	public User findByEmail(String email) {
	     
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email =:email");
		return (User) query.setParameter("email", email).getSingleResult();
			     

	}

 }