package org.jast.apps.gcp.cloudsql.dtos;

import javax.validation.constraints.NotBlank;

public class AddContactDTO {
	@NotBlank(message = "The first name is required")
	private String firstName;
	@NotBlank(message = "The last name name is required")
	private String lastName;
	@NotBlank(message = "The address name is required")
	private String address;

	public AddContactDTO() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
