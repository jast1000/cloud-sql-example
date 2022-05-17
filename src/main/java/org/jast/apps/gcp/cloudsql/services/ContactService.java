package org.jast.apps.gcp.cloudsql.services;

import java.util.List;

import org.jast.apps.gcp.cloudsql.dtos.AddContactDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddContactResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.ContactDTO;

public interface ContactService {
	AddContactResponseDTO saveContact(Integer userId, AddContactDTO addContact);
	List<ContactDTO> getContacts(Integer userId);
}
