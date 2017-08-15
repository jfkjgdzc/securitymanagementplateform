package com.hotent.platform.service.system;

import java.util.Map;

import javax.annotation.Resource;

import com.hotent.BaseTestCase;
import com.hotent.core.db.IRollBack;
import com.hotent.core.db.RollbackJdbcTemplate;

public class RollBackTest extends BaseTestCase{
	
	@Resource
	private RollbackJdbcTemplate rollbackJdbcTemplate;
	@Resource
	private IdentityService identityService;
	
	@org.junit.Test
	public void genIdentity(){
		Object obj= rollbackJdbcTemplate.executeRollBack(new IRollBack() {
			
			@Override
			public Object execute(String script, Map<String, Object> map) {
				String id=identityService.preview(script);
				return id;
			}
		}, "spLiuShui", null);
		System.out.println(obj);
	}

}
