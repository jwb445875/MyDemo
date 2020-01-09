package com.iwen.plan.util;


import com.iwen.plan.Contants;
import com.iwen.plan.bean.PlanNodeEntity;
import com.iwen.util.DateUtils;
import com.iwen.util.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NodeStandardUtil {
    private List<PlanNodeEntity> list;
    private Integer springDay;
    private List<Date> springStart;
    private List<Date> springEnd;
    private int size=0;
    private Date newStart=null;

    public NodeStandardUtil(List<PlanNodeEntity> list, Integer springDay, String newYearDate) {
        this.list = list;
        if(StringUtils.isNotBlank(newYearDate)&&springDay!=null&&springDay>0){
            this.springDay = springDay;
            springStart= Lists.newArrayList();
            springEnd= Lists.newArrayList();
            String [] days=newYearDate.split(Contants.COMMA_SEPARATOR);
            this.size = days.length;
            int s=springDay/2;
            int e=springDay-s;
            for(int i=0;i<days.length;i++){
                Date d= DateUtils.formStrToDate(days[i],"yyyy-MM-dd");
                springStart.add(i,DateUtils.addDate(d,1-s));
                springEnd.add(i,DateUtils.addDate(d,e));
            }
        }else {
            this.springDay=0;
        }
    }

    public List<PlanNodeEntity> getStandards(Date start) {
        Map<Integer, PlanNodeEntity> imap = list.stream().collect(Collectors.toMap(PlanNodeEntity::getSortNo, a -> a, (k1, k2) -> k1));
        PlanNodeEntity first = imap.get(1);
        if (first == null) {
            return null;
        }
        first.setStandardStartDate(start);
        if(first.getStandardTime() != null) {
            first.setStandardFinishDate(DateUtils.addDate(start, first.getStandardTime() - 1));
            if (springDay > 0 && first.getSpringDay() != null && first.getSpringDay() > 0) {
                int checkResult = checkInSpring(first.getStandardStartDate(), first.getStandardFinishDate());
                if (checkResult > 2) {
                    first.setStandardFinishDate(DateUtils.addDate(first.getStandardFinishDate(), first.getSpringDay()));
                } else if (checkResult > 0) {
                    first.setStandardStartDate(this.newStart);
                    first.setStandardFinishDate(DateUtils.addDate(this.newStart, first.getStandardTime() - 1 + first.getSpringDay()));
                }
            }

            Map<String, PlanNodeEntity> smap = list.stream().collect(Collectors.toMap(PlanNodeEntity::getNodeCode, a -> a, (k1, k2) -> k1));
            int count;
            do {
                count = 0;
                for (PlanNodeEntity node : list) {
                    if (StringUtils.isNotBlank(node.getPreNodeCodes())) {
                        String[] codes = node.getPreNodeCodes().split(Contants.COMMA_SEPARATOR);
                        for (String code : codes) {
                            count += setDate(node, smap.get(code)) ? 1 : 0;
                        }
                    }else {
                        count += setDate(node, null) ? 1 : 0;
                    }
                }
            } while (count > 0);
        }
        return list;
    }

    private int checkInSpring(Date startDate, Date finishDate) {
        if(startDate==null||finishDate==null){
            return 0;
        }
        for (int i=size-1;i>=0;i--){
            //节点开始-结束时间被春节包围 影响计划开始时间和计划完成时间【新计划完成时间=春节范围的最后一天的后一天+延长工期+工期 新计划开始时间=春节范围的最后一天的后一天】
            if(finishDate.getTime()<springEnd.get(i).getTime()&&startDate.getTime()>springStart.get(i).getTime()){
                this.newStart=DateUtils.addDate(springEnd.get(i),1);
                return 1;
            }
            //节点开始时间被春节包围 影响计划开始时间和计划完成时间  【新计划完成时间=春节范围的最后一天的后一天+延长工期+工期  新计划开始时间=春节范围的最后一天的后一天】
            if(startDate.getTime()<springEnd.get(i).getTime()&&startDate.getTime()>springStart.get(i).getTime()){
                this.newStart=DateUtils.addDate(springEnd.get(i),1);
                return 2;
            }
            //节点结束时间被春节包围, 只会影响计划完成时间 【新计划完成时间=计划开始时间 + 延长工期+工期】
            if(finishDate.getTime()<springEnd.get(i).getTime()&&finishDate.getTime()>springStart.get(i).getTime()){
                return 3;
            }
            //春节被节点开始-结束时间被包围,只会影响计划完成时间 【新计划完成时间=计划开始时间 + 延长工期+工期】
            if(finishDate.getTime()>springEnd.get(i).getTime()&&startDate.getTime()<springStart.get(i).getTime()){
                return 4;
            }
        }
        return 0;
    }

    /**
     * 计划时间算法说明：
     * 算法类型包括：
     * F/S:当前节点计划开始时间，取其所有前置节点中的最晚完成时间，作为其计划开始时间。
     * F/F:当前节点计划完成时间，取其所有前置节点中的最晚完成时间，作为其计划完成时间。
     * S/F:当前节点计划完成时间，取其所有前置节点中的最早开始时间，作为其计划完成时间。
     * S/S:当前节点计划开始时间，取其所有前置节点中的最早开始时间，作为其计划开始时间。
     *
     * @param  node
     * @param pre
     * @return
     */
    private boolean setDate( PlanNodeEntity node, PlanNodeEntity pre) {
        int checkResult;
        boolean result=false;
        int nodeSpring=node.getSpringDay()==null?-1:node.getSpringDay();
        boolean check=springDay>0&&nodeSpring>=0;
        Integer standardTime=node.getStandardTime();
        Date sdate=null;
        Date fdate=null;
        if(standardTime==null||standardTime==0){
            return false;
        }
        if(pre==null||pre.getNodeCode().equals(node.getNodeCode())){
            if(check){
                checkResult=checkInSpring(node.getStandardStartDate(),node.getStandardFinishDate());
                if(checkResult>2&&nodeSpring>0){
                    sdate=node.getStandardStartDate();
                    fdate=DateUtils.addDate(node.getStandardFinishDate(),nodeSpring);
                    result=true;
                }else if(checkResult>0&&!node.getStandardStartDate().equals(this.newStart)){
                    sdate=this.newStart;
                    fdate=DateUtils.addDate(sdate, standardTime-1+nodeSpring);
                    result=true;
                }
            }
        }else {
            if(pre.getStandardStartDate()==null||pre.getStandardFinishDate()==null){
                return false;
            }
            String executeType=node.getExecuteType();
            int operday=node.getOperateDays()==null?0:node.getOperateDays();
            if ("1".equals(executeType)) {// F/S
                sdate=DateUtils.addDate(pre.getStandardFinishDate(),operday);
                fdate=DateUtils.addDate(sdate, standardTime-1);
                if(check){
                    checkResult=checkInSpring(sdate,fdate);
                    if(checkResult>2){
                        fdate=DateUtils.addDate(fdate,nodeSpring);
                    }else if(checkResult>0){
                        sdate=this.newStart;
                        fdate=DateUtils.addDate(sdate, standardTime-1+nodeSpring);
                    }
                }
                result=node.getStandardStartDate()==null||node.getStandardStartDate().getTime()<sdate.getTime();
            } else if ("2".equals(executeType)) {// S/S
                sdate=DateUtils.addDate(pre.getStandardStartDate(),operday+nodeSpring);
                fdate=DateUtils.addDate(sdate, standardTime-1);
                if(check){
                    checkResult=checkInSpring(sdate,fdate);
                    if(checkResult>2){
                        fdate=DateUtils.addDate(fdate,nodeSpring);
                    }else if(checkResult>0){
                        sdate=this.newStart;
                        fdate=DateUtils.addDate(sdate, standardTime-1+nodeSpring);
                    }
                }
                result=node.getStandardStartDate()==null||node.getStandardStartDate().getTime()>sdate.getTime();
            } else if ("3".equals(executeType)) {// F/F
                fdate=DateUtils.addDate(pre.getStandardFinishDate(),operday);
                sdate=DateUtils.addDate(fdate,1- standardTime);
                if(check){
                    checkResult=checkInSpring(sdate,fdate);
                    if(checkResult>2){
                        fdate=DateUtils.addDate(fdate,nodeSpring);
                    }else if(checkResult>0){
                        sdate=this.newStart;
                        fdate=DateUtils.addDate(sdate, standardTime-1+nodeSpring);
                    }
                }
                result=node.getStandardFinishDate()==null||node.getStandardFinishDate().getTime()<fdate.getTime();
            } else if ("4".equals(executeType)) {// S/F
                fdate=DateUtils.addDate(pre.getStandardStartDate(),operday);
                sdate=DateUtils.addDate(fdate, 1- standardTime);
                if(check){
                    checkResult=checkInSpring(sdate,fdate);
                    if(checkResult>2){
                        fdate=DateUtils.addDate(fdate,nodeSpring);
                    }else if(checkResult>0){
                        sdate=this.newStart;
                        fdate=DateUtils.addDate(sdate, standardTime-1+nodeSpring);
                    }
                }
                result=node.getStandardFinishDate()==null||node.getStandardFinishDate().getTime()>fdate.getTime();
            }
        }
        if(result){
            node.setStandardStartDate(sdate);
            node.setStandardFinishDate(fdate);
        }
        return result;
    }
}
