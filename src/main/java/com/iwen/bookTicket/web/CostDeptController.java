package com.iwen.bookTicket.web;

import com.iwen.bookTicket.bean.JobLog;
import com.iwen.bookTicket.dao.JobLogMapper;
import com.iwen.bookTicket.service.CostDeptService;
import com.iwen.bookTicket.service.SycnIdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/26.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/batms/cost")
public class CostDeptController {

    @Autowired
    private SycnIdmService sycnIdmService;

    @Autowired
    private CostDeptService costDeptService;

    @Autowired
    private JobLogMapper jobLogMapper;

    @RequestMapping("upAll")
    public String upAll2(String sycnDate) {
        String filter;
        if(sycnDate!=null&&sycnDate.length()==10){
            filter="(&(|(createTimestamp>="+sycnDate.replaceAll("-","")+"160000Z)(modifyTimestamp>="+sycnDate.replaceAll("-","")+"160000Z))(smart-type=E1))";
        }else{
            filter="(smart-type=E1)";
        }
        JobLog jobLog = new JobLog();
        jobLog.setStartTime(new Date());
        jobLog.setExeIp("springBoot");
        List<Map<String,String>> costs=null;
        try{
            costs= sycnIdmService.sycnCostDeptAll(filter);
            jobLog.setJobDesc("获取IDM用户更新数量："+costs.size());
            jobLog.setEndTime(new Date());
            jobLog.setExeStatus("1");
        }catch (Exception e){
            jobLog.setEndTime(new Date());
            jobLog.setExeStatus("0");
            jobLog.setErrorInfo(e.getLocalizedMessage());
        }
        jobLogMapper.insertSelective(jobLog);
        if(costs!=null&&costs.size()>0){
            jobLog.setStartTime(new Date());
            jobLog.setJobDesc("IDM用户更新");
            costDeptService.sycnCostDeptAll(costs);
            jobLog.setEndTime(new Date());
            jobLog.setExeStatus("1");
            jobLogMapper.insertSelective(jobLog);
        }
        return "finish";
    }

}
