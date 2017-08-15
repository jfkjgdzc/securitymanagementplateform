package com.hotent.platform.dao.system;

import java.util.HashMap;
import java.util.Map;

import javax.xml.soap.SOAPMessage;

import com.hotent.BaseTestCase;
import com.hotent.platform.service.bpm.WebserviceHelper;

public class WebServcieHelperTest  extends BaseTestCase {
	
	@org.junit.Test
	public void testWebService(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			 String executeXml = WebserviceHelper.executeXml("getRegionProvince", map);
			
			System.out.println(executeXml);
			
			SOAPMessage executeObj = WebserviceHelper.executeObj("getRegionProvince", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
