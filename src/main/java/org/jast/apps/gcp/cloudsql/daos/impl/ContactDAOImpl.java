package org.jast.apps.gcp.cloudsql.daos.impl;

import java.util.List;

import org.jast.apps.gcp.cloudsql.daos.ContactDAO;
import org.jast.apps.gcp.cloudsql.entities.Contact;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO {
	private JdbcTemplate jdbc;

	public ContactDAOImpl(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}

	@Override
	public Contact save(Contact contact) {
		var sql = "insert into public.contact(first_name, last_name, address, user_id, created_at)"
				+ " values(?, ?, ?, ?, now()) returning contact_id";
		var args = new Object[] { contact.getFirstName(), contact.getLastName(), contact.getAddress(),
				contact.getUserId() };
		Integer contactId = jdbc.queryForObject(sql, Integer.class, args);
		contact.setContactId(contactId);

		return contact;
	}

	@Override
	public List<Contact> getAll(Integer userId) {
		var sql = "select contact_id, first_name, last_name, address, user_id, created_at, updated_at from public.contact"
				+ " where deleted_at is null and user_id = ? order by upper(first_name), upper(last_name)";
		var contacts = jdbc.query(sql, new BeanPropertyRowMapper<>(Contact.class), userId);
		
		return contacts;
	}

	@Override
	public boolean exists(Integer contactId) {
		boolean idExists = true;
		var sql = "select contact_id from public.contact where deleted_at is null and contact_id = ?";
		try {
			jdbc.queryForObject(sql, Integer.class, contactId);
		} catch (EmptyResultDataAccessException ex) {
			idExists = false;
		}
		return idExists;
	}

}
