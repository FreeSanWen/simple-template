package cn.penguin.common.utils;

import cn.penguin.common.constant.DateConstant;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author wensy
 * @since 2022-11-26 14:55
 */
public class LocalDateUtil {

    /**
     * 将时间转换成毫秒数
     *
     * @param time
     * @return
     */
    public static Long milliSecond(String time){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(time, df);
        return dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 获取当前时间的毫秒数
     *
     * @return
     */
    public static Long now(){
        return milliSecond(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateConstant.TIME_FORMAT)));
    }
}
