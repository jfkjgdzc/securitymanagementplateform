/**
 * Copyright (c) 2017,XX有限公司 All rights reserved.
 */
package com.hotent.platform.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.hotent.BaseTestCase;
import com.hotent.platform.model.system.Demension;

/**
 * 2017年6月6日，由<a href="mailto:hjb07@tom.com">黄金宝</a>创建了初始版本
 *
 * @author <a href="mailto:hjb07@tom.com">黄金宝</a>
 * @projectname bpmx3_dev
 * @package com.hotent.platform.service.system
 * @filename DemensionServiceTest.java
 * @date 2017年6月6日-上午9:47:33
 * @since 
 * @see 
 * @history 
 */
public class DemensionServiceTest extends BaseTestCase {
	
	@Resource
	DemensionService demensionService;
	
	
	/*
	com.hotent.platform.model.system.Demension@b0d2864[demId=10000000410009,demName=公司组织,demDesc=公司组织]
	com.hotent.platform.model.system.Demension@cd6c2e7[demId=1,demName=行政维度,demDesc=行政维度]
	 * */
	@Test
	public void testGetAll(){
		List<Demension> list = demensionService.getAll();
		System.out.println(list.size());
		for (Demension demension : list) {
			System.out.println(demension);
		}
	}
	
	@Test
	public void testremove(){
		Long id = 2L;
		demensionService.delById(id);
	}
	
	@Test
	public void testAdd(){
		Demension entity = new Demension();
		String demName = "远年";
		String demDesc = "远年";
		
		entity.setDemId(2L);
		entity.setDemName(demName);
		entity.setDemDesc(demDesc);
		demensionService.add(entity);
	}
	
}

