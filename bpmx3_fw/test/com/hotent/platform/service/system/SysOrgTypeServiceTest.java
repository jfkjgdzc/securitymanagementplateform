/**
 * Copyright (c) 2017,XX有限公司 All rights reserved.
 */
package com.hotent.platform.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.hotent.BaseTestCase;
import com.hotent.platform.model.system.SysOrgType;

/**
 * 2017年6月6日，由<a href="mailto:hjb07@tom.com">黄金宝</a>创建了初始版本
 *
 * @author <a href="mailto:hjb07@tom.com">黄金宝</a>
 * @projectname bpmx3_dev
 * @package com.hotent.platform.service.system
 * @filename SysOrgTypeServiceTest.java
 * @date 2017年6月6日-下午2:41:35
 * @since 
 * @see 
 * @history 
 */
public class SysOrgTypeServiceTest extends BaseTestCase {
	
	@Resource
	private SysOrgTypeService sysOrgTypeService;
	
	@Test
	public void testGetAll(){
		List<SysOrgType> list = sysOrgTypeService.getAll();
		System.out.println(list.size());
		for (SysOrgType sysOrgType : list) {
			System.out.println(sysOrgType);
		}
	}
	
	@Test
	public void testAdd(){
		
		SysOrgType sysOrgType = new SysOrgType();
		sysOrgType.setId(10L);
		sysOrgType.setDemId(2L);
		sysOrgType.setName("鉴定组");
		sysOrgType.setLevels(2L);
		sysOrgTypeService.add(sysOrgType);
		System.out.println("完成保存");
		
	}
	
	@Test
	public void testdel(){
		Long id = 10L;
		sysOrgTypeService.delById(id);
		System.out.println("完成删除");
	}
	
}

