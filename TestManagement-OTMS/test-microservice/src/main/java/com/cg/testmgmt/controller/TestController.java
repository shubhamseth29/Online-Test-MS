package com.cg.testmgmt.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;


import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.cg.testmgmt.dto.TestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.testmgmt.dto.*;
import com.cg.testmgmt.entities.Test;
import com.cg.testmgmt.exception.TestNotAddedException;
import com.cg.testmgmt.exception.TestNotFoundException;
import com.cg.testmgmt.exception.UserNotFoundException;
import com.cg.testmgmt.service.ITestService;
import com.cg.testmgmt.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tests")
public class TestController {
	
	  private static final Logger Log= LoggerFactory.getLogger(TestController.class);
	 @Autowired
	 private ITestService service;
	 @GetMapping("/get/{id}")
	  public ResponseEntity<TestDetails>getTest(@PathVariable("id") BigInteger id){
		Test test = service.findById(id);
		TestDetails details = Util.convertToTestDetails(test);
		Log.info("Test Fetched");
		ResponseEntity<TestDetails>response=new ResponseEntity<>(details, HttpStatus.OK);
		System.out.println("This is detail"+details);
		return response;
		
	  }
	 
	
	

	 @GetMapping
	 @ResponseStatus(HttpStatus.OK)
	   public List<TestDto>fetchAll(){
	       List<Test> tests=service.fetchAll();
	       	List<TestDto> allTests=Util.tests(tests);
	       	Log.info("All Tests Fetched");
	       	System.out.println(allTests);
	       
	       return allTests;
	   }
	 
	 
	
	 @PostMapping("/add")
	    public ResponseEntity<Test>createTest(@RequestBody @Valid TestDto testDto){
	       Test test = Util.convertFromDto(testDto);
	       test=service.addTest(test);
	       Log.info("Test created ");
	        ResponseEntity<Test>response=new ResponseEntity<>(test, HttpStatus.OK);
	        System.out.println(testDto);
	        return response;
	      
	   }
	 
	 @GetMapping("/delete/{id}")
		public ResponseEntity<Boolean> deleteTest(@PathVariable("id") BigInteger testId) {
			Test result = service.deleteTest(testId);
			  Log.info("Test removed");
			ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
			return response;
		}

	 @PutMapping("/update/{id}")
		public ResponseEntity<Test> updateTest(@PathVariable("id") BigInteger testId, @RequestBody @Valid TestDto testDto) {
			Test test = Util.convertFromDto(testDto);
			test.setTestId(testId);
			test = service.updateTest(testId, test);
			  Log.info("Test updated ");
			ResponseEntity<Test> response = new ResponseEntity<>(test, HttpStatus.OK);
			return response;
		}
	 
	 @GetMapping("/assign/{testId}/{userId}")
		public ResponseEntity<Boolean> assignTest(@PathVariable("testId") BigInteger testId,
				@PathVariable("userId") Long userId) {
			Boolean isAssign = service.assignTest(userId, testId);
			  Log.info("Test assigned ");
			ResponseEntity<Boolean> response = new ResponseEntity<>(isAssign, HttpStatus.OK);
			return response;
		}

		
		
		
	 
}
