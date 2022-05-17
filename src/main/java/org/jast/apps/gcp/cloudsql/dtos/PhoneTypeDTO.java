package org.jast.apps.gcp.cloudsql.dtos;

public class PhoneTypeDTO {
	private Integer phoneTypeId;
	private String description;
	
	public PhoneTypeDTO() {
	}

	public Integer getPhoneTypeId() {
		return phoneTypeId;
	}

	public void setPhoneTypeId(Integer phoneTypeId) {
		this.phoneTypeId = phoneTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
