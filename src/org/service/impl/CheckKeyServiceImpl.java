package org.service.impl;

import org.entity.User;
import org.util.SecurityUtil;

public class CheckKeyServiceImpl {
	
	public boolean check(User user,String key) {
		String str = SecurityUtil.getKey(user.getEmail());
		if(user.getEmail().equals(str))
			return false;
		else
			return true;

	}
}
