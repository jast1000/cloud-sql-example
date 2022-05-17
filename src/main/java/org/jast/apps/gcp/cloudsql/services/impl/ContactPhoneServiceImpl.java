package org.jast.apps.gcp.cloudsql.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jast.apps.gcp.cloudsql.daos.ContactDAO;
import org.jast.apps.gcp.cloudsql.daos.ContactPhoneDAO;
import org.jast.apps.gcp.cloudsql.dtos.AddContactPhoneDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddContactPhoneResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.ContactPhoneDTO;
import org.jast.apps.gcp.cloudsql.enums.EntityType;
import org.jast.apps.gcp.cloudsql.exceptions.NotFoundException;
import org.jast.apps.gcp.cloudsql.mappers.ContactPhoneMapper;
import org.jast.apps.gcp.cloudsql.services.ContactPhoneService;
import org.springframework.stereotype.Service;

@Service
public class ContactPhoneServiceImpl implements ContactPhoneService {
	private final ContactDAO contactDAO;
	private final ContactPhoneDAO contactPhoneDAO;
	private final ContactPhoneMapper contactPhoneMapper;
	
	public ContactPhoneServiceImpl(ContactDAO contactDAO, ContactPhoneDAO contactPhoneDAO, ContactPhoneMapper contactPhoneMapper) {
		this.contactDAO = contactDAO;
		this.contactPhoneDAO = contactPhoneDAO;
		this.contactPhoneMapper = contactPhoneMapper;
	}

	@Override
	public List<ContactPhoneDTO> getContactPhones(Integer contactId) {
		if (!contactDAO.exists(contactId)) throw new NotFoundException(contactId, EntityType.Contact);
		
		var contactPhones = contactPhoneDAO.getAll(contactId);
		
		return contactPhones.stream().map(contactPhoneMapper::toContactPhoneDTO).collect(Collectors.toList());
	}

	@Override
	public AddContactPhoneResponseDTO saveContactPhone(Integer contactId, AddContactPhoneDTO addContactPhone) {
		if (!contactDAO.exists(contactId)) throw new NotFoundException(contactId, EntityType.Contact);
		
		var contactPhone = contactPhoneMapper.toContactPhone(contactId, addContactPhone);
		contactPhone = contactPhoneDAO.save(contactPhone);
		
		return contactPhoneMapper.toAddContactPhoneResponseDTO(contactPhone);
	}
	
}
