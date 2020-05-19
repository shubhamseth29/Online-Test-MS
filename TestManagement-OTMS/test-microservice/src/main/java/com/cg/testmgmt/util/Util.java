package com.cg.testmgmt.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.cg.testmgmt.dto.TestDetails;
import com.cg.testmgmt.dto.TestDto;
import com.cg.testmgmt.dto.TestQuestionDto;
import com.cg.testmgmt.entities.Test;

public class Util {
	
	public static TestDto testDto(Test test) {
		TestDto dto=new TestDto();
		dto.setTestId(test.getTestId());
		dto.setTestTitle(test.getTestTitle());
		dto.setTestDuration(test.getTestDuration());
		dto.setTestTotalMarks(test.getTestTotalMarks());
		//dto.setStartTime(test.getStartTime());
		//dto.setEndTime(test.getEndTime());
		return dto;
	}
	
	public static List<TestDto>tests(List<Test>tests){
		List<TestDto>allTests=new ArrayList<>();
		for(Test test:tests) {
			TestDto dto=testDto(test);
			allTests.add(dto);
		}
		return allTests;
	}
	
	public static TestDetails convertToTestDetails(Test test){
		TestDetails details = new TestDetails();
		List<TestQuestionDto> questions =fallbackFetchQuestionsByTestId(test.getTestId());
		details.setQuestions(questions);
		details.setTestId(test.getTestId());
		details.setTestTitle(test.getTestTitle());
		details.setEndTime(test.getEndTime());
//		details.setStartTime(test.getStartTime());
//		details.setTestDuration(test.getTestDuration());
		details.setTestTotalMarks(test.getTestTotalMarks());
		//details.setTestMarksScored(test.getTestMarksScored());
		return details;
	}
	
	 public static  List<TestQuestionDto> fallbackFetchQuestionsByTestId(BigInteger testId){
		 TestQuestionDto question = new TestQuestionDto();
		 question.setQuestionId(BigInteger.valueOf(1));
		 question.setQuestionTitle("java");
		 List<TestQuestionDto> list = new ArrayList<>();
		 list.add(question);
		return list;
		 
	 }
	 
	 public static Test  convertFromDto(TestDto dto) {
			Test test = new Test();
			
			//test.setEndTime(dto.getEndTime());
			//test.setStartTime(dto.getStartTime());
			test.setTestDuration(dto.getTestDuration());
			//test.setTestMarksScored(dto.getTestMarksScored());
			test.setTestTitle(dto.getTestTitle());
			test.setTestTotalMarks(dto.getTestTotalMarks());
			return test;
		}
	 

}
