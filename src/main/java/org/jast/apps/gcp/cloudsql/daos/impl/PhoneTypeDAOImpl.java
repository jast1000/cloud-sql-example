package org.jast.apps.gcp.cloudsql.daos.impl;

import java.util.List;

import org.jast.apps.gcp.cloudsql.daos.PhoneTypeDAO;
import org.jast.apps.gcp.cloudsql.entities.PhoneType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneTypeDAOImpl implements PhoneTypeDAO {
	private JdbcTemplate jdbc;

	public PhoneTypeDAOImpl(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}

	@Override
	public List<PhoneType> getAll() {
		var sql = "select phone_type_id, description from public.phone_type order by description";
		var phoneTypes = jdbc.query(sql, new BeanPropertyRowMapper<>(PhoneType.class));
		
		return phoneTypes;
	}
}
