package com.poc.JsonBuild.entity;

import java.util.List;

public class ResponseJson {
	
	private String appId;
	private String connName = "";
	private String reqType = "Query";
	private String query;
	private String returnType;
	private List<RequestItem> reqList;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		
		this.returnType = returnType;
	}
	public List<RequestItem> getReqList() {
		return reqList;
	}
	public void setReqList(List<RequestItem> reqList) {
		this.reqList = reqList;
	}
	public String getConnName() {
		return connName;
	}
	public String getReqType() {
		return reqType;
	}
	public ResponseJson() {
		super();
	}
	
	
}
