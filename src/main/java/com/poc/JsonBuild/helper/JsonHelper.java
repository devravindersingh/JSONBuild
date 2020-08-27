package com.poc.JsonBuild.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.JsonBuild.entity.MetaTableData;
import com.poc.JsonBuild.entity.RequestItem;
import com.poc.JsonBuild.repository.CreateJsonRepoimpl;

@Component
public class JsonHelper {

	@Autowired
	private CreateJsonRepoimpl crudRepo;
	
	@Autowired
	private FormatHelper formatHelper;
	
	public String getReturnType(String outputParam) {
		String retType = outputParam.split(",").length > 1 ? "Multiple" : "Single"; 
		return retType;
	}

	public List<RequestItem> getRetrList(String tableName, String selectParam) {
		List<MetaTableData> metaList = crudRepo.findByTableName(tableName);
		List<RequestItem> retrList = new ArrayList<RequestItem>();
		if(!selectParam.isEmpty() && !selectParam.equals("*")) {
			metaList = getFilterMetalist(metaList, selectParam);
		}
		
		retrList = metaList.stream().map(mtl -> {
						RequestItem reqI = new RequestItem(formatHelper.getFieldNameInCamerlCase(mtl.getField()), "", mtl.getType());
						return reqI;
						}
					).collect(Collectors.toList());
				
		return retrList;
	}
	
	public List<MetaTableData> getFilterMetalist(List<MetaTableData> metaList, String selectParam){
		List<String> outputParamList = Arrays.asList(selectParam.split(","));
		metaList = metaList.stream()
				.filter(mtl -> outputParamList.stream().
						anyMatch(ol -> mtl.getField().equals(ol)))
				.collect(Collectors.toList());
		return metaList;
	}

}
