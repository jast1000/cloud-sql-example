package org.jast.apps.gcp.cloudsql.daos;

import java.util.List;

import org.jast.apps.gcp.cloudsql.entities.User;

public interface UserDAO {
	User save(User user);
	List<User> getAll();
	boolean exists(Integer userId);
}
