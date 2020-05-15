package com.cg.testmgmt.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.cg.testmgmt.dao.ITestDao;
import com.cg.testmgmt.entities.Test;
import com.cg.testmgmt.exception.TestNotAddedException;
import com.cg.testmgmt.exception.TestNotFoundException;
import com.cg.testmgmt.entities.User;

import com.cg.testmgmt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class TestServiceImpl implements ITestService {
   
   
   private IUserService userService;
	

	public IUserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private ITestDao testDao;
	public ITestDao getTestDao() {
		return testDao;
	}
	@Autowired
	public void setTestDao(ITestDao testDao) {
		this.testDao = testDao;
	}
	
	/*
	 ***************************************************
	 *This method is used to add new test
	 *************************************************** 
	 */
	
	@Override
	public Test addTest(Test test) 
	{	//boolean exists=testDao.existsById(test.getTestId());
//		if(!exists)
//		{
			test = testDao.save(test);
			return test;
//		}
//		else
//			throw new TestNotAddedException(" Test with id"+test.getTestId()+" is already added !");

		
	}
	
	/*
	 ***************************************************
	 *This method is used to update existing test
	 *************************************************** 
	 */
	

	@Override
	public Test updateTest(BigInteger testId, Test test) {
		boolean exists = testDao.existsById(testId);
		if (exists) {
			test = testDao.save(test);
			return test;
		}
		throw new TestNotFoundException("Test not found for id="+testId);
	}
	
	/*
	 ***************************************************
	 *This method is used to delete existing test
	 *************************************************** 
	 */

	@Override
	public Test deleteTest(BigInteger testId) {
		Test test = findById(testId);
		testDao.delete(test);
		return test;
	}
	
	/*
	 ***************************************************
	 *This method is used to assign test to a user
	 *************************************************** 
	 */

	@Override
	public boolean assignTest(Long userId, BigInteger testId) {
		boolean testExists = testDao.existsById(testId);
		if (testExists) 
		{
				Test test = findById(testId);
				User user = userService.findById(userId);
				user.setUserTest(test);
				user = userService.addUser(user);
				return true;
		}
		else
		{
			throw new TestNotFoundException("Test not found for id="+testId);
		}
	}



	@Override
	public Test findById(BigInteger testId) {
		 Optional<Test>optional=testDao.findById(testId);
	     if(optional.isPresent()){
	         Test test=optional.get();
	         return test;
	     }
	     throw new TestNotFoundException("Test not found for id="+testId);
	    }
	@Override
	public List<Test> fetchAll() {
		List<Test> tests = testDao.findAll();
		return tests;
	}
	}


