package cn.penguin.common.utils;


import cn.penguin.common.entity.SnowFlakeId;

/**
 * @author Wensy
 * @since 2022/11/24 15:34:00
 */
public class IdUtil {

    private static SnowFlakeId snowFlakeId = new SnowFlakeId();

    public static Long getId(){
        return snowFlakeId.nextId();
    }

    public static String getIdStr(){
        return snowFlakeId.nextId() + "";
    }

}
