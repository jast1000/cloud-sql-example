package org.jast.apps.gcp.cloudsql.mappers;

import org.jast.apps.gcp.cloudsql.dtos.PhoneTypeDTO;
import org.jast.apps.gcp.cloudsql.entities.PhoneType;
import org.springframework.stereotype.Component;

@Component
public class PhoneTypeMapper {

	public PhoneTypeDTO toPhoneTypeDTO(PhoneType phoneType) {
		var phoneTypeDTO = new PhoneTypeDTO();
		phoneTypeDTO.setPhoneTypeId(phoneType.getPhoneTypeId());
		phoneTypeDTO.setDescription(phoneType.getDescription());
				
		return phoneTypeDTO;
	}	
}
