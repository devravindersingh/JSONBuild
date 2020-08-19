package com.poc.JsonBuild.service;

import org.springframework.http.ResponseEntity;

import com.poc.JsonBuild.entity.RequestJson;
import com.poc.JsonBuild.entity.ResponseJson;

public interface GetJsonService {
 ResponseEntity<ResponseJson> createJsonService(RequestJson req);
}
