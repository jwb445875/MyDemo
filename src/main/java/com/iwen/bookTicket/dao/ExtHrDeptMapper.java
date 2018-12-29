package com.iwen.bookTicket.dao;


import com.iwen.bookTicket.bean.CostDeptVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExtHrDeptMapper {

    CostDeptVO getByDepartmentId(@Param("departmentId") String departmentId, @Param("account") String account);
    int addSycnHrDept(CostDeptVO vo);
    int addSycnHrUser(@Param("cid") int cid, @Param("uid") int uid);
    int upName(CostDeptVO deptvo);
    int delSycnHrUser(int uid);
    int upPhone(@Param("account") String account, @Param("phone") String phone);
}