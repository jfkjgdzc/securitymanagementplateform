package com.hotent.platform.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.hotent.BaseTestCase;
import com.hotent.platform.model.system.Job;

public class JobServiceTest extends BaseTestCase {
	@Resource
	private JobService jobService;
	
	@Test
	public void testGetAll(){
		List<Job> list = jobService.getAll();
		System.out.println(list.size());
		for (Job sysOrgType : list) {
			System.out.println(sysOrgType);
		}
	}
}
