package com.hotent.platform.service.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hotent.core.api.util.ContextUtil;
import com.hotent.core.db.IEntityDao;
import com.hotent.core.service.BaseService;
import com.hotent.core.util.BeanUtils;
import com.hotent.core.util.StringUtil;
import com.hotent.core.util.UniqueIdUtil;
import com.hotent.platform.dao.bpm.TaskReadDao;
import com.hotent.platform.dao.system.SysUserDao;
import com.hotent.platform.model.bpm.BpmDefinition;
import com.hotent.platform.model.bpm.ProcessRun;
import com.hotent.platform.model.bpm.TaskRead;
import com.hotent.platform.model.system.SysTemplate;
import com.hotent.platform.model.system.SysUser;
import com.hotent.platform.service.bpm.TaskMessageService;
import com.hotent.platform.service.system.SysTemplateService;

/**
 *<pre>
 * 对象功能:任务是否已读 Service类
 * 开发公司:广州宏天软件有限公司
 * 开发人员:hotent
 * 创建时间:2013-04-16 17:30:53
 *</pre>
 */
@Service
public class TaskReadService extends BaseService<TaskRead>
{
	@Resource
	private TaskReadDao dao;
	@Resource 
	SysUserDao sysUserDao;
	@Resource 
	SysTemplateService sysTemplateService;
	@Resource 
	TaskMessageService taskMessageService;
	
	public TaskReadService()
	{
	}
	
	@Override
	protected IEntityDao<TaskRead, Long> getEntityDao() 
	{
		return dao;
	}
	
	/**
	 * 添加查看记录
	 * @param actInstId		流程实例ID
	 * @param taskId		任务ID
	 */
	public void saveReadRecord(Long actInstId,Long taskId){
		SysUser sysUser=(SysUser) ContextUtil.getCurrentUser();
		Long userId=sysUser.getUserId();
		if(dao.isTaskRead(taskId, userId)) return;
		
		TaskRead taskRead=new TaskRead();
		taskRead.setId(UniqueIdUtil.genId());
		taskRead.setActinstid(actInstId);
		taskRead.setTaskid(taskId);
		taskRead.setUserid(userId);
		taskRead.setUsername(sysUser.getFullname());
		taskRead.setCreatetime(new Date());
		dao.add(taskRead);
	}
	
	/**
	 * 判断任务是否已读
	 * @param taskId 任务ID
	 * @param userId 用户ID
	 * @return
	 */
	public boolean isTaskRead(Long taskId,Long userId){
		return dao.isTaskRead(taskId, userId);
	}
	
	public List<TaskRead> getTaskRead(Long actInstId,Long taskId,String assignee){
		return dao.getTaskRead(actInstId,taskId,assignee);
	}

	public void delByActInstId(Long actInstId) {
		dao.delByActInstId(actInstId);
	}

	/**
	 * 标记任务为已读，并发送消息给发起人
	 * @param bpmDefinition
	 * @param processRun
	 * @throws Exception
	 */
	public void handReadRecord(BpmDefinition bpmDefinition, ProcessRun processRun,Long taskId) throws Exception {
		String actInstId = processRun.getActInstId();
		SysUser sysUser=(SysUser) ContextUtil.getCurrentUser();
		Long userId=sysUser.getUserId();
		if(dao.isTaskRead(taskId, userId)) return;
		
		TaskRead taskRead=new TaskRead();
		taskRead.setId(UniqueIdUtil.genId());
		taskRead.setActinstid(Long.parseLong(actInstId));
		taskRead.setTaskid(taskId);
		taskRead.setUserid(userId);
		taskRead.setUsername(sysUser.getFullname());
		taskRead.setCreatetime(new Date());
		handSendMsgToStartUser(bpmDefinition,processRun);
		dao.add(taskRead);
	}
	
	/**
	 * 处理发送提醒消息给发起人
	 * @throws Exception 
	 */
	private void handSendMsgToStartUser(BpmDefinition bpmDefinition,ProcessRun processRun) throws Exception{
		String informStart=bpmDefinition.getChkPendingInformStart();
		if(StringUtil.isEmpty(informStart))return;
		
		String subject = processRun.getSubject();
		if(BeanUtils.isEmpty(processRun))return;
		Long startUserId = processRun.getCreatorId();
		SysUser user = sysUserDao.getById(startUserId);
		List<SysUser> receiverUserList = new ArrayList<SysUser>();
		receiverUserList.add(user);
		
		Map<String,String> msgTempMap = sysTemplateService.getTempByFun(SysTemplate.USE_TYPE_CHKPENDING_STARTUSER);	
		taskMessageService.sendMessage(null, receiverUserList, informStart, msgTempMap, subject, ContextUtil.getCurrentUser().getFullname(), null,processRun.getRunId(),null);
	}
}
