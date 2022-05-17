package org.jast.apps.gcp.cloudsql.daos.impl;

import java.util.List;

import org.jast.apps.gcp.cloudsql.daos.ContactPhoneDAO;
import org.jast.apps.gcp.cloudsql.entities.ContactPhone;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactPhoneDAOImpl implements ContactPhoneDAO {
	private JdbcTemplate jdbc;

	public ContactPhoneDAOImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public ContactPhone save(ContactPhone contactPhone) {
		var sql = "insert into public.contact_phone(contact_id, number, phone_type_id, created_at)"
				+ " values(?, ?, ?, now()) returning contact_phone_id";
		var args = new Object[] { contactPhone.getContactId(), contactPhone.getNumber(),
				contactPhone.getPhoneTypeId() };
		Integer contactPhoneId = jdbc.queryForObject(sql, Integer.class, args);
		contactPhone.setContactPhoneId(contactPhoneId);
		
		return contactPhone;
	}

	@Override
	public List<ContactPhone> getAll(Integer contactId) {
		var sql = "select contact_phone_id, contact_id, number, phone_type_id, created_at, updated_at from public.contact_phone"
				+ " where deleted_at is null and contact_id = ?"
				+ " order by created_at";
		var contactPhones = jdbc.query(sql, new BeanPropertyRowMapper<>(ContactPhone.class), contactId);
		
		return contactPhones;
	}

}
