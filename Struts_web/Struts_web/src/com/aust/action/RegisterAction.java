package com.aust.action;

import com.aust.bean.User;
import com.aust.service.Userservice;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	public String register() {
			Userservice userservice = new Userservice();
			boolean flag = userservice.registerByUsernameAndUserPassword(user);
			String msg = "";
			if (flag == false) {
				System.out.println("该用户名已被占用，请更换新的用户名");
				msg = "error";
			} else {
				System.out.println("恭喜你，注册成功！");
				msg = "success";
				userservice.adduser(user);
			}
			return msg;	
	}
}
