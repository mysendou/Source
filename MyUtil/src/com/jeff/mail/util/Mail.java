package com.jeff.mail.util;

import java.util.ArrayList;
import java.util.List;


/**
 * 邮件类 包含：发件人,收件人,抄送,暗送,主题,正文
 * 
 * @author Jeff.Ma
 * 
 */
public class Mail {
    private String from;// 发件人
    private StringBuilder toAddress = new StringBuilder();// 收件人
    private StringBuilder ccAddress = new StringBuilder();// 抄送
    private StringBuilder bccAddress = new StringBuilder();// 暗送

    private String subject;// 主题
    private String content;// 正文

    // 附件列表
    private List<AttachBean> attachList = new ArrayList<AttachBean>();

    public Mail() {
    }

    public Mail(String from, String to) {
        this(from, to, null, null);
    }

    public Mail(String from, String to, String subject, String content) {
        this.from = from;
        this.toAddress.append(to);
        this.subject = subject;
        this.content = content;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public String getToAddress() {
        return this.toAddress.toString();
    }

    public String getCcAddress() {
        return this.ccAddress.toString();
    }

    public String getAcAddress() {
        return this.bccAddress.toString();
    }

    public void addAttachment(AttachBean attachBean) {
        this.attachList.add(attachBean);
    }

    public List<AttachBean> getAttachBeans() {
        return this.attachList;
    }

    /**
     * 添加收件人
     * 
     * @param to
     */
    public void addToAddress(String to) {
        if (this.toAddress.length() > 0) {
            this.toAddress.append(",");
        }
        this.toAddress.append(to);
    }

    /**
     * 添加抄送人
     * 
     * @param cc
     */
    public void addCcAddresss(String cc) {
        if (this.ccAddress.length() > 0) {
            this.ccAddress.append(",");
        }
        this.ccAddress.append(cc);
    }

    public void AddAcAddress(String ac) {
        if (this.bccAddress.length() > 0) {
            this.bccAddress.append(",");
        }
        this.bccAddress.append(ac);
    }
}
