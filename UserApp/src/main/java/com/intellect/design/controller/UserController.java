package com.intellect.design.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.design.bean.User;
import com.intellect.design.service.Response;
import com.intellect.design.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST, produces="Application/JSON")
	
	public Response createUser(@RequestBody User user){
		return userService.createUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, produces="Application/JSON")
	public Response updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, produces="Application/JSON")
	public Response deleteUser(@RequestBody User user){
		return userService.deleteUser(user);
	}

}
