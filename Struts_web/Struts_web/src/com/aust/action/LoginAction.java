package com.aust.action;

import com.aust.bean.User;
import com.aust.service.Userservice;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

	public String add() {
		Userservice userservice = new Userservice();
//		userservice.adduser(user);
		boolean flag = userservice.loginByUsernameAndUserPassword(user);
		String msg = "";
		if (flag == true) {
			System.out.println("恭喜你，登录成功！");
			msg = "success";
		} else {
			System.out.println("用户名或密码不正确!");
			msg = "error";
		}
		return msg;
	}
	/*public void validate() { 
		  // 判断 用户名 是否为空 
		  if ( getUser() == null || "".equals( getUser().trim() ) ) { 
		   this.addFieldError( "userName", "用户名不能为空"); 
		  } 
		    
		  // 判断密码是否为空 
		  if ( getUserPwd() == null || "".equals( getUserPwd().trim() )) { 
		   this.addFieldError("userPwd", "密码不能为空"); 
		  } 
	}

	private String getUserPwd() {
		// TODO Auto-generated method stub
		return null;
	}*/
}