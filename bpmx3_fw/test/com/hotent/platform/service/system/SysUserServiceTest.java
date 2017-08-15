/**
 * Copyright (c) 2017,XX有限公司 All rights reserved.
 */
package com.hotent.platform.service.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.hotent.BaseTestCase;
import com.hotent.platform.model.system.SysUser;

/**
 * 2017年6月6日，由<a href="mailto:hjb07@tom.com">黄金宝</a>创建了初始版本
 *
 * @author <a href="mailto:hjb07@tom.com">黄金宝</a>
 * @projectname bpmx3_dev
 * @package com.hotent.platform.service.system
 * @filename SysUserServiceTest.java
 * @date 2017年6月6日-上午9:21:48
 * @since 
 * @see 
 * @history 
 */
public class SysUserServiceTest extends BaseTestCase {
	
	@Resource
	SysUserService sysUserService;
	
	public void testgetUsersAll(){
		List<SysUser> list = sysUserService.getAll();
		System.out.println(list.size());
		for (SysUser info : list) {
			System.out.println(info);
		}
	}
	
	@Test
	public void testAdd(){
		SysUser user = new SysUser();
		
		user.setAccount("liyusheng");
//		user.setCreatetime(new Date());
//		user.setFromType((short) 0);
		user.setFullname("李雨生");
//		user.setHasSyncToWx(0);
//		user.setIsExpired((short) 0);
//		user.setIsLock((short) 0);
		user.setPassword("123");
//		user.setSex("1");
//		user.setStatus((short)1);
		user.setUserId(10000000050001L);
		
		sysUserService.add(user);
		
	}
	
	
}

