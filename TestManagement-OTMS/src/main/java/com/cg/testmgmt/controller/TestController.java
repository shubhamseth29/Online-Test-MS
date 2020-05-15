package com.cg.testmgmt.controller;

import java.math.BigInteger;
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
		TestDetails details = convertToTestDetails(test);
		ResponseEntity<TestDetails>response=new ResponseEntity<>(details, HttpStatus.OK);
		return response;
		
	  }
	 
	TestDetails convertToTestDetails(Test test){
		TestDetails details = new TestDetails();
		List<TestQuestionDto> questions =fallbackFetchQuestionsByTestId(test.getTestId());
		details.setQuestions(questions);
		details.setTestId(test.getTestId());
		details.setTestTitle(test.getTestTitle());
		details.setEndTime(test.getEndTime());
		details.setStartTime(test.getStartTime());
		details.setTestDuration(test.getTestDuration());
		details.setTestTotalMarks(test.getTestTotalMarks());
		details.setTestMarksScored(test.getTestMarksScored());
		return details;
	}
	
//	List<TestDto> convertToTestDto(List<Test> tests)
//	{
//		TestDto dto=new TestDto();
//		dto.setTestTitle(tests.getTestTitle());
//		dto.setTestDuration(tests.getTestDuration());
//		dto.setTestTotalMarks(tests.getTestMarksScored());
//		dto.setTestMarksScored(tests.getTestMarksScored());
//		dto.setStartTime(tests.getStartTime());
//		dto.setEndTime(tests.getEndTime());
//		return (List<TestDto>) dto;
//		
//	}
//	
//	 @GetMapping
//	   public ResponseEntity<List<TestDto>>fetchAll(){
//	       List<Test> tests=service.fetchAll();
//	       	List<TestDto> dto=convertToTestDto(tests);
//	       ResponseEntity<List<TestDto>>response=new ResponseEntity<>(dto,HttpStatus.OK);
//	       return response;
//	   }
//	 
	 
	 public  List<TestQuestionDto> fallbackFetchQuestionsByTestId(BigInteger testId){
		 TestQuestionDto question = new TestQuestionDto();
		 question.setQuestionId(BigInteger.valueOf(1));
		 question.setQuestionTitle("java");
		 List<TestQuestionDto> list = new ArrayList<>();
		 list.add(question);
		return list;
		 
	 }
	 @PostMapping("/add")
	    public ResponseEntity<Test>createTest(@RequestBody @Valid TestDto testDto){
	       Test test = convertFromDto(testDto);
	       test=service.addTest(test);
	       Log.info("Test created ");
	        ResponseEntity<Test>response=new ResponseEntity<>(test, HttpStatus.OK);
	        return response;
	      
	   }
	 
	 @GetMapping("/remove/{id}")
		public ResponseEntity<Boolean> deleteTest(@PathVariable("id") BigInteger testId) {
			Test result = service.deleteTest(testId);
			  Log.info("Test removed");
			ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
			return response;
		}

	 @PutMapping("/update/{id}")
		public ResponseEntity<Test> updateTest(@PathVariable("id") BigInteger testId, @RequestBody @Valid TestDto testDto) {
			Test test = convertFromDto(testDto);
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

		
		
		public Test  convertFromDto(TestDto dto) {
			Test test = new Test();
			test.setEndTime(dto.getEndTime());
			test.setStartTime(dto.getStartTime());
			test.setTestDuration(dto.getTestDuration());
			test.setTestMarksScored(dto.getTestMarksScored());
			test.setTestTitle(dto.getTestTitle());
			test.setTestTotalMarks(dto.getTestTotalMarks());
			return test;
		}
	 
	 
}
