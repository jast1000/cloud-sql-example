package org.jast.apps.gcp.cloudsql.controllers.impl;

import java.util.List;

import javax.validation.Valid;

import org.jast.apps.gcp.cloudsql.controllers.UserController;
import org.jast.apps.gcp.cloudsql.dtos.AddUserDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddUserResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.UserDTO;
import org.jast.apps.gcp.cloudsql.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
@Api(tags = "Users")
public class UserControllerImpl implements UserController {

	private UserService userService;
	
	public UserControllerImpl(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	@ApiOperation(
			value = "Add an user")
	@ApiResponses(
			@ApiResponse(
					code = 201, 
					message = "User created",
					response = AddUserResponseDTO.class))
	@RequestMapping(
			method = RequestMethod.POST, 
			produces = "application/json", 
			consumes = "application/json")
	public ResponseEntity<?> addUser(@Valid @RequestBody AddUserDTO addUser) {
		AddUserResponseDTO addUserResponse = userService.saveUser(addUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(addUserResponse);
	}

	@Override
	@ApiOperation(
			value = "Get all the users", 
			produces = "application/json")
	@ApiResponses(
			@ApiResponse(
					code = 200, 
					message = "Users retrieved", 
					response = UserDTO.class, 
					responseContainer = "List"))
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		List<UserDTO> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}

}
