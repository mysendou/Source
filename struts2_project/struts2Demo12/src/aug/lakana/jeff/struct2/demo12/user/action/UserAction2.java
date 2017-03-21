package aug.lakana.jeff.struct2.demo12.user.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction2 extends ActionSupport implements RequestAware, SessionAware, ApplicationAware{
    private Map<String, Object> request;
    private Map<String, Object> session;
    private Map<String, Object> application;
    @Override
    public void setApplication(Map<String, Object> app) {
        application = app;
    }
    @Override
    public void setSession(Map<String, Object> sess) {
        session = sess;
    }
    @Override
    public void setRequest(Map<String, Object> arg0) {
        request = arg0;
    }
    
    public String add() {
        request.put("request", "requestAction2");
        session.put("session", "sessionAction2");
        application.put("application", "applicationAction2");
        return SUCCESS;
    }
    
}
