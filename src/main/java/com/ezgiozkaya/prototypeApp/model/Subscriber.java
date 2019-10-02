package com.ezgiozkaya.prototypeApp.model;

import java.io.Serializable;

public class Subscriber implements Serializable {

	private Long id;
	private String name;
	private String msisdn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Subscriber(Long id, String name, String msisdn) {
		super();
		this.id = id;
		this.name = name;
		this.msisdn = msisdn;
	}

}
