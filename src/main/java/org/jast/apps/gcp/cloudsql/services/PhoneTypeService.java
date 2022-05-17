package org.jast.apps.gcp.cloudsql.services;

import java.util.List;

import org.jast.apps.gcp.cloudsql.dtos.PhoneTypeDTO;

public interface PhoneTypeService {
	List<PhoneTypeDTO> getPhoneTypes();
}
