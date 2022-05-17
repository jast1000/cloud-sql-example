package org.jast.apps.gcp.cloudsql.dtos;

public class AddContactPhoneResponseDTO {
	private Integer contactPhoneId;
	private Integer contactId;
	private String number;
	private Integer phoneTypeId;

	public AddContactPhoneResponseDTO() {
	}

	public Integer getContactPhoneId() {
		return contactPhoneId;
	}

	public void setContactPhoneId(Integer contactPhoneId) {
		this.contactPhoneId = contactPhoneId;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
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
