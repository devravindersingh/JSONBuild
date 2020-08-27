package com.poc.JsonBuild.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.JsonBuild.entity.MetaTableData;
import com.poc.JsonBuild.repository.CreateJsonRepo;
@Component
public class QueryHelper {
	
	@Autowired
	private JsonHelper jsonHelper;
	
	@Autowired
	private CreateJsonRepo crudRepo;
	
	@Autowired
	private FormatHelper formatHelper;

	public String getQuery(String whereClause, String selectParam, String tableName) {
		String finalQuery = "";
		String outputParams = ""; 
		String wherePart = "";
		
		List<MetaTableData> metaList = crudRepo.findByTableName(tableName);
		
		if(selectParam.isEmpty() || selectParam == null) {
			outputParams = formatSelectParam(metaList);
		}else {
			metaList = jsonHelper.getFilterMetalist(metaList, selectParam);
			outputParams = formatSelectParam(metaList);
		}
		
		if(whereClause.isEmpty() || whereClause == null) {
			wherePart = "";
		}else {
			wherePart = whereClause;
		}
		
		finalQuery = String.join(" ", "Select", outputParams, "From", tableName , wherePart);
		return finalQuery;
	}
	
	private String formatSelectParam(List<MetaTableData> metaList) {
		return metaList.stream()
				.map(mtl -> mtl.getField() + " " + formatHelper.getFieldNameInCamerlCase(mtl.getField()))
				.collect(Collectors.joining(","));
	}
	
//	public static String createWhere(String inputParam) {
//		String whereFinal = "Where";
//		List<String> paramList = Arrays.asList(inputParam.split(",")).stream()
//        	    .map(s -> new String(""+s + "=:" + s))
//        	    .collect(Collectors.toList());
//        String wherePart = String.join(" And ", paramList);
//		whereFinal = String.join(" ", whereFinal, wherePart);
//		return whereFinal;
//	}
	
}
