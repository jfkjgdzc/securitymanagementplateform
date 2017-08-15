package com.hotent.qingjiadan.service.jfkjoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hotent.core.db.IEntityDao;
import com.hotent.core.service.GenericService;
import com.hotent.core.util.BeanUtils;
import com.hotent.qingjiadan.model.jfkjoa.Kjqjd;
import com.hotent.qingjiadan.dao.jfkjoa.KjqjdDao;
import com.hotent.core.util.UniqueIdUtil;

import net.sf.json.util.JSONUtils;
import net.sf.ezmorph.object.DateMorpher;
import com.hotent.core.bpm.model.ProcessCmd;
import com.hotent.core.util.StringUtil;
import net.sf.json.JSONObject;


import com.hotent.core.service.BaseService;


@Service
public class KjqjdService extends BaseService<Kjqjd>
{
	@Resource
	private KjqjdDao dao;
	
	public KjqjdService()
	{
	}
	
	@Override
	protected IEntityDao<Kjqjd,Long> getEntityDao() 
	{
		return dao;
	}
	
	/**
	 * 流程处理器方法 用于处理业务数据
	 * @param cmd
	 * @throws Exception
	 */
	public void processHandler(ProcessCmd cmd)throws Exception{
		Map data=cmd.getFormDataMap();
		if(BeanUtils.isNotEmpty(data)){
			String json=data.get("json").toString();
			Kjqjd kjqjd=getKjqjd(json);
			if(StringUtil.isEmpty(cmd.getBusinessKey())){
				Long genId=UniqueIdUtil.genId();
				kjqjd.setId(genId);
				this.add(kjqjd);
			}else{
				kjqjd.setId(Long.parseLong(cmd.getBusinessKey()));
				this.update(kjqjd);
			}
			cmd.setBusinessKey(kjqjd.getId().toString());
		}
	}
	
	/**
	 * 根据json字符串获取Kjqjd对象
	 * @param json
	 * @return
	 */
	public Kjqjd getKjqjd(String json){
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher((new String[] { "yyyy-MM-dd" })));
		if(StringUtil.isEmpty(json))return null;
		JSONObject obj = JSONObject.fromObject(json);
		Kjqjd kjqjd = (Kjqjd)JSONObject.toBean(obj, Kjqjd.class);
		return kjqjd;
	}
	/**
	 * 保存 科技请假单 信息
	 * @param kjqjd
	 */

	public void save(Kjqjd kjqjd) throws Exception{
		Long id=kjqjd.getId();
		if(id==null || id==0){
			id=UniqueIdUtil.genId();
			kjqjd.setId(id);
		    this.add(kjqjd);
		}
		else{
		    this.update(kjqjd);
		}
	}
}
