package org.jast.apps.gcp.cloudsql.controllers;

import org.jast.apps.gcp.cloudsql.dtos.AddContactDTO;
import org.springframework.http.ResponseEntity;

public interface ContactController {
	ResponseEntity<?> addContact(Integer userId, AddContactDTO addContact);
	ResponseEntity<?> getContacts(Integer userId);
}
