package com.aust.service;

import java.util.Map;

import com.aust.bean.User;
import com.aust.dao.Userdao;

public class Userservice {
	Userdao userdao = new Userdao();

	public int adduser(User user) {
		return userdao.insert(user);
	}

	public boolean loginByUsernameAndUserPassword(User user) {
		//Map<String, Object> map=new Map<String, Object>();
		Map<String, Object> map =userdao.getPwByName(user.getUsername());
		System.out.println("service"+map);
		String pw=(String) map.get("pw");
		if (user.getPassword().equals(pw)) {
			System.out.println("success");
			return true;
		}else {
			return false;
		}
	}
	public boolean registerByUsernameAndUserPassword(User user){
		Map<String, Object> map =userdao.registergetPwByName(user.getUsername());
		System.out.println("service"+map);
		String pw=(String) map.get("pw");
		if (user.getPassword().equals(pw)) {
			System.out.println("error");
			return false;
		}else {
			return true;
		}
	}
	}

