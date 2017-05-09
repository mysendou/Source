package demo2.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
    private String gotoUrl;

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public String main() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie [] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("ssocookie")){
                    String result = Demo2Util.doGet("http://check.x.com/sso/checkCookie.action", cookie.getName(), cookie.getValue());
                }
            }
        }
        gotoUrl="http://check.x.com/demo2/main.action";
        return LOGIN;
    }
}
