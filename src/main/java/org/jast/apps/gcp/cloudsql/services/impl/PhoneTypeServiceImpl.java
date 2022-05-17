package org.jast.apps.gcp.cloudsql.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jast.apps.gcp.cloudsql.daos.PhoneTypeDAO;
import org.jast.apps.gcp.cloudsql.dtos.PhoneTypeDTO;
import org.jast.apps.gcp.cloudsql.mappers.PhoneTypeMapper;
import org.jast.apps.gcp.cloudsql.services.PhoneTypeService;
import org.springframework.stereotype.Service;

@Service
public class PhoneTypeServiceImpl implements PhoneTypeService {
	private PhoneTypeDAO phoneTypeDAO;
	private PhoneTypeMapper phoneTypeMapper;
	
	public PhoneTypeServiceImpl(PhoneTypeDAO phoneTypeDAO, PhoneTypeMapper phoneTypeMapper) {
		this.phoneTypeDAO = phoneTypeDAO;
		this.phoneTypeMapper = phoneTypeMapper;
	}
	
	@Override
	public List<PhoneTypeDTO> getPhoneTypes() {
		var phoneTypes = phoneTypeDAO.getAll();
		
		return phoneTypes.stream().map(phoneTypeMapper::toPhoneTypeDTO).collect(Collectors.toList());
	}

}
