package aug.lakana.jeff.struct2.demo11.user.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String name;

	public String add() {
		if (null == name || !"admin".equals(name)) {
			this.addFieldError("name", "name is error");
			this.addFieldError("name", "name again");
			this.addFieldError("name1", "name1 is error");
		}
		return ERROR;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
