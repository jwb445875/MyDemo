package com.iwen.plan.service;

import com.iwen.plan.bean.TSUser;
import com.iwen.plan.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserMapper userMapper;


	public TSUser getUserByAccount(String account){
		return userMapper.getUserByAccount(account);
	}

}
