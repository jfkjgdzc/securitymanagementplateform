

package com.hotent.qingjiadan.controller.jfkjoa;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hotent.platform.annotion.Action;
import org.springframework.web.servlet.ModelAndView;
import com.hotent.core.util.UniqueIdUtil;
import com.hotent.core.web.util.RequestUtil;
import com.hotent.core.web.controller.BaseController;
import com.hotent.core.util.BeanUtils;
import com.hotent.core.web.query.QueryFilter;
import com.hotent.core.page.PageList;
import com.hotent.platform.model.system.SysUser;
import org.apache.commons.lang.exception.ExceptionUtils;
import com.hotent.core.bpm.util.BpmUtil;
import net.sf.json.JSONObject;
import com.hotent.core.util.MapUtil;

import com.hotent.qingjiadan.model.jfkjoa.Kjqjd;
import com.hotent.qingjiadan.service.jfkjoa.KjqjdService;
import com.hotent.core.web.ResultMessage;
/**
 * 对象功能:科技请假单 控制器类
 */
@Controller
@RequestMapping("/qingjiadan/jfkjoa/kjqjd/")
public class KjqjdController extends BaseController
{
	@Resource
	private KjqjdService kjqjdService;
	
	/**
	 * 添加或更新科技请假单。
	 * @param request
	 * @param response
	 * @param kjqjd 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新科技请假单")
	public void save(HttpServletRequest request, HttpServletResponse response,Kjqjd kjqjd) throws Exception
	{
		String resultMsg=null;		
		try{
			if(kjqjd.getId()==null){
				kjqjdService.save(kjqjd);
				resultMsg=getText("添加","科技请假单");
			}else{
			    kjqjdService.save(kjqjd);
				resultMsg=getText("更新","科技请假单");
			}
			writeResultMessage(response.getWriter(),resultMsg,ResultMessage.Success);
		}catch(Exception e){
			writeResultMessage(response.getWriter(),resultMsg+","+e.getMessage(),ResultMessage.Fail);
		}
	}
	
	/**
	 * 取得科技请假单分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	@Action(description="查看科技请假单分页列表")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		List<Kjqjd> list=kjqjdService.getAll(new QueryFilter(request,"kjqjdItem"));
		ModelAndView mv=this.getAutoView().addObject("kjqjdList",list);
		return mv;
	}
	
	/**
	 * 删除科技请假单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除科技请假单")
	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String preUrl= RequestUtil.getPrePage(request);
		ResultMessage message=null;
		try{
			Long[]  lAryId=RequestUtil.getLongAryByStr(request,"id");
			kjqjdService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除科技请假单成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
		}
		addMessage(message, request);
		response.sendRedirect(preUrl);
	}
	
	/**
	 * 	编辑科技请假单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑科技请假单")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		
		String returnUrl=RequestUtil.getPrePage(request);
		Kjqjd kjqjd=kjqjdService.getById(id);
		
		return getAutoView().addObject("kjqjd",kjqjd)
							.addObject("returnUrl",returnUrl);
	}

	/**
	 * 取得科技请假单明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看科技请假单明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		Kjqjd kjqjd=kjqjdService.getById(id);
		return getAutoView().addObject("kjqjd", kjqjd);
	}
	
}