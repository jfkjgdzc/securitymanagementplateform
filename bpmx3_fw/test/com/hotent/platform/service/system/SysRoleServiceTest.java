/**
 * Copyright (c) 2017,XX有限公司 All rights reserved.
 */
package com.hotent.platform.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.hotent.BaseTestCase;
import com.hotent.platform.model.system.SysRole;

/**
 * 2017年6月6日，由<a href="mailto:hjb07@tom.com">黄金宝</a>创建了初始版本
 *
 * @author <a href="mailto:hjb07@tom.com">黄金宝</a>
 * @projectname bpmx3_dev
 * @package com.hotent.platform.service.system
 * @filename SysRoleServiceTest.java
 * @date 2017年6月6日-上午10:03:00
 * @since 
 * @see 
 * @history 
 */
public class SysRoleServiceTest extends BaseTestCase {
	
	private @Resource SysRoleService sysRoleService;
	
	@Test
	public void test(){
		List<SysRole> list = sysRoleService.getAll();
		System.out.println(list.size());
		for (SysRole sysRole : list) {
			System.out.println(sysRole);
		}
	}

}

