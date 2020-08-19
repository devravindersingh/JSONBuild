package com.poc.JsonBuild.repository;

import java.util.List;

import com.poc.JsonBuild.entity.MetaTableData;


public interface CreateJsonRepo{

	public List<MetaTableData> findByTableName(String tableName);
}
