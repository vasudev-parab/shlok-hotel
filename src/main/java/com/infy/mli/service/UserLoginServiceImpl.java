package com.infy.mli.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infy.mli.dto.LoginDto;
import com.infy.mli.dto.Response;
import com.infy.mli.entity.LoginEntity;
import com.infy.mli.repository.LoginRepository;


@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public boolean saveLogin(LoginDto loginDto) {
		LoginEntity entity=new LoginEntity();
		BeanUtils.copyProperties(loginDto, entity);
		LoginEntity saveEntity=loginRepository.save(entity);
		return saveEntity.getUserId() != null;
	}
	/*
	 * @Override public String getLoginById(String userId) { Optional<LoginEntity>
	 * dto= loginRepository.findById(userId); return "dto" ; }
	 */

//	@Override
//	public List<LoginDto> getUser(String userId) {
//		List<LoginDto> dtos=new ArrayList<LoginDto>();
//		List<LoginEntity> entitieList=loginRepository.findAll();
//		entitieList.forEach(entity->{
//			LoginDto dto=new LoginDto();
//		   
//			BeanUtils.copyProperties(entity, dto);
//		     dtos.add(dto);
//		});
//		return dtos;
//	}
	
	 @Override
	    public Response getUser(String userId,String password) {
            LoginDto loginDto = new LoginDto();
            Response response =new Response();
		    LoginEntity login =loginRepository.findByUserId(userId);
		    BeanUtils.copyProperties(login, loginDto);
		    
		    
		    if(login.getPassword().equals(password))
		    {
		    	response.setMessage("Login Successfully");
		    	response.setStatus("Success");
		    	return response;
		    }
		    else {
		    	response.setMessage("Incorrect Password");
		    	response.setStatus("Fail");
		    	return response;
			}
		    
	    }

	/*
	 * @Override public LoginDto getLoginById(String userId) { Optional<LoginEntity>
	 * loginDto=loginRepository.findById(userId) return }
	 */

	

}
