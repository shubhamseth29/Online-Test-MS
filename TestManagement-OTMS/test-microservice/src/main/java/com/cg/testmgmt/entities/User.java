package com.cg.testmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", userTest=" + userTest + ", isAdmin=" + isAdmin
				+ ", userPassword=" + userPassword + "]";
	}

	@Id
	@GeneratedValue
	private Long UserId;
	@NotEmpty(message = "Name is required")
	@Size(min=5,max=20,message="User name should be minimum 5 and maximum 20 characters long")
	private String UserName;
	@OneToOne(targetEntity=Test.class)
	private Test userTest;
	private boolean isAdmin;
	@NotEmpty(message = "Password is required")
	@Size(min=8,message="Password should be minimum 8 characters long")
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UserId == null) ? 0 : UserId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (UserId == null) {
			if (other.UserId != null)
				return false;
		} else if (!UserId.equals(other.UserId))
			return false;
		return true;
	}
}
