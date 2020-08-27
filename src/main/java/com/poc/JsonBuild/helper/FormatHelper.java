package com.poc.JsonBuild.helper;

import org.springframework.stereotype.Component;

import com.google.common.base.CaseFormat;

@Component
public class FormatHelper {

	public String getFieldNameInCamerlCase(String field) {
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, field);
	}
}
