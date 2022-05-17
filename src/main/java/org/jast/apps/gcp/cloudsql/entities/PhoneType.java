package org.jast.apps.gcp.cloudsql.entities;

public class PhoneType {
	private Integer phoneTypeId;
	private String description;
	
	public PhoneType() {
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
