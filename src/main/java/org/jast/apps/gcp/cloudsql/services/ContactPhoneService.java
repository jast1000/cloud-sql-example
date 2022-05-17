package org.jast.apps.gcp.cloudsql.services;

import java.util.List;

import org.jast.apps.gcp.cloudsql.dtos.AddContactPhoneDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddContactPhoneResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.ContactPhoneDTO;

public interface ContactPhoneService {
	List<ContactPhoneDTO> getContactPhones(Integer contactId);
	AddContactPhoneResponseDTO saveContactPhone(Integer contactId, AddContactPhoneDTO addContactPhone);
}
