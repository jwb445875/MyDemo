package com.iwen.plan.dao;
import com.iwen.plan.bean.TSUser;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

	TSUser getUserByAccount(String account);

}