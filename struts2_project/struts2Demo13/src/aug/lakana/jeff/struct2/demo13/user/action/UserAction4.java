package aug.lakana.jeff.struct2.demo13.user.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction4 extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext application;

    @Override
    public void setServletRequest(HttpServletRequest arg0) {
        request = arg0;
        session = request.getSession();
        application = session.getServletContext();
    }

    public String add() {
        request.setAttribute("request", "requestAction4");
        session.setAttribute("session", "sessionAction4");
        application.setAttribute("application", "applicationAction4");
        return SUCCESS;
    }
}
