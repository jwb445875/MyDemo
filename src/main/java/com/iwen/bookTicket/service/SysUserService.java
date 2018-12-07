package com.iwen.bookTicket.service;

import com.iwen.bookTicket.bean.SysUser;
import com.iwen.bookTicket.dao.SysUserMapper;
import com.iwen.bookTicket.util.LdapHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysUserService {
	Logger logger = LoggerFactory.getLogger(SysUserService.class);

	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private SycnIdmService sycnIdmService;

	public SysUser getUserByAccount(String account){
		return userMapper.getUserByAccount(account);
	}

	public int upPhone(int i){
		List<SysUser> users=userMapper.getNoPhoneUser();
		logger.info("第"+i+"次更新---------------------共有数据："+users.size());
		String phone;
		int error=0;
		for (SysUser u:users){
			try {
				phone=sycnIdmService.getIdmPhone(u.getAccount());
			}catch (Exception e){
				phone="-1";
				error++;
			}
			u.setIphone(phone);
		}
		LdapHelper.closeCtx();
		for (SysUser u:users){
			userMapper.upPhone(u);
		}
		logger.info("第"+i+"次更新---------------------错误共有数据："+error);
		return users.size();
	}

}
