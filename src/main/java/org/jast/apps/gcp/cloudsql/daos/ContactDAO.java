package org.jast.apps.gcp.cloudsql.daos;

import java.util.List;

import org.jast.apps.gcp.cloudsql.entities.Contact;

public interface ContactDAO {
	Contact save(Contact contact);
	List<Contact> getAll(Integer userId);
	boolean exists(Integer contactId);
}
