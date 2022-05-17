package org.jast.apps.gcp.cloudsql.controllers;

import org.jast.apps.gcp.cloudsql.dtos.AddUserDTO;
import org.springframework.http.ResponseEntity;

public interface UserController {
	
	ResponseEntity<?> addUser(AddUserDTO addUser);
	ResponseEntity<?> getUsers();
	
}
