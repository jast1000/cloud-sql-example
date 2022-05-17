package org.jast.apps.gcp.cloudsql.services;

import java.util.List;

import org.jast.apps.gcp.cloudsql.dtos.AddUserDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddUserResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.UserDTO;

public interface UserService {
	AddUserResponseDTO saveUser(AddUserDTO addUser);
	List<UserDTO> getUsers();
}
