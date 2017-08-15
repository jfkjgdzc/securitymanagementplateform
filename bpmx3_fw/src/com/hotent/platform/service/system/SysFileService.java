package com.hotent.platform.service.system;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hotent.core.api.org.model.ISysUser;
import com.hotent.core.api.util.ContextUtil;
import com.hotent.core.db.IEntityDao;
import com.hotent.core.service.BaseService;
import com.hotent.core.util.AppUtil;
import com.hotent.core.util.BeanUtils;
import com.hotent.core.util.FileUtil;
import com.hotent.core.util.StringUtil;
import com.hotent.core.util.UniqueIdUtil;
import com.hotent.core.web.query.QueryFilter;
import com.hotent.platform.attachment.AttachmentHandler;
import com.hotent.platform.attachment.AttachmentHandlerFactory;
import com.hotent.platform.dao.system.SysFileDao;
import com.hotent.platform.model.system.GlobalType;
import com.hotent.platform.model.system.SysFile;
import com.hotent.platform.service.util.ServiceUtil;

/**
 * 对象功能:附件 Service类
 * 开发公司:广州宏天软件有限公司
 * 开发人员:csx
 * 创建时间:2011-11-26 18:19:16
 */
@Service
public class SysFileService extends BaseService<SysFile>
{
	public static final String WORD_TEMPLATE = "wordTemplate";
	@Resource
	private SysFileDao dao;
	@Resource
	private GlobalTypeService globalTypeService;
	@Resource
	private SysTypeKeyService sysTypeKeyService;
	// 当前附件处理器
	private AttachmentHandler currentHandler;
	
	public SysFileService()
	{
	}
	
	// 初始化当前附件处理器
	private void initCurrentHandler() throws Exception{
		if(BeanUtils.isEmpty(currentHandler)){
			AttachmentHandlerFactory attachmentHandlerFactory = AppUtil.getBean(AttachmentHandlerFactory.class);
			currentHandler = attachmentHandlerFactory.getCurrentHandler();
		}
	}
	
	@Override
	protected IEntityDao<SysFile, Long> getEntityDao() {
		return dao;
	}
	
	public List<SysFile> getFileAttch(QueryFilter fileter){
		return dao.getFileAttch(fileter);
	}
	
	/**
	 * 删除附件及附件表中的记录
	 * @param ids
	 * @throws Exception
	 */
	public void delSysFileByIds(Long[] ids) throws Exception{
		initCurrentHandler();
		for (Long id : ids) {
			SysFile sysFile = dao.getById(id);
			currentHandler.remove(sysFile);
			dao.delById(id);
		}
	}
	
	/**
	 * 创建文件目录
	 * 
	 * @param tempPath
	 * @param fileName
	 *            文件名称
	 * @return 文件的完整目录
	 */
	private String createFilePath(String tempPath, String fileName) {
		File one = new File(tempPath);
		Calendar cal = Calendar.getInstance();
		Integer year = cal.get(Calendar.YEAR); // 当前年份
		Integer month = cal.get(Calendar.MONTH) + 1; // 当前月份
		File two = new File(tempPath +  File.separator + year +  File.separator + month);
		if (!two.exists()) {
			two.mkdirs();
		}
		return one.getPath() + File.separator + fileName;
	}
	
	/**
	 * 创建文件目录
	 * 
	 * @param tempPath
	 * @param fileName
	 *            文件名称
	 * @return 文件的完整目录
	 */
	private String createFilePath(String userAccount,String fileName,String fileType) {
		if(StringUtil.isEmpty(fileType) || !WORD_TEMPLATE.equalsIgnoreCase(fileType)){
			return this.createFilePath(userAccount, fileName);
		}
		File one = new File(WORD_TEMPLATE );
		if (!one.exists()) {
			one.mkdirs();
		}
		return one.getPath() + File.separator + fileName;
	}
	
	/**
	 * 上传附件
	 * @param typeId 类型ID
	 * @param fileId 附件ID
	 * @param fileType 附件类型
	 * @param uploadName 上传的附件名称
	 * @param uploadType 上传类型
	 * @param fileFormates 格式限定
	 * @param files 上传的文件流
	 * @return
	 * @throws Exception
	 */
	public JSONObject uploadFile(Long typeId, Long fileId, String fileType, String uploadName, String uploadType, String fileFormates, Map<String, MultipartFile> files) throws Exception{
		initCurrentHandler();
		JSONObject jobject = new JSONObject();
		boolean mark = true;
		ISysUser currentUser = ContextUtil.getCurrentUser();
		// 获取附件类型
		GlobalType globalType = null;
		if (typeId > 0) {
			globalType = globalTypeService.getById(typeId);
		}
		Iterator<MultipartFile> it = files.values().iterator();
		while (it.hasNext()) {
			Boolean isAdd = false;
			String oldFilePath = "";
			SysFile sysFile;
			if(BeanUtils.isNotIncZeroEmpty(fileId)){
				sysFile = dao.getById(fileId);
				oldFilePath = sysFile.getFilePath();
			}
			else{
				// 新增的上传文件
				isAdd = true;
				// 生成新的文件ID
				fileId = UniqueIdUtil.genId();
				sysFile = new SysFile();
				sysFile.setFileId(fileId);
			}
			MultipartFile f = it.next();
			if(StringUtil.isNotEmpty(uploadName)){
				if(!uploadName.equals(f.getName())){
					throw new RuntimeException("上传名称与文件名称不符");
				}
			}
			String oriFileName = f.getOriginalFilename();
			String extName = FileUtil.getFileExt(oriFileName);
			//文件格式要求
			if(StringUtil.isNotEmpty(fileFormates)){
				//不符合文件格式要求的就标志为false
                if(!( fileFormates.contains("*."+extName) ) ){       
                	mark = false;
                }
			}
			if(mark){
				String fileName = fileId + "." + extName;
				String filePath = "";
				
				String creatorAccount = SysFile.FILETYPE_OTHERS;
				// 当前用户的信息
				if (currentUser != null) {
					sysFile.setCreatorId(currentUser.getUserId());
					sysFile.setCreator(currentUser.getFullname());
					creatorAccount = currentUser.getAccount();
				} else {
					sysFile.setCreator(SysFile.FILE_UPLOAD_UNKNOWN);
				}
				if("pictureShow".equals(uploadType)){
					filePath = createFilePath(File.separator + creatorAccount + File.separator +"pictureShow", fileName);
				}else{
					filePath = createFilePath(creatorAccount, fileName, fileType);
				}	
				// 附件名称
				sysFile.setFileName(oriFileName.lastIndexOf('.')==-1 ? oriFileName:oriFileName.substring(0, oriFileName.lastIndexOf('.')));
				//保存相对路径
				sysFile.setFilePath(filePath);
				// 附件类型
				if (globalType != null) {
					sysFile.setTypeId(globalType.getTypeId());
					sysFile.setFileType(globalType.getTypeName());
				} else {
					sysFile.setTypeId(sysTypeKeyService.getByKey(GlobalType.CAT_FILE).getTypeId());
					sysFile.setFileType("-");
				}
				// 上传时间
				sysFile.setCreatetime(new java.util.Date());
				// 扩展名
				sysFile.setExt(extName);
				// 字节总数
				sysFile.setTotalBytes(f.getSize());
				// 说明
				sysFile.setNote(FileUtil.getSize(f.getSize()));
				// 总的字节数
				sysFile.setDelFlag(SysFile.FILE_NOT_DEL);
				
				if(isAdd){
					currentHandler.upload(sysFile, f.getInputStream());
					dao.add(sysFile);
				}
				else{
					currentHandler.upload(sysFile, f.getInputStream());
					dao.update(sysFile);
					boolean tag = true;
					String newFilePath = sysFile.getFilePath();
					if(StringUtil.isNotEmpty(newFilePath)&&StringUtil.isNotEmpty(oldFilePath)){
						if(newFilePath.trim().equals(oldFilePath.trim())){
							tag = false;
						}
					}
					// 修改了文件的存放路径，需要删除之前路径下的文件
					if(tag){
						sysFile.setFilePath(oldFilePath);
						currentHandler.remove(sysFile);
					}
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				oriFileName = oriFileName + "(" + ContextUtil.getCurrentUser().getFullname() + "_" +sdf.format(new Date())+")"; 
				jobject.put("success", "true");
				jobject.put("fileId", fileId);
				jobject.put("fileName", oriFileName);
				
			}else{
				jobject.put("success", "false");
				jobject.put("message", "文件格式不符合要求!");
			}
		}
		return jobject;
	}
	
	public SysFile downloadFile(Long fileId, OutputStream outStream) throws Exception{
		initCurrentHandler();
		SysFile sysFile = dao.getById(fileId);
		if (BeanUtils.isEmpty(sysFile)){
			return null;
		}
		currentHandler.download(sysFile, outStream);
		return sysFile;
	}
}
