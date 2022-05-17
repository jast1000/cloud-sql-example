package org.jast.apps.gcp.cloudsql.mappers;

import org.jast.apps.gcp.cloudsql.dtos.AddContactPhoneDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddContactPhoneResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.ContactPhoneDTO;
import org.jast.apps.gcp.cloudsql.entities.ContactPhone;
import org.springframework.stereotype.Component;

@Component
public class ContactPhoneMapper {

	public ContactPhone toContactPhone(Integer contactId, AddContactPhoneDTO addContactPhone) {
		var contactPhone = new ContactPhone();
		contactPhone.setContactId(contactId);
		contactPhone.setNumber(addContactPhone.getNumber());
		contactPhone.setPhoneTypeId(addContactPhone.getPhoneTypeId());
		
		return contactPhone;
	}
	
	public AddContactPhoneResponseDTO toAddContactPhoneResponseDTO(ContactPhone contactPhone) {
		var addContactPhoneResponse = new AddContactPhoneResponseDTO();
		addContactPhoneResponse.setContactId(contactPhone.getContactId());
		addContactPhoneResponse.setContactPhoneId(contactPhone.getContactPhoneId());
		addContactPhoneResponse.setNumber(contactPhone.getNumber());
		addContactPhoneResponse.setPhoneTypeId(contactPhone.getPhoneTypeId());
		
		return addContactPhoneResponse;
	}
	
	public ContactPhoneDTO toContactPhoneDTO(ContactPhone contactPhone) {
		var contactPhoneDTO = new ContactPhoneDTO();
		contactPhoneDTO.setContactId(contactPhone.getContactId());
		contactPhoneDTO.setContactPhoneId(contactPhone.getContactPhoneId());
		contactPhoneDTO.setNumber(contactPhone.getNumber());
		contactPhoneDTO.setPhoneTypeId(contactPhone.getPhoneTypeId());
		contactPhoneDTO.setCreatedAt(contactPhone.getCreatedAt());
		contactPhoneDTO.setUpdatedAt(contactPhone.getUpdatedAt());
		
		return contactPhoneDTO;
	}
}
