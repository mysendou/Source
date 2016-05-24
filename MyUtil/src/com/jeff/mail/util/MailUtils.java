package com.jeff.mail.util;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;


/**
 * 发送邮件
 * 
 * @author Jeff.Ma
 * 
 */
public class MailUtils {
    public static Session createSession(String host, final String userName, final String password) {
        Properties properties = new Properties();
        properties.setProperty("mail.host", host);// 指定主机
        properties.setProperty("mail.smtp.auth", "true");// 制定验证

        // 创建验证器
        Authenticator authenticator = new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        
        return Session.getInstance(properties, authenticator);
    }
    
    public static void send(Session session, final Mail mail) throws AddressException, MessagingException, IOException{
       /*
        * 1,创建邮件对象MimeMessage
        * 2,设置发件人
        * 3,设置收件人
        */
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(mail.getFrom()));
        message.addRecipients(RecipientType.TO, mail.getToAddress());
        
        String cc = mail.getCcAddress();
        if(StringUtils.isNotBlank(cc)){
            message.addRecipients(RecipientType.CC, cc);//抄送
        }

        String ac = mail.getAcAddress();
        if(StringUtils.isNotBlank(ac)){
            message.addRecipients(RecipientType.BCC, ac);//暗送
        }

        message.setSubject(mail.getSubject());//设置主题

        MimeMultipart parts = new MimeMultipart();// 创建部件集合

        MimeBodyPart part = new MimeBodyPart();// 创建一个部件
        
        part.setContent(mail.getContent(), "text/html;charset=utf-8");// 设置邮件文本内容
        parts.addBodyPart(part);// 把部件添加到部件集中

        List<AttachBean> attachBeans = mail.getAttachBeans();
        if(attachBeans != null){
            for (AttachBean attachBean : attachBeans) {
                MimeBodyPart attachPart = new MimeBodyPart();
                attachPart.attachFile(attachBean.getFile());
                attachPart.setFileName(MimeUtility.encodeText(attachBean.getFileName()));
                parts.addBodyPart(part);
            }
        }
        message.setContent(parts);
        Transport.send(message);
    }
}
