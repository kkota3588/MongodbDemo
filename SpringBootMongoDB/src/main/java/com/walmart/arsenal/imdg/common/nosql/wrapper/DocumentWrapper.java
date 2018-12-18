package com.walmart.arsenal.imdg.common.nosql.wrapper;

import javax.persistence.Id;

public class DocumentWrapper {

	@Id
	private String id;

	private Class<?> classType;
	private String objectJsonString;

	public DocumentWrapper() {
	}

	public DocumentWrapper(String _id, String objectJsonString, Class<?> classType) {
		this.id = _id;
		this.objectJsonString = objectJsonString;
		this.classType = classType;
	}

	public String getObjectJsonString() {
		return objectJsonString;
	}

	public void setObjectJsonString(String objectJsonString) {
		this.objectJsonString = objectJsonString;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class<?> getClassType() {
		return classType;
	}

	public void setClassType(Class<?> classType) {
		this.classType = classType;
	}

}
