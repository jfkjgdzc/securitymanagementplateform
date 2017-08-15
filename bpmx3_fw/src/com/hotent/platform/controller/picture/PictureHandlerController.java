package com.hotent.platform.controller.picture;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hotent.core.util.AppUtil;
import com.hotent.core.util.FileUtil;

/**
 * 
 * <pre> 
 * 描述：表单编辑器中的上传图片按钮对应的图片处理
 * 构建组：bpmx33
 * 作者：lqf
 * 邮箱:13507732754@189.cn
 * 日期:2016-7-27-下午4:21:39
 * 版权：软件有限公司版权所有
 * </pre>
 */
@Controller
@RequestMapping("/platform/picture/pictureHandler/")
public class PictureHandlerController
{
	/**
	 * 
	 * 上传图片
	 * @param request
	 * @param response
	 * @throws IOException 
	 * void
	 */
	@RequestMapping("upload")
	public void uploadPicture(MultipartHttpServletRequest request,HttpServletResponse response) throws IOException{
		String path = "";
		Map<String, MultipartFile> files = request.getFileMap();
		Iterator<MultipartFile> it = files.values().iterator();
		
		String attachPath = AppUtil.getRealPath("/attachFiles/temp");
		while (it.hasNext()) {
			MultipartFile f = it.next();
			path = createFilePath(attachPath + File.separator,f.getOriginalFilename());
			FileUtil.writeByte(path, f.getBytes());
		}
		response.getWriter().print(path);
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
		one = new File(tempPath +  File.separator + year +  File.separator + month);
		if (!one.exists()) {
			one.mkdirs();
		}
		String extName = FileUtil.getFileExt(fileName);//文件后缀名
		return one.getPath() + File.separator + System.currentTimeMillis() + "." + extName;
	}
}
