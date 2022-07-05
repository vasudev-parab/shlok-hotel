package com.infy.mli.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginDto {
	@Size(min = 6, max = 20, message = "userId should be 6 to 20 characters")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "userId should not have any special characters or blank space")
//	@Pattern(regexp = "^\\\\s+$",message = "userId should not have blank space")
	private String userId;

	@Size(min = 7, message = "Password should be atleast 7 characters")
	@Pattern(regexp = "^(?=.*[@#$%^&+=]).*$", message = "password should have atleast one special character")
//    @Pattern(regexp = "\\\\A(?!\\\\s*\\\\Z).+",message = "Password should not have blank space")
	private String password;

	public LoginDto() {
		super();
	}

	public LoginDto(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [userId=" + userId + ", password=" + password + "]";
	}

}
