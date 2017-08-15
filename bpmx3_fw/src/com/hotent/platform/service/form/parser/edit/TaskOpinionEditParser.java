/**
 * 描述：TODO
 * 包名：com.hotent.platform.service.form.parser
 * 文件名：DanhwbkParser.java
 * 作者：User-mailto:liyj@jee-soft.cn
 * 日期2015-12-11-下午2:49:51
 *  2015广州宏天软件有限公司版权所有
 * 
 */
package com.hotent.platform.service.form.parser.edit;

import java.util.Map;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.hotent.core.util.BeanUtils;
import com.hotent.platform.service.form.parser.util.FieldRight;
import com.hotent.platform.service.form.parser.util.ParserParam;

/**
 * <pre>
 * 描述：
 * 构建组：bpm33
 * 作者：aschs
 * 邮箱:liyj@jee-soft.cn
 * 日期:2015-12-11-下午2:49:51
 * 版权：广州宏天软件有限公司版权所有
 * </pre>
 */
@Service
public class TaskOpinionEditParser extends EditAbstractParser {

	@Override
	public Object parse(ParserParam param, Element element) {
		String instanceId = element.attr("instanceId");
		element.removeAttr("parser");
 		if(BeanUtils.isNotEmpty(instanceId)&&BeanUtils.isNotEmpty(param.getVar("instanceId"))){
			element.attr("instanceId",param.getVar("instanceId").toString());
		}
		return null;
	}
}
