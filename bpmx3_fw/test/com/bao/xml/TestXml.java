/**
 * Copyright (c) 2017,XX有限公司 All rights reserved.
 */
package com.bao.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
/**
 * 2017年5月25日，由<a href="mailto:hjb07@tom.com">黄金宝</a>创建了初始版本
 *
 * @author <a href="mailto:hjb07@tom.com">黄金宝</a>
 * @projectname bpmx3_dev
 * @package com.bao.xml
 * @filename TestXml.java
 * @date 2017年5月25日-上午10:02:15
 * @since 
 * @see 
 * @history 
 */
public class TestXml {
	
	@Test
	public void test(){
		Document doc = null;
		Element root = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.newDocument();
			root = doc.createElement("REPORTS");
			doc.appendChild(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void generateXml(String outputPath) {
//		try {
////			Person[] arr = new Person[] { new Person("jinbo", 20),
////					new Person("gameboy", 25) };
////			List<Person> list = Arrays.asList(arr);// 将数组转换成List
//			
//			Reports reports = CreateFactory.createReports();
//			
//			
//			Report report = CreateFactory.createReportsReport();
//			
//			
//			Item i1 = CreateFactory.createReportsReportItem();
//			i1.setName("HOSPITALNAME");
//			i1.setValue("复旦大学附属中山医院");
//			
//			report.items.add(i1);
//			
//			
//			reports.reports.add(report);
//			
//			
//			Document doc = generateXml(reports.getReports());// 生成XML文件
//			outputXml(doc, outputPath);// 将文件输出到指定的路径
//		} catch (Exception e) {
//			System.err.println("出现异常");
//		}
	}
	
}

