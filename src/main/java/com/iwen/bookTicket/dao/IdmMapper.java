package com.iwen.bookTicket.dao;

import java.util.List;

import com.iwen.bookTicket.bean.Idm;
import com.iwen.bookTicket.bean.IdmExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface IdmMapper {
    int countByExample(IdmExample example);

    int deleteByExample(IdmExample example);

    int deleteByPrimaryKey(String uid);

    int insert(Idm record);

    int insertSelective(Idm record);

    List<Idm> selectByExample(IdmExample example);

    Idm selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") Idm record, @Param("example") IdmExample example);

    int updateByExample(@Param("record") Idm record, @Param("example") IdmExample example);

    int updateByPrimaryKeySelective(Idm record);

    int updateByPrimaryKey(Idm record);

    List<Idm> selectPage(IdmExample example);
}