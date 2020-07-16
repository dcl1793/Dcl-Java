package hs.dcl.test.util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
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

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //LocalDateTime -->String
    public static String dateFormat(LocalDateTime localDateTime) {
        String format = DATE_TIME_FORMATTER.format(localDateTime);
        return  format;
    }

    //LocalDateTime -->String
    public static String dateFormatShort(LocalDateTime localDateTime) {
        String format = DATE_FORMAT.format(localDateTime);
        return  format;
    }


    // 01. java.util.Date --> java.time.LocalDateTime
    public static void DateToLocalDateTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    }

    // 02. java.util.Date --> java.time.LocalDate
    public static void DateToLocalDate() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    public static LocalTime DateToLocalTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalTime();
    }

    // 04. java.time.LocalDateTime --> java.util.Date
    public static Date LocalDateTimeToDate(LocalDateTime localDateTime ) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public static Date LocalDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public static Date LocalTimeToDate(LocalDate localDate, LocalTime localTime) {
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return  Date.from(instant);
    }
}
