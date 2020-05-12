package com.cg.testmgmt.dto;

import java.math.BigInteger;

public class AssignTestDto {
	private BigInteger testId;
	private Long userId;
	public BigInteger getTestId() {
		return testId;
	}
	public void setTestId(BigInteger testId) {
		this.testId = testId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
