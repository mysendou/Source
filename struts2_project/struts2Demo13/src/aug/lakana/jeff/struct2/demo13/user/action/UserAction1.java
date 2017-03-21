package aug.lakana.jeff.struct2.demo13.user.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction1 extends ActionSupport {
    private Map request;
    private Map session;
    private Map application;
    
    public UserAction1(){
        request = (Map) ActionContext.getContext().get("request");
        session = ActionContext.getContext().getSession();
        application = ActionContext.getContext().getApplication();
    }
    
    public String add() {
        request.put("request","requset1");
        session.put("session", "session1");
        application.put("application", "application1");
        return SUCCESS;
    }

}
