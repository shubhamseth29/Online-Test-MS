package com.cg.testmgmt.service;

import com.cg.testmgmt.entities.User;


public interface IUserService {
	User addUser(User user);

	User findById(Long userId);
}
