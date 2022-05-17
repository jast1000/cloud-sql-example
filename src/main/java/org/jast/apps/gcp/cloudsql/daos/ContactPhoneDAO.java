package org.jast.apps.gcp.cloudsql.daos;

import java.util.List;

import org.jast.apps.gcp.cloudsql.entities.ContactPhone;

public interface ContactPhoneDAO {
	ContactPhone save(ContactPhone contactPhone);
	List<ContactPhone> getAll(Integer contactId);
}
