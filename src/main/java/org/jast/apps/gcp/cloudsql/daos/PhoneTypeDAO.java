package org.jast.apps.gcp.cloudsql.daos;

import java.util.List;

import org.jast.apps.gcp.cloudsql.entities.PhoneType;

public interface PhoneTypeDAO {
	List<PhoneType> getAll();
}