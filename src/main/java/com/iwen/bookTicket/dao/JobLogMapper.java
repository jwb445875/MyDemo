package com.iwen.bookTicket.dao;


import com.iwen.bookTicket.bean.JobLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobLogMapper {

    int insertSelective(JobLog jobLog);

}