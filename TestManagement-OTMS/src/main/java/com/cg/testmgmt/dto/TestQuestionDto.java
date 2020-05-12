package com.cg.testmgmt.dto;

import java.math.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestQuestionDto {
	
	private BigInteger questionId;
	private String questionTitle;
	private int questionAnswer;
	private BigDecimal questionMarks;
	private int chosenAnswer;
	private BigDecimal marksScored;
	private String []questionOptions=new String[4];
	
	private String testTitle;
	private LocalTime testDuration;
	private BigDecimal testTotalMarks;
	private BigDecimal testMarksScored;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public LocalTime getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}
	public BigDecimal getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(BigDecimal testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}
	public BigDecimal getTestMarksScored() {
		return testMarksScored;
	}
	public void setTestMarksScored(BigDecimal testMarksScored) {
		this.testMarksScored = testMarksScored;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public BigInteger getQuestionId() {
		return questionId;
	}	
	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}	
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public int getQuestionAnswer() {
		return questionAnswer;
	}	
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}	
	public BigDecimal getQuestionMarks() {
		return questionMarks;
	}	
	public void setQuestionMarks(BigDecimal questionMarks) {
		this.questionMarks = questionMarks;
	}	
	public int getChosenAnswer() {
		return chosenAnswer;
	}	
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}	
	public BigDecimal getMarksScored() {
		return marksScored;
	}	
	public void setMarksScored(BigDecimal marksScored) {
		this.marksScored = marksScored;
	}	
	public String[] getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(String[] questionOptions) {
		this.questionOptions = questionOptions;
	}
}
