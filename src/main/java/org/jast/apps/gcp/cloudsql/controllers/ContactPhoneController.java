package org.jast.apps.gcp.cloudsql.controllers;

import org.jast.apps.gcp.cloudsql.dtos.AddContactPhoneDTO;
import org.springframework.http.ResponseEntity;

public interface ContactPhoneController {
	ResponseEntity<?> getContactPhones(Integer contactId);
	ResponseEntity<?> saveContactPhone(Integer contactId, AddContactPhoneDTO addContactPhone);
}
