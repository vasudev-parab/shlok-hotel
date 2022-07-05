package com.infy.mli.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

//import com.mongodb.lang.NonNull;

@Document(collection = "loginEntity") // Map Entity class to json formatted documents
public class LoginEntity {
	
	@NotEmpty(message = "userId should not be empty")
	@Size(min=6,max = 20 , message = "userId should be 6 to 20 characters")
	@Pattern(regexp = "^[a-zA-Z0-9]+$",message = "userId should not have any special characters")
	private String userId;
	
	
	@NotEmpty(message = "password should not be empty")
    @Size(min=7, message = "Password should be atleast 7 characters")
	@Pattern(regexp = "^(?=.{7,})(?=.*[@#$%^&+=]).*$",message = "password should have atleast one special character")
	private String password;

	public LoginEntity() {

	}

	public LoginEntity(String userId, String password) {

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
		return "LoginEntity [userId=" + userId + ", password=" + password + "]";
	}

}
