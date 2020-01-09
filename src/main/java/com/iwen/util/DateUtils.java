package com.iwen.util;

import com.google.common.base.Throwables;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);
    private static String[] parsePatterns = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH", "yyyy.MM", "yyyy年MM月dd日", "yyyy年MM月dd日 HH时mm分ss秒", "yyyy年MM月dd日 HH时mm分", "yyyy年MM月dd日 HH时", "yyyy年MM月", "yyyy"};
    public final static String dayPattern="yyyy-MM-dd";

    private final static String day2Pattern="yyyy-MM-dd";
    private final static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 日期转换成LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date){
        //时间线上的一个瞬时点
        Instant instant = date.toInstant();
        //时区
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }


    /**
     * 日期差
     * @param taskStartDate
     * @param taskEndDate
     * @param today 当天是否算1天
     * @return
     */
    public static Integer getDaySub(Date taskStartDate, Date taskEndDate,boolean today) {
        if(taskStartDate == null || taskEndDate == null){
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dayPattern);
        try{
            taskStartDate=parseDate(sdf.format(taskStartDate),dayPattern);
            taskEndDate=parseDate(sdf.format(taskEndDate),dayPattern);
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e.getCause());
            return 0;
        }
        long day=(taskEndDate.getTime()- taskStartDate.getTime())/(24*3600*1000);
        if(day>=0&&today){
            day++;
        }
        return Integer.valueOf(""+day);
    }

    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        } else {
            try {
                return parseDate(str.toString(), parsePatterns);
            } catch (ParseException var2) {
                return null;
            }
        }
    }

    // 日期加天数
    public static Date addDate(Date date, Integer day) {
        if(date == null){
            return null;
        }
        if(day==null||day==0){
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    // 判断日期是否相等
    public static boolean isSameDay(Date date1, Date date2) {
        if(date1 == null || date2 == null){
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(sdf.format(date1).equals(sdf.format(date2))){
            return true;
        }
        return false;
    }

    public static boolean sameDate(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        //fmt.setTimeZone(new TimeZone()); // 如果需要设置时间区域，可以在这里设置
        return fmt.format(d1).equals(fmt.format(d2));

    }



    public static Date formStrToDate(String s,String param) {
        SimpleDateFormat sdf = new SimpleDateFormat(param);
        Date d = null;
        try {
            if(StringUtils.isNotEmpty(s)){
                d = sdf.parse(s);
            }
        } catch (ParseException e) {
            LOGGER.error("DateUtils.formStrToDate"+ Throwables.getStackTraceAsString(e));
        }
        return d;
    }

    public static String formDateToStr(Date d) {
        if(d == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return  sdf.format(d);
    }

    public static boolean isValidDate(String str ,StringBuffer sf,String fieldName,int line) {
        boolean convertSuccess = false;

        if(StringUtils.isNotEmpty(str)){
            // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
                format.setLenient(false);
                format.parse(str);
                convertSuccess = true;
            } catch (ParseException e) {
                convertSuccess = false;
                sf.append("(第"+(line)+"行,"+fieldName+"值输入有误!)<br/>");
                LOGGER.error(e.getMessage(),e.getCause());

            }
        }else{
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 计算两个日期相差的小时数
     * @param fromDate
     * @param toDate
     * @return
     */
    public static Long countDaysDiffHours(Date fromDate, Date toDate){
        if(fromDate == null || toDate == null){
            return null;
        }
        long times = fromDate.getTime() - toDate.getTime();
        long hours = times/(3600*1000);
        return hours;
    }
    /**
     * 计算两个日期相差的天数
     * @param fromDate
     * @param toDate
     * @return
     */
    public static Integer countDiffDays(Date fromDate, Date toDate){
        if(fromDate == null || toDate == null){
            return null;
        }
        long times = fromDate.getTime() - toDate.getTime();
        int days = (int)(times/(24*3600*1000));
        return days;
    }

    /**
     * 将日期转换成字符串格式
     * @param d
     * @return
     */
    public static String dateTimeToStr(Date d) {
        if(d == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_PATTERN);
        return sdf.format(d);
    }


    /**
     * 日期相差多少月
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthSpace(Date date1, Date date2){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        int result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        return result == 0 ? 1 : Math.abs(result);
    }

    public static Integer getYear(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        return  cal.get(Calendar.YEAR);
    }

    public static Integer getMonth(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        return  cal.get(Calendar.MONTH)+1;
    }

    public static String getMonthS(Date day) {
        Integer m=getMonth(day);
        if(m<10){
            return "0"+m;
        }
        return m.toString();
    }

    /****
     * 获取当前时间
     *
     * @return
     */
    public static Date getNow() {
        Calendar cal = Calendar.getInstance();

        return cal.getTime();
    }

    public static Long getDayLong(Date dateVal) {
        if (dateVal == null) {
            return 0l;
        }
        Calendar cal = Calendar.getInstance();

        cal.setTime(dateVal);
        return cal.getTimeInMillis();
    }

    public static void main(String[] a){
        String date1="2019-06-30";
        String date2="2019-12-05";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
           /* System.out.println(formDateToStr(addDate(sdf.parse(date1),1-4)) );
            System.out.println(formDateToStr(addDate(sdf.parse(date1),4-1)) );
            System.out.println(DateUtils.getMonth(sdf.parse(date1)));
            System.out.println(DateUtils.getMonth(sdf.parse(date2)));*/
            System.out.println(DateUtils.countDiffDays(new Date(), sdf.parse(date2)));

        }catch (Exception e){

        }

    }
}
