package com.hotent.platform.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hotent.BaseTestCase;


public class JdbcTemplateTest extends BaseTestCase{
	
	@Resource(name="jdbcTemplate")
	JdbcTemplate jdbcTemplate;

	@org.junit.Test
	public void templateTest() throws SQLException{
		
		String sql="select * from sys_user where 1=0 and userid=? and CREATETIME>=?";
		
		Connection conn=jdbcTemplate.getDataSource().getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setObject(1, null);
		ps.setObject(2, null);
		ResultSetMetaData rs= ps.getMetaData();
		int count= rs.getColumnCount();
		for(int i=1;i<=count;i++){
			System.out.println(rs.getColumnName(i));
		}
		conn.close();
		
	}
	
	public static void main(String[] args) {
		String sql="select * from sys_user where userid=? and CREATETIME>=?" +
				" union " +
				" select * from sys_user where userid=? and CREATETIME>=?";
		
		
		sql=sql.replaceAll("where", "where 1=0 and ");
		
		System.out.println(sql);
		
		
		
		
		
	}
}
