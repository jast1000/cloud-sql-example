package org.jast.apps.gcp.cloudsql.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jast.apps.gcp.cloudsql.daos.ContactDAO;
import org.jast.apps.gcp.cloudsql.daos.UserDAO;
import org.jast.apps.gcp.cloudsql.dtos.AddContactDTO;
import org.jast.apps.gcp.cloudsql.dtos.AddContactResponseDTO;
import org.jast.apps.gcp.cloudsql.dtos.ContactDTO;
import org.jast.apps.gcp.cloudsql.entities.Contact;
import org.jast.apps.gcp.cloudsql.enums.EntityType;
import org.jast.apps.gcp.cloudsql.exceptions.NotFoundException;
import org.jast.apps.gcp.cloudsql.mappers.ContactMapper;
import org.jast.apps.gcp.cloudsql.services.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
	private ContactDAO contactDAO;
	private ContactMapper contactMapper;
	private UserDAO userDAO;
	
	public ContactServiceImpl(ContactDAO contactDAO, ContactMapper contactMapper, UserDAO userDAO) {
		this.contactDAO = contactDAO;
		this.contactMapper = contactMapper;
		this.userDAO = userDAO;
	}
	
	@Override
	public AddContactResponseDTO saveContact(Integer userId, AddContactDTO addContact) {
		if (!userDAO.exists(userId)) throw new NotFoundException(userId, EntityType.User);
		
		Contact contact = contactMapper.toContact(userId, addContact);
		contact = contactDAO.save(contact);
		return contactMapper.toAddContactResponseDTO(contact);
	}

	@Override
	public List<ContactDTO> getContacts(Integer userId) {
		if (!userDAO.exists(userId)) throw new NotFoundException(userId, EntityType.User);
		
		var contacts = contactDAO.getAll(userId);
		return contacts.stream().map(contactMapper::toContactDTO).collect(Collectors.toList());
	}

}
