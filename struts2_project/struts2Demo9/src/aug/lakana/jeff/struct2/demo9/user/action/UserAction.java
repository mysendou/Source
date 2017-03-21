package aug.lakana.jeff.struct2.demo9.user.action;

import aug.lakana.jeff.struct2.demo9.user.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();

	public String add() {
		System.out.println("user: " + user);
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return user;
	}
}
