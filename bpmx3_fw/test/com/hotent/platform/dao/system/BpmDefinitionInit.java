package com.hotent.platform.dao.system;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hotent.BaseTestCase;
import com.hotent.core.util.Dom4jUtil;
import com.hotent.core.util.FileUtil;
import com.hotent.platform.dao.bpm.BpmDao;

/**
 * 
 * 引擎升级到5.15.1，修改了流程定义的监听器设置方法
 * 5.14的为<activiti:executionListener class="com.hotent.platform.service.bpm.listener.StartEventListener" event="start" />
 * 修改后5.15.1的为<activiti:executionListener  event="start" delegateExpression="${startEventListener}" />
 * 因此旧的流程定义数据要做相应的同步
 * @author helh
 *
 */
public class BpmDefinitionInit extends BaseTestCase {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Resource
	private BpmDao bpmDao;
	
	@SuppressWarnings("unchecked")
	@Test
	public void execute() throws Exception {
		String path = new File("").getAbsolutePath() + File.separator
				+ "src/main/resources/conf/definitionInitConfig.xml";
		InputStream stream = new BufferedInputStream(new FileInputStream(path));
		String xml = FileUtil.inputStream2String(stream, "utf-8");
		stream.close();
		Document document = Dom4jUtil.loadXml(xml);
		Element root = document.getRootElement();
		List<Element> list = root.elements();
		
		String sql = "select DEPLOYMENT_ID_ from ACT_GE_BYTEARRAY a where NAME_ LIKE '%bpmn20.xml'";
		List<Map<String, Object>> dataMaps = jdbcTemplate.queryForList(sql);
		for(Map<String, Object> map:dataMaps){
			String deployId = (String)map.get("DEPLOYMENT_ID_");
			String bpmXml = bpmDao.getDefXmlByDeployId(deployId);
			bpmXml = handleBpmXml(bpmXml, list);
			bpmDao.wirteDefXml(deployId, bpmXml);
		}
	}
	
	private String handleBpmXml(String bpmXml, List<Element> list){
		for(Element e : list){
			String id = e.attributeValue("id");
			String value = e.attributeValue("class");
			String replace = "class=\"" + value + "\"";
			String replaceBy = "delegateExpression=\"${" + id + "}\"";
			bpmXml = bpmXml.replace(replace, replaceBy);
		}
		return bpmXml;
	}
}

