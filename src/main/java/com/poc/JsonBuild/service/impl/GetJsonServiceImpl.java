package com.poc.JsonBuild.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.poc.JsonBuild.entity.RequestItem;
import com.poc.JsonBuild.entity.RequestJson;
import com.poc.JsonBuild.entity.ResponseJson;
import com.poc.JsonBuild.helper.JsonHelper;
import com.poc.JsonBuild.helper.QueryHelper;
import com.poc.JsonBuild.service.GetJsonService;

@Service
public class GetJsonServiceImpl implements GetJsonService {

	@Autowired
	private JsonHelper jsonHelper;
	
	@Override
	public ResponseEntity<ResponseJson> createJsonService(RequestJson req) {

		String query = "";
		String appId = "";
		String returnType = "";

		appId = String.join("_", "GET", req.getTableName(), "SQL");
		query = QueryHelper.getQuery(req.getInputParam(), req.getOutputParam(), req.getTableName());
		returnType = jsonHelper.getReturnType(req.getOutputParam());
		List<RequestItem> retrList = jsonHelper.getRetrList(req.getTableName(), req.getOutputParam());
		ResponseJson respJson = new ResponseJson();
		respJson.setAppId(appId);
		respJson.setQuery(query);
		respJson.setReqList(retrList);
		respJson.setReturnType(returnType);

		HttpStatus status = HttpStatus.OK;

		HttpHeaders headers = new HttpHeaders();
		headers.add("JsonCreated", "All ok");

		ResponseEntity<ResponseJson> response = new ResponseEntity<ResponseJson>(respJson, headers, status);
		return response;
	}

}
