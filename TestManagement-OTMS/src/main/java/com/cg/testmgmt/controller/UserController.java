package com.cg.testmgmt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.testmgmt.entities.User;
import com.cg.testmgmt.service.IUserService;
import com.cg.testmgmt.dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService service;
	@PostMapping("/add")
	public ResponseEntity<User>addUser(@RequestBody @Valid UserDto userDto )
	{
		User user=convertFromDto(userDto);
		user=service.addUser(user);
		ResponseEntity<User>response=new ResponseEntity<User>(user, HttpStatus.OK);
		return response;
	}
	public User convertFromDto(UserDto dto) {
		User user=new User();
		user.setUserId(dto.getUserId());
		user.setUserName(dto.getUserName());
		user.setUserPassword(dto.getUserPassword());
		return user;
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody @Valid UserDto userDto) {
		User user = convertFromDto(userDto);
		user.setUserId(userId);
		user = service.updateUser(userId, user);
		ResponseEntity<User> response = new ResponseEntity<>(user, HttpStatus.OK);
		return response;
	}
	
	 @GetMapping("/remove/{id}")
		public ResponseEntity<Boolean> deleteTest(@PathVariable("id") Long userId) {
			User result = service.deleteUser(userId);
			ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
			return response;
		}

	
}
