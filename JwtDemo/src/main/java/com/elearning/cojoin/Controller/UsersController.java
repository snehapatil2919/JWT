package com.elearning.cojoin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.elearning.cojoin.Model.Users;
import com.elearning.cojoin.Service.UsersService;

@RestController
public class UsersController {

	@Autowired
	UsersService usersService;
	
	@PostMapping(path = "/registerUser")
	public ResponseEntity<Users> saveUserInfo(@RequestBody Users user) {
		Users saveData = usersService.saveData(user);
		return new ResponseEntity<Users>(saveData, HttpStatus.OK);
	}
	
	@PostMapping(path = "/authenticate")
	public ResponseEntity<Users> authenticateUser(@RequestBody Users user){
		Users users = usersService.authenticateUser(user);
		return new ResponseEntity<Users>(users, HttpStatus.FOUND);
	}
	
	
}
