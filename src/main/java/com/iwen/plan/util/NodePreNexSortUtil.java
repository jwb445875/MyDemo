package com.iwen.plan.util;



import com.iwen.plan.Contants;
import com.iwen.util.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class NodePreNexSortUtil {

    private Map<Integer,String> map;

    public NodePreNexSortUtil(Map<Integer,String> map) {
        this.map = map;
    }

    public String getCodes(String sorts){
        if(StringUtils.isBlank(sorts)){
            return null;
        }
        String[] cs=sorts.split(Contants.COMMA_SEPARATOR);
        List<Integer> list= Lists.newArrayList();
        for(String s:cs){
            try {
                Integer i=Integer.valueOf(s);
                list.add(i);
            }catch (Exception e){

            }
        }
        if(list.size()==0){
            return null;
        }
        Collections.sort(list);
        StringBuilder sb=new StringBuilder();
        for(Integer i:list){
            if(map.get(i)!=null){
                sb.append(map.get(i)).append(Contants.COMMA_SEPARATOR);
            }
        }
        if(sb.length()==0){
            return null;
        }
        return sb.substring(0,sb.length()-1);
    }
}
