package com.iwen;


import com.iwen.plan.bean.ImportNode;
import com.iwen.util.excel.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TestDemo {


    public static void main(String[] args) {
        FileInputStream is;
        Workbook wb;
        try {
            is = new FileInputStream("src/main/temps/nodes.xls");
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
