package org.jast.apps.gcp.cloudsql.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddUserDTO {
	@NotBlank(message = "Full name is required")
	private String fullName;
	@NotBlank(message = "Username is required")
	@Size(min = 8, message = "The username should have minimum 8 letters")
	private String username;
	@NotBlank(message = "Password is required")
	@Size(min = 10, message = "The password should have minimum 10 letters")
	private String password;
	
	public AddUserDTO() {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
