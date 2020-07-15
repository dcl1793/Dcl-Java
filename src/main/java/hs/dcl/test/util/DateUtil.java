package hs.dcl.test.util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 时间工具类
 *
 * @author dacl30868
 * @date 2020年6月23日下午5:22:43
 */
public class DateUtil {
    
    
    public static final String DATA_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String defaultDatePattern = "yyyy-MM-dd";
    public static String FULL_DATE_FORMAT_STR = "yyyyMMdd";
    
    public static final SimpleDateFormat FORMAT_FULL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static final SimpleDateFormat FORMAT_FULL_SHORT = new SimpleDateFormat("yyyyMMddHHmm");
    
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    public static final SimpleDateFormat MINUTE_FORMAT = new SimpleDateFormat("MM-dd HH:00");
    
    public static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("MM-dd");
    
    public static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyMMdd");
    
    public static final SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    
    public static final SimpleDateFormat UTC_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    
    public static String getMinuteFormat(long time) {
        return MINUTE_FORMAT.format(new Date(time));
    }
    
    public static String getDayFormat(long time) {
        return DAY_FORMAT.format(new Date(time));
    }
    
    public static String getShortDateFormat(long time) {
        return SHORT_DATE_FORMAT.format(new Date(time));
    }
    
    /**
     * 获得默认的 date pattern
     */
    public static String getDatePattern() {
        return defaultDatePattern;
    }
    
    
    private static final Calendar CAL = Calendar.getInstance();
    
    /**
     * 返回预设Format的当前日期字符串
     */
    public static String getToday() {
        Date today = new Date();
        return format(today);
    }
    
    /**
     * 使用预设Format格式化Date成字符串
     */
    public static String format(Date date) {
        return format(date, getDatePattern());
    }
    
    /**
     * 使用参数Format格式化Date成字符串
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        
        return (returnValue);
    }
    
    /**
     * 使用预设格式将字符串转为Date
     */
    public static Date parse(String strDate) {
        try {
            return parse(strDate, getDatePattern());
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return null;
    }
    
    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date parse(String strDate, String pattern)
            throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.parse(strDate);
    }
    
    /**
     * 在日期上增加数个整月
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
    
    /**
     * 在日期上增加天数
     */
    public static Date addday(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, n);
        return cal.getTime();
    }
    
    /**
     * 获取 n 年后的毫秒
     */
    public static long addYear(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, n);
        return cal.getTimeInMillis();
    }
    
    
    /**
     * 获取当天0点的毫秒数
     *
     * @return
     */
    public static long getTodayTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
    
    /**
     * 获取当天时间 24 点的毫秒数
     *
     * @return
     */
    public static long getTodayEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
    
    /**
     * 获取某个时间0点的时刻
     *
     * @param time
     *
     * @return
     */
    public static Timestamp getZeroTimestamp(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }
    
    /**
     * 获取某个时间 24 点的时刻
     *
     * @param time
     *
     * @return
     */
    public static Timestamp getEndTimestamp(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }
    
    /**
     * 获取  n 天前的0时0分0秒(毫秒数)
     *
     * @param days
     *
     * @return
     */
    public static long getBeforeDaysTime(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -days);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
    
    /**
     * 获取 n 小时的0分0秒(毫秒数)
     *
     * @param hour
     *
     * @return
     */
    public static long getBeforeHoursTime(int hour) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -hour);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
    
    /**
     * 获取 n 小时的0分0秒(毫秒数)
     *
     * @param time
     * @param hour
     *
     * @return
     */
    public static Timestamp getBeforeHoursTimestamp(long time, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.add(Calendar.HOUR, -hour);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new Timestamp(cal.getTimeInMillis());
    }
    
    /**
     * 获取  n 小时的毫秒数
     *
     * @param time
     * @param hour
     *
     * @return
     */
    public static long getBeforeHoursTime(long time, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.add(Calendar.HOUR, -hour);
        return cal.getTimeInMillis();
    }
    
    public synchronized static String getWeatherDate() {
        return FORMAT_FULL_SHORT.format(Calendar.getInstance().getTime());
    }
    
    
    /**
     * @return
     *
     * @see #FORMAT_FULL
     */
    public synchronized static String currentFullDatetime() {
        return FORMAT_FULL.format(Calendar.getInstance().getTime());
    }
    
    public synchronized static String getTime(String time) {
        return FORMAT_FULL.format(new Date(Long.parseLong(time)));
    }
    
    public synchronized static String getTime(long time) {
        return FULL_DATE_FORMAT.format(time);
    }
    
    public synchronized static long getLong(String time) {
        try {
            return FORMAT_FULL.parse(time).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }
    
    public static long getBefor24HoursTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -24);
        return cal.getTimeInMillis();
    }
    
    public static long getBefor30DaysTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        return cal.getTimeInMillis();
    }
    
    public static String getExpiresDate(int expiresIn) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, expiresIn);
        Date expriseDate = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(expriseDate) + " +0000";
    }
    
    /**
     * 主要用来判断数据是否应该展示
     *
     * @param startTime
     * @param endTime
     *
     * @return
     */
    public static boolean isShow(String startTime, String endTime) {
        // 都会空，默认永久展示
        
        return Boolean.FALSE;
    }
    
    /**
     * 获取当天的结束时间
     *
     * @return
     */
    public static long getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTimeInMillis();
    }
    
    /**
     * 获取本月第一天0点时间戳
     *
     * @return
     */
    public static long getMonthStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
    
    /**
     * 获得本月最后一天23:59:59的时间戳
     *
     * @return
     */
    public static long getMonthEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() - 1000;
    }
    
    public static Timestamp getTimestamp(int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), month, day, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new Timestamp(cal.getTimeInMillis());
    }
    
    public static boolean isDndst(String start, String end, String timeZone) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone(timeZone));
        // 获取一天当前时间的分钟数
        int currTime = cal.get(Calendar.HOUR_OF_DAY) * 60
                + cal.get(Calendar.MINUTE);
        int astart = getMinute(start);
        int aend = getMinute(end);
        // 说明没有跨天
        if (aend > astart) {
            return currTime < aend && currTime > astart;
        }
        
        // 说明有跨天
        if (aend < astart) {
            return currTime > astart || currTime < aend;
        }
        return true;
    }
    
    /**
     * 主要用来获取08:02,从00:00开始的分钟数
     *
     * @param time
     *
     * @return
     */
    private static int getMinute(String time) {
        
        return 0;
    }
    
    public static boolean isShow(String timezone) throws Exception {
        // 6点 06:00
        int start = 6 * 60 + 0;
        // 18点 18:00
        int end = 18 * 60 + 0;
        
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT" + timezone));
        
        int currTime = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
        return currTime < end && currTime > start;
    }
    
    /**
     * 获取某个时间段的小时数
     *
     * @param startTimes
     * @param endTimes
     *
     * @return
     */
    public static long getHours(long startTimes, long endTimes) {
        if (endTimes <= startTimes) {
            return 0;
        }
        long subTimes = endTimes - startTimes;
        return Math.round(subTimes / (60 * 60 * 1000.0));
    }
    
    /**
     * 获取某个时间段的天数
     *
     * @param startTimes
     * @param endTimes
     *
     * @return
     */
    public static long getDays(long startTimes, long endTimes) {
        if (endTimes <= startTimes) {
            return 0;
        }
        long subTimes = endTimes - startTimes;
        return Math.round(subTimes / (24 * 60 * 60 * 1000.0));
    }
    
    /**
     * utc时间格式转换时间戳
     *
     * @param utcTime
     *
     * @return
     */
    public static long utc2Time(String utcTime) {
        try {
            UTC_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC+8"));
            return UTC_FORMAT.parse(utcTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    /**
     * 时间戳转换UTC时间格式
     *
     * @param time
     *
     * @return
     */
    public static String time2Utc(long time) {
        UTC_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        return UTC_FORMAT.format(new Date(time));
    }
    
    public static int getYear(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.YEAR);
    }
    
    public static int getMonth(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.MONTH);
    }
    
    
    /**
     * 判断当前时间是否在[startTime, endTime]区间
     *
     * @param startTime
     * @param endTime
     *
     * @return
     */
    public static boolean isEffectiveDatePush(Date startTime, Date endTime) {
        return startTime.compareTo(endTime) <= 0 && parse(format(new Date())).compareTo(startTime) <= 0;
    }
    
    /**
     * 判断当前时间是否在[startTime, endTime]区间
     *
     * @param startTime
     * @param endTime
     *
     * @return
     */
    public static boolean isEffectiveDate(Date startTime, Date endTime) {
        try {
            return startTime.compareTo(endTime) <= 0 && parse(format(new Date(), DATA_FORMAT), DATA_FORMAT).compareTo(startTime) <= 0;
        } catch (ParseException e) {
            // e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 判断时间[startTime, endTime]区间是否合法
     *
     * @param startTime
     * @param endTime
     *
     * @return
     */
    public static boolean isEffectiveLookDate(Date startTime, Date endTime) {
        return startTime.compareTo(endTime) <= 0;
    }
    
    /**
     * 是否过期
     *
     * @param dateTime
     *
     * @return
     */
    public static boolean isEffectiveLost(Date dateTime) {
        return dateTime.compareTo(new Date()) < 0;
    }
    
    /**
     * 是否当天
     *
     * @param dateTime
     *
     * @return
     */
    public static boolean isEffectiveToday(Date dateTime) {
        return true;
    }
    
    
    /**
     * 获取指定时间的年份
     *
     * @param date //指定时间
     *
     * @return
     */
    public static int getYear(Date date) {
        CAL.setTime(date);
        return CAL.get(Calendar.YEAR);
    }
    
    
    /**
     * 获取指定时间的月份
     *
     * @param date //指定时间
     *
     * @return
     */
    public static int getMonth(Date date) {
        CAL.setTime(date);
        return CAL.get(Calendar.MONTH) + 1;
    }
    
    
    /**
     * 获取指定时间的日期
     *
     * @param date //指定时间
     *
     * @return
     */
    public static int getDay(Date date) {
        CAL.setTime(date);
        return CAL.get(Calendar.DATE);
    }
    
    
    /**
     * 获取指定时间的小时
     *
     * @param date //指定时间
     *
     * @return
     */
    public static int getHour(Date date) {
        CAL.setTime(date);
        return CAL.get(Calendar.HOUR_OF_DAY);
    }
    
    
    /**
     * 获取指定时间的分钟
     *
     * @param date //指定时间
     *
     * @return
     */
    public static int getMinute(Date date) {
        CAL.setTime(date);
        return CAL.get(Calendar.MINUTE);
    }
    
    
    /**
     * 获取指定时间的秒钟
     *
     * @param date //指定时间
     *
     * @return
     */
    public static int getSecond(Date date) {
        CAL.setTime(date);
        return CAL.get(Calendar.SECOND);
    }
    
    /**
     * @Description: 获取当前时间
     * @Param:
     * @return:
     * @Author: dacl30868
     * @Date: 2020/6/29
     */
    public static Date getNowDate() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 获取给定时间的 年开始第一天
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getYearStartOf(LocalDateTime time) {
        return LocalDateTime.of(time.getYear(), 1, 1, 0, 0, 0, 0);
    }
    
}
