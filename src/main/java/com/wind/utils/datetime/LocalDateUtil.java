package com.wind.utils.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author hsc
 * @date 2022/5/10 17:58
 */
public class LocalDateUtil {

    private static final String STANDARD_FORMAT = "yyyy-MM-dd";

    private static final DateTimeFormatter DF_STANDARD_FORMAT = DateTimeFormatter.ofPattern(STANDARD_FORMAT);

    // String -> LocalDate

    /**
     * @param date   时间
     * @param format 格式
     * @return LocalDateTime
     */
    public static LocalDate toLocalDate(String date, DateTimeFormatter format) {
        return LocalDate.parse(date, format);
    }

    /**
     * @param date   时间
     * @param format 格式
     * @return LocalDateTime
     */
    public static LocalDate toLocalDate(String date, String format) {
        return toLocalDate(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * @param date 时间 HH:mm:ss
     * @return LocalDateTime
     */
    public static LocalDate toLocalDate(String date) {
        return toLocalDate(date, DF_STANDARD_FORMAT);
    }

    // LocalDate -> String

    /**
     * 格式化日期
     *
     * @param date 日期
     * @param df   dateTimeFormatter
     * @return string
     */
    public static String format(LocalDate date, DateTimeFormatter df) {
        return date.format(df);
    }

    /**
     * 格式化日期
     *
     * @param date   日期
     * @param format 格式
     * @return string
     */
    public static String format(LocalDate date, String format) {
        return format(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * 格式化日期为yyyy-MM-dd
     *
     * @param date 日期
     * @return string
     */
    public static String format(LocalDate date) {
        return format(date, STANDARD_FORMAT);
    }

    // 时间间隔

    /**
     * 获取两个日期相差的秒数（绝对值）
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 相差的秒数
     */
    public static Long getMillisBetween(LocalDate startDate, LocalDate endDate) {
        return Math.abs(Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay()).toMillis());
    }

    /**
     * 获取两个日期相差的天数（绝对值）
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 相差的天数
     */
    public static Long getDaysBetween(LocalDate startDate, LocalDate endDate) {
        return getMillisBetween(startDate, endDate) / 1000 / 60 / 60 / 24;
    }
}
