package com.poc.JsonBuild.repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.poc.JsonBuild.entity.MetaTableData;
import com.poc.JsonBuild.helper.TypeHandler;

@Component
public class CreateJsonRepoimpl implements CreateJsonRepo {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private TypeHandler handleType;
	
	@Override
	public List<MetaTableData> findByTableName(String tableName) {
		String query = "Select * from " + tableName +" limit 1";
		List<MetaTableData> fList = jdbc.query(query,new ResultSetExtractor<List<MetaTableData>>(){  
		    @Override  
		     public List<MetaTableData> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<MetaTableData> list=new ArrayList<MetaTableData>();  
		        ResultSetMetaData rsMData = rs.getMetaData();
		        int columnsCount = rsMData.getColumnCount();
		        while(columnsCount!=0){  
		        	MetaTableData e = new MetaTableData();  
		        	e.setField(rsMData.getColumnName(columnsCount));
		        	e.setType(handleType.getType(rsMData.getColumnType(columnsCount)));
		        	columnsCount--;
		        	list.add(e);  
		        }  
		        return list;  
		        }  
		    });   
		return fList;
	}

}
