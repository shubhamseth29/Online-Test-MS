package com.cg.testmgmt.dto;

import com.cg.testmgmt.entities.Test;

public class UserDetails {
	
	private Long UserId;
	private String UserName;
	private Test userTest;
	private boolean isAdmin;
	private String userPassword;
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Test getUserTest() {
		return userTest;
	}
	public void setUserTest(Test userTest) {
		this.userTest = userTest;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserDetails [UserId=" + UserId + ", UserName=" + UserName + ", userTest=" + userTest + ", isAdmin="
				+ isAdmin + ", userPassword=" + userPassword + "]";
	}


}
