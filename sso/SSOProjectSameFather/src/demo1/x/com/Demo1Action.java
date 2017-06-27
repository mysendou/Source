package demo1.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
    private String gotoUrl;

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public String main() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ssoCookie")) {
                    String result = Demo1Util.doGet(
                            "http://check.x.com:8080/sso/checkCookie.action",
                            cookie.getName(), cookie.getValue());
                    if(result.equals("1")){
                        return SUCCESS;
                    }
                }
            }
        }
        gotoUrl = "http://demo1.x.com:8080/demo1/main.action";
        return LOGIN;
    }
}
