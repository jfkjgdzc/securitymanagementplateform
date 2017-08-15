package com.hotent.core.util;

import com.hotent.BaseTestCase;
import com.hotent.core.db.datasource.JdbcTemplateUtil;

public class DbTest extends BaseTestCase {

	
	
	@org.junit.Test
	public void testSQL(){
		
		String sql="declare "+
				" v_objid int; "+
				" begin " +
				" v_objid:=1; "+
				" update sys_user t  set t.fullname='超级管理员2' where t.userid=v_objid; "+
				"end;";
		
		JdbcTemplateUtil.execute(sql);
		
	}
	
	
	@org.junit.Test
	public void testProc(){
		String sql="call PROC_UPDATE_USER(1,'我是老板')";
		
		JdbcTemplateUtil.execute(sql);
	}
	
	
	@org.junit.Test
	public void testProcDS() throws Exception{
		String sql="call PROC_UPDATE_USER(1,'我是老板1')";
		
		JdbcTemplateUtil.execute("orcleLocal",sql);
	}
	
	
	
}
