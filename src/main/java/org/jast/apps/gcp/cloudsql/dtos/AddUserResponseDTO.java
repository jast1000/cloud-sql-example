package org.jast.apps.gcp.cloudsql.dtos;

public class AddUserResponseDTO {
	private Integer userId;
	private String fullName;
	private String username;
	
	public AddUserResponseDTO() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
}
