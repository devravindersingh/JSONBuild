package com.poc.JsonBuild.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.poc.JsonBuild.api.GetJsonApi;
import com.poc.JsonBuild.entity.RequestJson;
import com.poc.JsonBuild.entity.ResponseJson;
import com.poc.JsonBuild.service.GetJsonService;

@RestController
public class GetJsonController implements GetJsonApi {

	@Autowired
	GetJsonService service;
	
	@Override
	public ResponseEntity<ResponseJson> createJson(RequestJson requestJson) {
		
		ResponseEntity<ResponseJson> response = service.createJsonService(requestJson);
		return response;
	}

}
