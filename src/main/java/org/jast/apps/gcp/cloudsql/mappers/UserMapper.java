package org.jast.apps.gcp.cloudsql.mappers;

import java.nio.charset.StandardCharsets;

import org.jast.apps.gcp.cloudsql.dtos.AddUserDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddUserResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.UserDTO;
import org.jast.apps.gcp.cloudsql.entities.User;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;

@Component
public class UserMapper {

	public User toUser(AddUserDTO addUser) {
		var newPassword = Hashing.sha256().hashString(addUser.getPassword(), StandardCharsets.UTF_8).toString();
		
		var user = new User();
		user.setFullName(addUser.getFullName());
		user.setPassword(newPassword);
		user.setUsername(addUser.getUsername());
		
		return user;
	}
	
	public UserDTO toUserDTO(User user) {
		var userDTO = new UserDTO();
		
		userDTO.setUserId(user.getUserId());
		userDTO.setFullName(user.getFullName());
		userDTO.setUsername(user.getUsername());
		userDTO.setCreatedAt(user.getCreatedAt());
		userDTO.setUpdatedAt(user.getUpdatedAt());
		
		return userDTO;
	}
	
	public AddUserResponseDTO toAddUserResponseDTO(User user) {
		var addUserResponseDTO = new AddUserResponseDTO();
		
		addUserResponseDTO.setUserId(user.getUserId());
		addUserResponseDTO.setFullName(user.getFullName());
		addUserResponseDTO.setUsername(user.getUsername());
		
		return addUserResponseDTO;
	}
}
