package com.iwen.util.excel;


import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iwen.util.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class ExcelUtil<T> {
    Class<T> clazz;

    public ExcelUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     *
     * @param sheet
     * @param startRow 表头第几行
     * @return
     */
    public List<T> importExcel(Sheet sheet,int startRow) {
        List<T> list = Lists.newArrayList();
        try {
            int rows = sheet.getPhysicalNumberOfRows();
            // 有数据时才处理
            if (rows > 0) {
                List<Field> allFields = getMappedFiled(clazz, null);
                // 定义一个map用于存放列的序号和field.
                Map<Integer, Field> fieldsMap = Maps.newHashMap();
                Map<Integer, Field> requireMap = Maps.newHashMap();
                // 第一行为表头
                Row rowHead = sheet.getRow(startRow);
                Map<String, Integer> cellMap = new HashMap<>();
                int cellNum = rowHead.getPhysicalNumberOfCells();
                for (int i = 0; i < cellNum; i++){
                    cellMap.put(rowHead.getCell(i).getStringCellValue().toLowerCase(), i);
                }
                for (Field field : allFields) {
                    // 将有注解的field存放到map中.
                    if (field.isAnnotationPresent(ExcelColumn.class)) {
                        ExcelColumn attr = field.getAnnotation(ExcelColumn.class);
                        // 根据Name来获取相应的failed
                        Integer col = cellMap.get(attr.title().toLowerCase());
                        if(col==null){
                            continue;
                        }
                        field.setAccessible(true);
                        fieldsMap.put(col, field);
                        if(attr.require()==1){
                            requireMap.put(col, field);
                        }
                    }
                }
                // 从第2行开始取数据
                s1:for (int i = startRow+1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    T entity = null;
                    for (int j = 0; j < cellNum; j++) {
                        Cell cell = row.getCell(j);
                        if (cell == null) {
                            continue;
                        }
                        String c =getCellValue(cell);
                        Field require = requireMap.get(j);
                        if (require != null&& StringUtils.isBlank(c)) {
                            continue s1;
                        }
                        entity = (entity == null ? clazz.getDeclaredConstructor().newInstance() : entity);
                        // 从map中得到对应列的field.
                        Field field = fieldsMap.get(j);
                        if (field == null) {
                            continue;
                        }
                        // 取得类型,并根据对象类型设置值.
                        Class<?> fieldType = field.getType();
                        if (String.class == fieldType) {
                            field.set(entity, String.valueOf(c));
                        } else if ((Integer.TYPE == fieldType)
                                || (Integer.class == fieldType)) {
                            field.set(entity, Integer.valueOf(c));
                        } else if ((Long.TYPE == fieldType)
                                || (Long.class == fieldType)) {
                            field.set(entity, Long.valueOf(c));
                        } else if ((Float.TYPE == fieldType)
                                || (Float.class == fieldType)) {
                            field.set(entity, Float.valueOf(c));
                        } else if ((Short.TYPE == fieldType)
                                || (Short.class == fieldType)) {
                            field.set(entity, Short.valueOf(c));
                        } else if ((Double.TYPE == fieldType)
                                || (Double.class == fieldType)) {
                            field.set(entity, Double.valueOf(c));
                        } else if (Character.TYPE == fieldType) {
                            if (c.length() > 0) {
                                field.set(entity, c.charAt(0));
                            }
                        }else if(Date.class==fieldType){
                            try {
                                field.set(entity,DateUtils.parseDate(c,new String []{"yyyy-MM-dd"}));
                            }catch (Exception e){
                            }
                        }
                    }
                    if (entity != null) {
                        list.add(entity);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 得到实体类所有通过注解映射了数据表的字段
     *
     * @param clazz
     * @param fields
     * @return
     */
    private List<Field> getMappedFiled(Class clazz, List<Field> fields) {
        if (fields == null) {
            fields = new ArrayList<Field>();
        }
        // 得到所有定义字段
        Field[] allFields = clazz.getDeclaredFields();
        // 得到所有field并存放到一个list中.
        for (Field field : allFields) {
            if (field.isAnnotationPresent(ExcelColumn.class)) {
                fields.add(field);
            }
        }
        if (clazz.getSuperclass() != null
                && !clazz.getSuperclass().equals(Object.class)) {
            getMappedFiled(clazz.getSuperclass(), fields);
        }

        return fields;
    }

    private final static Date d=new GregorianCalendar(1900,0,-1).getTime();
    private  String getCellValue(Cell cell) {
        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        return formater.format(date);
                    } else if (String.valueOf(cell.getNumericCellValue()).contains(".")) {
                        DecimalFormat df = new DecimalFormat("#");
                        return df.format(cell.getNumericCellValue());
                    } else {
                        return (cell + "").trim();
                    }
                case FORMULA:
                    try {
                        int day=Integer.valueOf(String.valueOf(cell.getNumericCellValue()).replace(".0",""));
                        Date _d = DateUtils.addDays(d, day);
                        return formater.format(_d);
                    } catch (IllegalStateException e) {
                        return String.valueOf(cell.getRichStringCellValue());
                    }
                default:
                    return (cell + "").trim().replace("\n","");
            }
        }
        return null;
    }


}
