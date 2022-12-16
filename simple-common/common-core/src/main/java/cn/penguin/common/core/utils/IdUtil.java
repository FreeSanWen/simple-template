package cn.penguin.common.core.utils;


import cn.penguin.common.core.toolkit.SnowFlakeId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Wensy
 * @since 2022/11/24 15:34:00
 */
@Component
public class IdUtil {

    @Value("${project.worker-id:1}")
    private int workerId;

    @Value("${project.data-center-id:1}")
    private int dataCenterId;

    private static int wId;
    private static int dId;

    @PostConstruct
    public void set(){
        wId = this.workerId;
        dId = this.dataCenterId;
    }

    private static SnowFlakeId snowFlakeId = new SnowFlakeId();

    public static Long nextId(){
        return snowFlakeId.nextId();
    }

    public static String getIdStr(){
        return snowFlakeId.nextId() + "";
    }

}
