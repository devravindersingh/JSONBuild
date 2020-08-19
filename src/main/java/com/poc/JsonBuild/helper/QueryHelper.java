package com.poc.JsonBuild.helper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
@Component
public class QueryHelper {

	public static String getQuery(String inputParam, String outputParam, String tableName) {
		String finalQuery = "";
		String outputParams = ""; 
		String wherePart = "";
		
		if(outputParam.isEmpty() || outputParam == null) {
			outputParams = "*";
		}else {
			outputParams = outputParam;
		}
		
		if(inputParam.isEmpty() || inputParam == null) {
			wherePart = "";
		}else {
			wherePart = createWhere(inputParam);
		}
		
		finalQuery = String.join(" ", "Select", outputParams, "From", tableName , wherePart);
		return finalQuery;
	}
	
	public static String createWhere(String inputParam) {
		String whereFinal = "Where";
		List<String> paramList = Arrays.asList(inputParam.split(",")).stream()
        	    .map(s -> new String(""+s + "=:" + s))
        	    .collect(Collectors.toList());
        String wherePart = String.join(" And", paramList);
		whereFinal = String.join(" ", whereFinal, wherePart);
		return whereFinal;
	}
	
}
