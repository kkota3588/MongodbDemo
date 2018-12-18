package com.walmart.arsenal.imdg.common.nosql.wrapper;

import org.springframework.data.annotation.Id;

public class DocumentKeys {

	@Id
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
