package com.hotent.platform.mail;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.junit.Test;

import com.hotent.BaseTestCase;
import com.hotent.core.mail.MailUtil;
import com.hotent.core.mail.model.Mail;

public class SendMailTest extends BaseTestCase {
	
	@Resource
	MailUtil mailUtil;

	@Test
	public void sendMail() throws MessagingException, UnsupportedEncodingException{
		Mail mail=new Mail();
		mail.setReceiverAddresses("58133370@qq.com");
		mail.setSubject("测试邮件");
		mail.setContent("发送内容");
		mail.setSenderAddress("1440563555@qq.com");
		
		mailUtil.send(mail);
	}
	
}
