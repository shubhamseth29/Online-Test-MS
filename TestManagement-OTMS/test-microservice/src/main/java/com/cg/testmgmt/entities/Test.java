package com.cg.testmgmt.entities;

import java.math.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "tests")
public class Test{
	@Id
	@GeneratedValue

	private BigInteger testId;
	@NotEmpty(message = "Test title is required")
	private String testTitle;
	private LocalTime testDuration;
	@Min(0)
	private BigDecimal testTotalMarks;
	//private BigDecimal testMarksScored;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	private LocalDateTime startTime;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	private LocalDateTime endTime;
	
	public BigInteger getTestId() {
		return testId;
	}

	public void setTestId(BigInteger testId) {
		this.testId = testId;
	}

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

//	public BigDecimal getTestMarksScored() {
//		return testMarksScored;
//	}
//
//	public void setTestMarksScored(BigDecimal testMarksScored) {
//		this.testMarksScored = testMarksScored;
//	}

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

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testTotalMarks=" + testTotalMarks + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}


}
