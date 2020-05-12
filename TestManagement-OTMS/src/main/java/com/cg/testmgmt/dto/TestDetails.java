package com.cg.testmgmt.dto;

import java.math.BigInteger;
import java.util.List;

public class TestDetails {
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

}
