package org.jast.apps.gcp.cloudsql.exceptions;

import org.jast.apps.gcp.cloudsql.enums.EntityType;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer identifier;
	private EntityType entityType;
	
	public NotFoundException(Integer identifier, EntityType entityType) {
		this.identifier = identifier;
		this.entityType = entityType;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public EntityType getEntityType() {
		return entityType;
	}	
}
