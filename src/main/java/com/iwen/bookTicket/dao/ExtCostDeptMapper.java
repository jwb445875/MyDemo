package com.iwen.bookTicket.dao;




import com.iwen.bookTicket.bean.CostDeptVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ExtCostDeptMapper {


    CostDeptVO getByDepartmentId(@Param("departmentId") String departmentId, @Param("account") String account);
    int addSycnCostDept(CostDeptVO vo);
    Integer getUidByAccount(String account);
    int addSycnCostUser(@Param("cid") int cid, @Param("uid") int uid);
    int upName(CostDeptVO deptvo);
    int delSycnCostUser(int uid);




}