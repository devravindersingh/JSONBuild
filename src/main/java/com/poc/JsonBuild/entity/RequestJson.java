package com.poc.JsonBuild.entity;

public class RequestJson {
	private String inputParam;
	private String outputParam;
	private String tableName;
	public String getInputParam() {
		return inputParam;
	}
	public void setInputParam(String inputParam) {
		this.inputParam = inputParam;
	}
	public String getOutputParam() {
		return outputParam;
	}
	public void setOutputParam(String outputParam) {
		this.outputParam = outputParam;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public RequestJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RequestItem [inputParam=" + inputParam + ", outputParam=" + outputParam + ", tableName=" + tableName
				+ "]";
	}
	
}
