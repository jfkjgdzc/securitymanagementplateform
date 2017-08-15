package com.hotent.platform.service.system;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.hotent.BaseTestCase;
import com.hotent.core.cache.ICache;
import com.hotent.core.util.AppUtil;

public class CacheTest extends BaseTestCase{
	
	@Test
	public void testCache(){
		ICache icache=AppUtil.getBean(ICache.class);
//		Map<String ,String> usersMap= (Map<String ,String>) icache.getByKey("ONLINE_USERS");
//		if(usersMap==null){
		Map<String ,String>	usersMap=new HashMap<String ,String>();
//			usersMap.put("a", "a");
//			
//			usersMap.put("b", "b");
//			usersMap.put("c", "c");
//			
			icache.add("ONLINE_USERS", usersMap);
			
			
//		}
		
		
		Map<String ,String> usersMap1= (Map<String ,String>) icache.getByKey("ONLINE_USERS");
		
		System.out.println("usersMap1");
		
	}

}
