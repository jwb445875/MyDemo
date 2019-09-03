package com.iwen.excel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iwen.plan.bean.ImportNode;
import com.iwen.util.excel.ExcelExpSingleton;
import com.iwen.util.excel.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Api(value = "ExcelDemo", description = "excel导入导出demo")
@RestController
@EnableAutoConfiguration
@RequestMapping("/excel")
public class ExcelDemo {

    @ApiOperation(value = "excel导出demo", notes = "excel导出demo", response = String.class)
    @GetMapping(value = "out")
    public void out(HttpServletResponse response) {
        ExcelExpSingleton singleton =  ExcelExpSingleton.getInstance();
        Map<String ,Object> beans = Maps.newHashMap();
        beans.put("name","hello");
        beans.put("user","tester");
        beans.put("a","老王");
        List<ExcelPort> list= Lists.newArrayList();
        list.add(new ExcelPort(1,"阿斯顿",new Date()));
        list.add(new ExcelPort(2,"自行车",new Date()));
        list.add(new ExcelPort(3,"请问",new Date()));
        beans.put("list",list);
        singleton.init("demo.xlsx",beans,"测试导出",response);
    }

    @ApiOperation(value = "excel导入demo", notes = "excel导入demo", response = String.class)
    @GetMapping(value = "in")
    public void reportExcel() {
        FileInputStream is;
        Workbook wb;
        try {
            is = new FileInputStream("src/main/resources/temps/nodes.xls");
            wb = new HSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            ExcelUtil<ImportNode> util = new ExcelUtil<>(ImportNode.class);
            List<ImportNode> nodes = util.importExcel(sheet,1);
            System.out.println(nodes.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException i) {
            i.printStackTrace();
        }
    }

}
