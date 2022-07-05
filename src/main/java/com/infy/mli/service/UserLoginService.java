package com.infy.mli.service;



import java.util.List;
import java.util.Optional;

import com.infy.mli.dto.LoginDto;
import com.infy.mli.dto.Response;
import com.infy.mli.entity.LoginEntity;

public interface UserLoginService {
	
	public boolean saveLogin(LoginDto loginDto);
	//public String getLoginById(String userId);
	
	//public LoginDto getLoginById(String userId);
	
	public Response getUser(String userId,String password);
}
