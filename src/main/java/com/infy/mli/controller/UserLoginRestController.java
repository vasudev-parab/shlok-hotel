package com.infy.mli.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.mli.dto.LoginDto;
import com.infy.mli.dto.Response;
import com.infy.mli.entity.LoginEntity;
import com.infy.mli.service.UserLoginServiceImpl;

@RestController
@RequestMapping(value = "/user")
public class UserLoginRestController {

	@Autowired
	private UserLoginServiceImpl userLoginServiceImpl;

	/*
	 * @PostMapping(value = "/addUser") public ResponseEntity<LoginDto>
	 * ValidateUser(@Valid @RequestBody LoginDto loginDto ) {
	 * 
	 * return new ResponseEntity<>(loginDto,HttpStatus.CREATED); }
	 */

//	@PostMapping(value = "/addUser")
//	public ResponseEntity<LoginDto> addUser(@Valid @RequestBody LoginDto loginDto ) {
//		return new ResponseEntity<>(loginDto,HttpStatus.CREATED);
//	}

	@PostMapping(value = "/validateUser")
	public ResponseEntity<Response> ValidateUser(@Valid @RequestBody LoginDto loginDto) {
		Response response = new Response();
		try {
			response = userLoginServiceImpl.getUser(loginDto.getUserId(), loginDto.getPassword());
			if (response.getMessage().equals("Incorrect Password"))
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("Invalid UserId");
			response.setStatus("Fail");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

//	@GetMapping(value = "/showUser/{userId}")
//	public LoginDto getUser(@PathVariable String userId) {
//		return userLoginServiceImpl.getUser(userId);
//		
//	}

}
