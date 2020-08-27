package com.poc.JsonBuild.entity;

public class RequestJson {
	private String whereClause;
	private String selectParams;
	private String tableName;
	public String getWhereClause() {
		return whereClause;
	}
	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}
	public String getSelectParams() {
		return selectParams;
	}
	public void setSelectParams(String selectParams) {
		this.selectParams = selectParams;
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
	
	
}
