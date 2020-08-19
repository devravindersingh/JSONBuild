package com.poc.JsonBuild.entity;

public class MetaTableData {

	private String field;
	private String type;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public MetaTableData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MetaTableData [field=" + field + ", type=" + type + "]";
	}

	
}
