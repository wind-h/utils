package com.wind.utils.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author hsc
 * @date 2022/4/27 10:37
 */
public class LocalDateTimeUtil {

    private static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter DF_STANDARD_FORMAT = DateTimeFormatter.ofPattern(STANDARD_FORMAT);

    // String -> LocalDateTime

    /**
     * @param dateTime 时间
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(String dateTime, DateTimeFormatter format) {
        return LocalDateTime.parse(dateTime, format);
    }

    /**
     * @param dateTime 时间
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(String dateTime, String format) {
        return toLocalDateTime(dateTime, DateTimeFormatter.ofPattern(format));
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss 格式的时间转换为LocalDateTime;
     *
     * @param dateTime yyyy-MM-dd HH:mm:ss格式的时间
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(String dateTime) {
        return toLocalDateTime(dateTime, DF_STANDARD_FORMAT);
    }

    // LocalDateTime -> String

    /**
     * 时间格式化
     *
     * @param dateTime 时间
     * @param df       dateTimeFormatter
     * @return string
     */
    public static String format(LocalDateTime dateTime, DateTimeFormatter df) {
        return dateTime.format(df);
    }

    /**
     * 时间格式化
     *
     * @param dateTime 时间
     * @param format   格式
     * @return string
     */
    public static String format(LocalDateTime dateTime, String format) {
        return format(dateTime, DateTimeFormatter.ofPattern(format));
    }

    /**
     * 时间格式化为yyyy-MM-dd HH:ss:mm
     *
     * @param dateTime 时间
     * @return string
     */
    public static String format(LocalDateTime dateTime) {
        return format(dateTime, STANDARD_FORMAT);
    }

    // 时间间隔

    /**
     * 获取两个时间相差的时间量
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 时间量
     */
    public static Duration between(LocalDateTime startTime, LocalDateTime endTime) {
        return Duration.between(startTime, endTime);
    }

    /**
     * 获取两个时间相差的毫秒数（绝对值）
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 相差的秒数
     */
    public static Long getMillisBetween(LocalDateTime startTime, LocalDateTime endTime) {
        return Math.abs(between(startTime, endTime).toMillis());
    }

    // 获取某个月的天数

    /**
     * 获取某年某月的天数
     *
     * @param year  年
     * @param month 月
     * @return 天数
     */
    public static int getDaysOfMonth(int year, int month) {
        LocalDate now = LocalDate.of(year, month, 1).plusMonths(1).minusDays(1);
        return now.getDayOfMonth();
    }

    /**
     * 获取今年某月的天数
     *
     * @param month 月
     * @return 天数
     */
    public static int getDaysOfMonth(int month) {
        return getDaysOfMonth(LocalDate.now().getYear(), month);
    }

    // 获取某一天

    /**
     * 获取某天的开始时间
     *
     * @param dateTime 时间
     * @return 某天的开始时间
     */
    public static LocalDateTime getStartOfDay(LocalDateTime dateTime) {
        return dateTime.with(LocalTime.MIN);
    }

    /**
     * 获取某天的结束时间
     *
     * @param dateTime 时间
     * @return 某天的结束时间
     */
    public static LocalDateTime getEndOfDay(LocalDateTime dateTime) {
        return dateTime.with(LocalTime.MAX);
    }

    /**
     * 获取某天所在月开始时间
     *
     * @param dateTime 时间
     * @return 某天所在月开始时间
     */
    public static LocalDateTime getStartOfMonth(LocalDateTime dateTime) {
        return LocalDateTime.of(LocalDate.of(dateTime.getYear(), dateTime.getMonthValue(), 1), LocalTime.MIN);
    }

    /**
     * 获取某天所在月结束时间
     *
     * @param dateTime 时间
     * @return 某天所在月结束时间
     */
    public static LocalDateTime getEndOfMonth(LocalDateTime dateTime) {
        return LocalDateTime.of(LocalDate.of(dateTime.getYear(), dateTime.getMonthValue(), getDaysOfMonth(dateTime.getYear(), dateTime.getMonthValue())), LocalTime.MAX);
    }

    /**
     * 获取某天所在年开始时间
     *
     * @param dateTime 时间
     * @return 某天所在年开始时间
     */
    public static LocalDateTime getStartOfYear(LocalDateTime dateTime) {
        return LocalDateTime.of(LocalDate.of(dateTime.getYear(), 1, 1), LocalTime.MIN);
    }

    /**
     * 获取某天所在年结束时间
     *
     * @param dateTime 时间
     * @return 某天所在年结束时间
     */
    public static LocalDateTime getEndOfYear(LocalDateTime dateTime) {
        return LocalDateTime.of(LocalDate.of(dateTime.getYear(), 12, getDaysOfMonth(12)), LocalTime.MAX);
    }
}
