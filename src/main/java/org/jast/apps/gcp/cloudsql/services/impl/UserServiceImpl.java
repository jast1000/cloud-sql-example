package org.jast.apps.gcp.cloudsql.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jast.apps.gcp.cloudsql.daos.UserDAO;
import org.jast.apps.gcp.cloudsql.dtos.AddUserDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddUserResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.UserDTO;
import org.jast.apps.gcp.cloudsql.entities.User;
import org.jast.apps.gcp.cloudsql.mappers.UserMapper;
import org.jast.apps.gcp.cloudsql.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	private UserMapper userMapper;
	
	public UserServiceImpl(UserDAO userDAO, UserMapper userMapper) {
		this.userDAO = userDAO;
		this.userMapper = userMapper;
	}
	
	@Override
	public AddUserResponseDTO saveUser(AddUserDTO addUser) {
		User user = userMapper.toUser(addUser);
		user = userDAO.save(user);

		return userMapper.toAddUserResponseDTO(user);
	}

	@Override
	public List<UserDTO> getUsers() {
		List<User> users = userDAO.getAll();
		return users.stream().map(userMapper::toUserDTO).collect(Collectors.toList());
	}
	
}
