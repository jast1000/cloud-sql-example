package org.jast.apps.gcp.cloudsql.daos.impl;

import java.util.List;

import org.jast.apps.gcp.cloudsql.daos.UserDAO;
import org.jast.apps.gcp.cloudsql.entities.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbc;

	public UserDAOImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public User save(User user) {
		var sql = "insert into public.user(full_name, username, password, created_at) values(?, ?, ?, now()) returning user_id";
		var args = new Object[] { user.getFullName(), user.getUsername(), user.getPassword() };
		var userId = (Integer) jdbc.queryForObject(sql, Integer.class, args);
		user.setUserId(userId);

		return user;
	}

	@Override
	public List<User> getAll() {
		var sql = "select user_id, full_name, username, password, created_at, updated_at from public.user"
				+ " where deleted_at is null" + " order by upper(full_name)";
		var users = jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));

		return users;
	}

	@Override
	public boolean exists(Integer userId) {
		boolean idExists = true;
		var sql = "select user_id from public.user where deleted_at is null and user_id = ?";
		try {
			jdbc.queryForObject(sql, Integer.class, userId);
		} catch (EmptyResultDataAccessException ex) {
			idExists = false;
		}
		return idExists;
	}

}
