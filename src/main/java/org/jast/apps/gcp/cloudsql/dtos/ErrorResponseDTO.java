package org.jast.apps.gcp.cloudsql.dtos;

import java.util.List;

public class ErrorResponseDTO {
	private String code;
	private String message;
	private List<String> details;

	public ErrorResponseDTO(String code, String message, List<String> details) {
		super();
		this.code = code;
		this.message = message;
		this.details = details;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
}
