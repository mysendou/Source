package aug.lakana.jeff.struct2.demo8.user.action;

import aug.lakana.jeff.struct2.demo8.user.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String add() {
		System.out.println("name: "+ user.getName());
		System.out.println("age: "+ user.getAge());
		return SUCCESS;
	}
}
