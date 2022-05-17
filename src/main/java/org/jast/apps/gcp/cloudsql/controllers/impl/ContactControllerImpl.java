package org.jast.apps.gcp.cloudsql.controllers.impl;

import javax.validation.Valid;

import org.jast.apps.gcp.cloudsql.controllers.ContactController;
import org.jast.apps.gcp.cloudsql.dtos.AddContactDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddContactResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.ContactDTO;
import org.jast.apps.gcp.cloudsql.services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Contacts")
public class ContactControllerImpl implements ContactController {
	private ContactService contactService;
	
	public ContactControllerImpl(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@Override
	@RequestMapping(
			value = "/users/{userId}/contacts", 
			method = RequestMethod.POST, 
			consumes = "application/json", 
			produces = "application/json")
	@ApiOperation(value = "Add a contact")
	@ApiResponses(
			@ApiResponse(
					code = 201, 
					message = "Contact created", 
					response = AddContactResponseDTO.class))
	public ResponseEntity<?> addContact(@PathVariable Integer userId, @RequestBody @Valid AddContactDTO addContact) {
		var contactCreated = contactService.saveContact(userId, addContact);
		return ResponseEntity.status(HttpStatus.CREATED).body(contactCreated);
	}

	@Override
	@RequestMapping(
			value = "/users/{userId}/contacts", 
			method = RequestMethod.GET, 
			produces = "application/json")
	@ApiOperation(value = "Get the contacts")
	@ApiResponses(
			@ApiResponse(
					code = 200, 
					message = "Contacts retrivied", 
					response = ContactDTO.class,
					responseContainer = "List"))
	public ResponseEntity<?> getContacts(@PathVariable Integer userId) {
		var contacts = contactService.getContacts(userId);
		return ResponseEntity.ok(contacts);
	}

}
