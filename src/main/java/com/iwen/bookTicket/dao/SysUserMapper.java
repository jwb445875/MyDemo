package com.iwen.bookTicket.dao;
import com.iwen.bookTicket.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysUserMapper {

	SysUser getUserByAccount(String account);
	List<SysUser> getNoPhoneUser();
	int upPhone(SysUser u);

}