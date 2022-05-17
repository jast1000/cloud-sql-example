package org.jast.apps.gcp.cloudsql.controllers.impl;

import org.jast.apps.gcp.cloudsql.controllers.PhoneTypeController;
import org.jast.apps.gcp.cloudsql.dtos.PhoneTypeDTO;
import org.jast.apps.gcp.cloudsql.services.PhoneTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Phone types")
public class PhoneTypeControllerImpl implements PhoneTypeController {

	private final PhoneTypeService phoneTypeService;
	
	public PhoneTypeControllerImpl(PhoneTypeService phoneTypeService) {
		this.phoneTypeService = phoneTypeService;
	}
	
	@Override
	@RequestMapping(
			value = "/phone-types", 
			method = RequestMethod.GET, 
			produces = "application/json")
	@ApiOperation(value = "Get the phone types")
	@ApiResponses(
			@ApiResponse(
					code = 200, 
					message = "Phone types retrivied", 
					response = PhoneTypeDTO.class,
					responseContainer = "List"))
	public ResponseEntity<?> getPhoneTypes() {
		var phoneTypes = phoneTypeService.getPhoneTypes();
		return ResponseEntity.ok(phoneTypes);
	}

}
