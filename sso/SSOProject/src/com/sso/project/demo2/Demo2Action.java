package com.sso.project.demo2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sso.project.util.SSOUtil;

public class Demo2Action extends ActionSupport{
    private String gotoUrl;

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public String main() {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (SSOUtil.checkCookie(request)) {
            return SUCCESS;
        }
        gotoUrl="/demo2/main.action";
        return LOGIN;
    }
}
