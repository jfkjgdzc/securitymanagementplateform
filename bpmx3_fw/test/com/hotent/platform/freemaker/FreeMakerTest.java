package com.hotent.platform.freemaker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.hotent.BaseTestCase;
import com.hotent.core.engine.FreemarkEngine;

import freemarker.template.TemplateException;

public class FreeMakerTest  extends BaseTestCase {
	
	@Resource
	FreemarkEngine freeMaker;
	
	@org.junit.Test
	public void merge() throws TemplateException, IOException{
		Map map=new HashMap();
		map.put("to", 5);
		String str="<#list 1..${to} as x>${x}</#list>";
		String out= freeMaker.parseByStringTemplate(map, str);
		System.out.println(out);
	}
	
	@org.junit.Test
	public void testMacro() throws TemplateException, IOException{
		String str="<#macro test a ><#if (a>9)>大于9<#else>小于9</#if></#macro><@test 4/>";
		Map map=new HashMap();
		String out= freeMaker.parseByStringTemplate(map, str);
		System.out.println(out);
	}

}
