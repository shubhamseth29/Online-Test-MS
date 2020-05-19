package com.cg.testmgmt.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.cg.testmgmt.dto.TestQuestionDto;

public class TestDetails {
	@Override
	public String toString() {
		return "TestDetails [questions=" + questions + ", testId=" + testId + ", testTitle=" + testTitle
				+ ", testDuration=" + testDuration + ", testTotalMarks=" + testTotalMarks + ", testMarksScored="
				+ testMarksScored + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	private List<TestQuestionDto> questions;

	public List<TestQuestionDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<TestQuestionDto> questions) {
		this.questions = questions;
	}

	private BigInteger testId;

	public BigInteger getTestId() {
		return testId;
	}

	public void setTestId(BigInteger testId) {
		this.testId = testId;
	}
	
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


}
