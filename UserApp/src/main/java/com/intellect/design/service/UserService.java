package com.intellect.design.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.intellect.design.bean.User;

@Service
public class UserService {
	
	HashMap<String, User> users = new HashMap<String, User>();
	
	/*This method checks if user already exists in the collection. If it exists then checks if that user is active
	 *  and if he is active then it will throw error as user exists. If not then user will be created
	 * */
	public Response createUser(User user){
		Response response = new Response();
		boolean userExists = false;
		
		//Get all entries from collection
		Set<Map.Entry<String, User>> all = users.entrySet();
		for(Map.Entry<String, User> mapUser : all){
			
			User currentUser = mapUser.getValue();
			if(currentUser.getEmail().equals(user.getEmail())){
				userExists = true;
				if(!currentUser.isActive()){
					User newUser = new User(user.getfName(), user.getlName(), user.getEmail(), user.getPinCode(),user.getBirthDate(),true);
					users.put(newUser.getId(), newUser);
					response= new Response("New user added", newUser.getId(), null);
					return response;
				}
				else{
					response.setResMsg("User creation failed");
					response.setUserId(user.getId());
					Error error = new Error();
					error.setCode(1);
					error.setField("id");
					error.setMessage("Active user exists with same email id");
					response.setValErrors(error);
					return response;
				}
			}
		}
		if(userExists == false){
			User newUser = new User(user.getfName(), user.getlName(), user.getEmail(), user.getPinCode(),user.getBirthDate(),true);
			users.put(newUser.getId(), newUser);
			response= new Response("New user added", newUser.getId(), null);
			System.out.println("New user is:"+newUser.toString());
		}
		
		
		
		return response;
	}
	
	
	/*Update user only if user exists */
	public Response updateUser(User user){
		Response response = new Response();
		
		System.out.println("user id:"+user.getId());
		if(users.containsKey(user.getId())){
			User current = users.get(user.getId());
			
			current.setBirthDate(user.getBirthDate());
			current.setPinCode(user.getPinCode());
			
			users.put(user.getId(), current);
			
			response.setResMsg("user updated successfully");
			response.setUserId(user.getId());
		}
		else{
			response.setResMsg("user updatation failed");
			response.setUserId(user.getId());
			Error error = new Error();
			error.setCode(1);
			error.setField("id");
			error.setMessage("User id does not exist");
			response.setValErrors(error);
			
		}
		return response;
	}
	
	/*Deletes only if user exists*/
	public Response deleteUser(User user) {
		Response response = new Response();
		String currentUserId = user.getId();
		
		if(users.containsKey(currentUserId)){
			User currentUser = users.get(currentUserId);
			currentUser.setActive(false);
			response.setResMsg("user deleted successfully");
			response.setUserId(user.getId());
			
		}
		else{
			response.setResMsg("user deletion failed");
			response.setUserId(user.getId());
			Error error = new Error();
			error.setCode(1);
			error.setField("id");
			error.setMessage("User id does not exist");
			response.setValErrors(error);
		}
		
		return response;
	}

}
