package com.infy.mli.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

//import com.infy.mli.dto.LoginDto;
import com.infy.mli.entity.LoginEntity;

public interface LoginRepository extends MongoRepository<LoginEntity, String>{
	
//	public LoginDto getUser(String userId);
	public LoginEntity  findByUserId(String userId);
	
	
	
	

}
