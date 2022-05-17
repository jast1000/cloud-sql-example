package org.jast.apps.gcp.cloudsql.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddContactPhoneDTO {
	@Size(min = 10, max = 10, message = "The phone number should has 10 numbers")
	private String number;
	@NotNull(message = "The phone type identifier is required")
	private Integer phoneTypeId;
	
	public AddContactPhoneDTO() {
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getPhoneTypeId() {
		return phoneTypeId;
	}

	public void setPhoneTypeId(Integer phoneTypeId) {
		this.phoneTypeId = phoneTypeId;
	}
}
