package aug.lakana.jeff.struct2.demo12.user.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction3 extends ActionSupport {
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext application;

    public UserAction3() {
        request = ServletActionContext.getRequest();
        session = request.getSession();
        application = session.getServletContext();
    }

    public String add() {
        request.setAttribute("request", "requestAction3");
        session.setAttribute("session", "sessionAction3");
        application.setAttribute("application", "applicationAction3");
        return SUCCESS;
    }
}
