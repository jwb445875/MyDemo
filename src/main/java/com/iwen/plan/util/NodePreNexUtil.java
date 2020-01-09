package com.iwen.plan.util;




import com.iwen.plan.Contants;
import com.iwen.util.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class NodePreNexUtil {

    private Map<String,Integer> map;

    public NodePreNexUtil(Map<String, Integer> map) {
        this.map = map;
    }

    public String getSorts(String codes){
        if(StringUtils.isBlank(codes)){
            return null;
        }
        String[] cs=codes.split(Contants.COMMA_SEPARATOR);
        List<Integer> list= Lists.newArrayList();
        for(String s:cs){
            if(map.get(s)!=null){
                list.add(map.get(s));
            }
        }
        if(list.size()==0){
            return null;
        }
        Collections.sort(list);
        String s=list.toString();
        return s.substring(1,s.length()-1);
    }
}
