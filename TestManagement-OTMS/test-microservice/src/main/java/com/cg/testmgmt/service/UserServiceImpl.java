package com.cg.testmgmt.service;

import java.util.List;
import java.util.Optional;

import com.cg.testmgmt.dao.IUserDao;
import com.cg.testmgmt.entities.User;
import com.cg.testmgmt.exception.UserNotAddedException;
import com.cg.testmgmt.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	/*
	 ***************************************************
	 *This method is used to add new user
	 *************************************************** 
	 */

	@Override
	public User addUser(User user) {
		user = userDao.save(user);
			return user;
	
	}
	
	/*
	 ***************************************************
	 *This method is used to update existing test
	 *************************************************** 
	 */
	@Override
	public User updateUser(Long userId, User user) {
		boolean exists =userDao.existsById(userId);
		if (exists) {
			user = userDao.save(user);
			return user;
		}
		throw new UserNotFoundException("User not found for id="+userId);
	}
	
	/*
	 ***************************************************
	 *This method is used to find user by User Id
	 *************************************************** 
	 */

	@Override
	public User findById(Long userId) {
		Optional<User> optional = userDao.findById(userId);
		if (optional.isPresent()) {
			User user = optional.get();
			return user;
		}
		throw new UserNotFoundException("User not found for id=" + userId);
	}
	
	/*
	 ***************************************************
	 *This method is used to delete user
	 *************************************************** 
	 */

	@Override
	public User deleteUser(Long userId) {
		
		User user = findById(userId);
		userDao.delete(user);
		return user;
	}

	/*
	 ***************************************************
	 *This method is used to fetch all users
	 *************************************************** 
	 */
	
	@Override
	public List<User> fetchAll() {
		List<User> users=userDao.findAll();
		return users;
	}

}
