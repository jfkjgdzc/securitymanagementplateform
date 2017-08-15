package com.hotent.platform.service.weixin;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.hotent.BaseTestCase;
import com.hotent.platform.model.form.BpmFormTable;
import com.hotent.platform.service.form.BpmFormTableService;
import com.hotent.weixin.service.IWeixinFormService;

public class WeixinFormServiceTest extends BaseTestCase {
	
	@Resource
	IWeixinFormService weixinFormService;
	@Resource
	BpmFormTableService bpmFormTableService;
	
	
}
