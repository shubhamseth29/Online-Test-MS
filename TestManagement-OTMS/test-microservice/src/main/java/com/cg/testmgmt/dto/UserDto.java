package com.cg.testmgmt.dto;

public class UserDto {
	
	@Override
	public String toString() {
		return "UserDto [UserId=" + UserId + ", UserName=" + UserName + ", isAdmin=" + isAdmin + ", userPassword="
				+ userPassword + "]";
	}
	private Long UserId;
	private String UserName;
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
