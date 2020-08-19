package com.poc.JsonBuild.entity;

public class RequestItem {

	private String name;
	private String format;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public RequestItem(String name, String format, String type) {
		super();
		this.name = name;
		this.format = format;
		this.type = type;
	}
	@Override
	public String toString() {
		return "RequestItem [name=" + name + ", format=" + format + ", type=" + type + "]";
	}
	
	
}
