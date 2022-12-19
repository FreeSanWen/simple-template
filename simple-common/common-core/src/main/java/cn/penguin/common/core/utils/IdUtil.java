package cn.penguin.common.core.utils;


import cn.penguin.common.core.toolkit.SnowFlakeId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.function.ToDoubleBiFunction;

/**
 * @author Wensy
 * @since 2022/11/24 15:34:00
 */
@Component
public class IdUtil {

    @Value("${project.worker-id:}")
    private Integer workerId;

    @Value("${project.data-center-id:}")
    private Integer dataCenterId;

    private static SnowFlakeId snowFlakeId;

    @PostConstruct
    public void set(){
        // TODO: 2022/12/19 这里应该利用机器的 ip 或者其他唯一标识来做一定运算自动获得两个数据
        if (Objects.isNull(workerId)) {
            snowFlakeId = new SnowFlakeId();
        }else{
            snowFlakeId = new SnowFlakeId(workerId, dataCenterId);
        }
    }

    public static Long nextId(){
        return snowFlakeId.nextId();
    }

    public static String getIdStr(){
        return snowFlakeId.nextId() + "";
    }

}
