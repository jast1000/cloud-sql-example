package org.jast.apps.gcp.cloudsql.controllers.impl;

import javax.validation.Valid;

import org.jast.apps.gcp.cloudsql.controllers.ContactPhoneController;
import org.jast.apps.gcp.cloudsql.dtos.AddContactPhoneDTO;
import org.jast.apps.gcp.cloudsql.dtos.ContactPhoneDTO;
import org.jast.apps.gcp.cloudsql.services.ContactPhoneService;
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
@Api(tags = "Contact phones")
public class ContactPhoneControllerImpl implements ContactPhoneController {
	private final ContactPhoneService contactPhoneService;

	public ContactPhoneControllerImpl(ContactPhoneService contactPhoneService) {
		this.contactPhoneService = contactPhoneService;
	}

	@Override
	@RequestMapping(
			value = "/contacts/{contactId}/number-phones", 
			method = RequestMethod.GET, 
			produces = "application/json")
	@ApiOperation(value = "Get the contact number phones")
	@ApiResponses(
			@ApiResponse(
					code = 200, 
					message = "Contact number phones retrivied", 
					response = ContactPhoneDTO.class,
					responseContainer = "List"))
	public ResponseEntity<?> getContactPhones(@PathVariable Integer contactId) {
		var contactPhones = contactPhoneService.getContactPhones(contactId);
		return ResponseEntity.ok(contactPhones);
	}

	@Override
	@RequestMapping(
			value = "/contacts/{contactId}/number-phones", 
			method = RequestMethod.POST, 
			consumes = "application/json", 
			produces = "application/json")
	@ApiOperation(value = "Add a contact number phone")
	@ApiResponses(
			@ApiResponse(
					code = 201, 
					message = "Contact number phone created", 
					response = AddContactPhoneDTO.class))
	public ResponseEntity<?> saveContactPhone(@PathVariable Integer contactId, @RequestBody @Valid AddContactPhoneDTO addContactPhone) {
		var response = contactPhoneService.saveContactPhone(contactId, addContactPhone);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
