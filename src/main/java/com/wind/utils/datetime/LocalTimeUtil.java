package com.wind.utils.datetime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author hsc
 */
public class LocalTimeUtil {

    private static final String STANDARD_24_FORMAT = "HH:mm:ss";

    private static final DateTimeFormatter DF_STANDARD_24_FORMAT = DateTimeFormatter.ofPattern(STANDARD_24_FORMAT);

    private static final String STANDARD_12_FORMAT = "hh:mm:ss";

    private static final DateTimeFormatter DF_STANDARD_12_FORMAT = DateTimeFormatter.ofPattern(STANDARD_12_FORMAT);

    /**
     * @param time   时间
     * @param format 格式
     * @return LocalDateTime
     */
    public static LocalTime toLocalTime(String time, DateTimeFormatter format) {
        return LocalTime.parse(time, format);
    }

    /**
     * @param time   时间
     * @param format 格式
     * @return LocalDateTime
     */
    public static LocalTime toLocalTime(String time, String format) {
        return toLocalTime(time, DateTimeFormatter.ofPattern(format));
    }

    /**
     * @param time 时间 HH:mm:ss
     * @return LocalDateTime
     */
    public static LocalTime toLocalTime(String time) {
        return toLocalTime(time, STANDARD_24_FORMAT);
    }


    /**
     * 时间格式化
     *
     * @param time 时间
     * @param df   dateTimeFormatter
     * @return string
     */
    public static String format(LocalTime time, DateTimeFormatter df) {
        return time.format(df);
    }

    /**
     * 时间格式化
     *
     * @param time   时间
     * @param format 格式
     * @return string
     */
    public static String format(LocalTime time, String format) {
        return format(time, DateTimeFormatter.ofPattern(format));
    }

    /**
     * 时间格式化
     *
     * @param dateTime 时间
     * @param format   格式
     * @return string
     */
    public static String format(LocalDateTime dateTime, String format) {
        return format(dateTime.toLocalTime(), DateTimeFormatter.ofPattern(format));
    }

    /**
     * 时间格式化为yyyy-MM-dd HH:ss:mm
     *
     * @param time 时间
     * @return string
     */
    public static String format(LocalTime time) {
        return format(time, STANDARD_24_FORMAT);
    }
}
