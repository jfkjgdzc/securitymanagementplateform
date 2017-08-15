/**
 * Copyright (c) 2017,XX有限公司 All rights reserved.
 */
package com.hotent.platform.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.hotent.BaseTestCase;
import com.hotent.platform.model.system.Position;

/**
 * 2017年6月7日，由<a href="mailto:hjb07@tom.com">黄金宝</a>创建了初始版本
 *
 * @author <a href="mailto:hjb07@tom.com">黄金宝</a>
 * @projectname bpmx3_dev
 * @package com.hotent.platform.service.system
 * @filename PositionServiceTest.java
 * @date 2017年6月7日-上午9:07:02
 * @since 
 * @see 
 * @history 
 */
public class PositionServiceTest extends BaseTestCase {
	
	@Resource
	private PositionService positionService;
	
	@Test
	public void testGetAll(){
		List<Position> list = positionService.getAll();
		System.out.println(list.size());
		for (Position sysOrgType : list) {
			System.out.println(sysOrgType);
		}
	}
	
}

