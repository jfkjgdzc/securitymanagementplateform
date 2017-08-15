package com.hotent.platform.dao.system;

import java.util.Date;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hotent.BaseTestCase;
import com.hotent.core.util.AppUtil;
import com.hotent.core.util.TimeUtil;

public class AtsTest  extends BaseTestCase  {
	
	@Test
	public void atsRecordAdd(){
		String json="[{c:\"zyg\",t:\"2010-09-10 09:21:56\"},{c:\"zhouyh\",t:\"2015-09-10 21:31:56\"}]";
		JSONArray ary=JSONArray.parseArray(json);
		JdbcTemplate jdbcTemplate=(JdbcTemplate) AppUtil.getBean("jdbcTemplate");
		String sql="insert into ats_card_record (card_number,card_date,CARD_SOURCE) values (?,?,1)";
		
		for(int i=0;i<ary.size();i++){
			JSONObject obj=ary.getJSONObject(i);
			final String cardNo=obj.getString("c");
			String strDate=obj.getString("t");
			final Date date=TimeUtil.convertString(strDate);
			jdbcTemplate.update(sql, cardNo,date);
			
		}
	}

}
