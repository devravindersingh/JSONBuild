package com.poc.JsonBuild.helper;

import org.springframework.stereotype.Component;

@Component
public class TypeHandler {
	public String getType(int type) {
		if(type == 12)
			return "String";
		else if(type == 93)
			return "Date";
		else
			return "Not Supported";
	}
}
