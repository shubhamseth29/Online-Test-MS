package com.cg.testmgmt.service;

import java.util.Optional;

import com.cg.testmgmt.dao.IUserDao;
import com.cg.testmgmt.entities.User;
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

	@Override
	public User addUser(User user) {
		user = userDao.save(user);
		return user;
	}
	
	@Override
	public User updateUser(Long userId, User user) {
		boolean exists =userDao.existsById(userId);
		if (exists) {
			user = userDao.save(user);
			return user;
		}
		throw new UserNotFoundException("User not found for id="+userId);
	}


	@Override
	public User findById(Long userId) {
		Optional<User> optional = userDao.findById(userId);
		if (optional.isPresent()) {
			User user = optional.get();
			return user;
		}
		throw new UserNotFoundException("User not found for id=" + userId);
	}

	@Override
	public User deleteUser(Long userId) {
		
		User test = findById(userId);
		userDao.delete(test);
		return test;
		
	}

}
