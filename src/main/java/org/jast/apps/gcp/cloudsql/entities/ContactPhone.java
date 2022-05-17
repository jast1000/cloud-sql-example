package org.jast.apps.gcp.cloudsql.entities;

import java.time.LocalDateTime;

public class ContactPhone {
	private Integer contactPhoneId;
	private Integer contactId;
	private String number;
	private Integer phoneTypeId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public ContactPhone() {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
