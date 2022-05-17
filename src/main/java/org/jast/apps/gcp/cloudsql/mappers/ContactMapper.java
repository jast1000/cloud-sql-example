package org.jast.apps.gcp.cloudsql.mappers;

import org.jast.apps.gcp.cloudsql.dtos.AddContactDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddContactResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.ContactDTO;
import org.jast.apps.gcp.cloudsql.entities.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

	public Contact toContact(Integer userId, AddContactDTO addContact) {
		var contact = new Contact();
		contact.setAddress(addContact.getAddress());
		contact.setFirstName(addContact.getFirstName());
		contact.setLastName(addContact.getLastName());
		contact.setUserId(userId);
		
		return contact;
	}
	
	public AddContactResponseDTO toAddContactResponseDTO(Contact contact) {
		var addContactResponse = new AddContactResponseDTO();
		addContactResponse.setAddress(contact.getAddress());
		addContactResponse.setContactId(contact.getContactId());
		addContactResponse.setFirstName(contact.getFirstName());
		addContactResponse.setLastName(contact.getLastName());
		addContactResponse.setUserId(contact.getUserId());
		
		return addContactResponse;
	}
	
	public ContactDTO toContactDTO(Contact contact) {
		var contactDTO = new ContactDTO();
		contactDTO.setAddress(contact.getAddress());
		contactDTO.setContactId(contact.getContactId());
		contactDTO.setFirstName(contact.getFirstName());
		contactDTO.setLastName(contact.getLastName());
		contactDTO.setUserId(contact.getUserId());
		contactDTO.setCreatedAt(contact.getCreatedAt());
		contactDTO.setUpdatedAt(contact.getUpdatedAt());
		
		return contactDTO;
	}
}
