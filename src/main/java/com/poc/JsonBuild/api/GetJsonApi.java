package com.poc.JsonBuild.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poc.JsonBuild.entity.RequestJson;
import com.poc.JsonBuild.entity.ResponseJson;

public interface GetJsonApi {
	@PostMapping(value = "/getJson")
	ResponseEntity<ResponseJson> createJson(@RequestBody RequestJson requestJson);
}
