package cn.penguin.common.config;

import cn.penguin.common.constant.LogbackConstant;
import cn.penguin.common.entity.BaseEntity;
import cn.penguin.common.utils.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author wensy
 * @since 2022/12/5 13:55
 */
@Slf4j
@Component
public class JdbcListenerConfig {

    @EventListener
    public void setIdBeforeSave(BeforeSaveEvent<BaseEntity> event) {
        log.info("{}设置id", LogbackConstant.LOG_PREFIX);
        BaseEntity entity = event.getEntity();
        if (Objects.nonNull(entity) && Objects.isNull(entity.getId())) {
            entity.setId(IdUtil.getId());
        }
    }


//    public ApplicationListener<BeforeSaveEvent<User>> setIdBeforeSave(){
//        return event -> {
//            BaseEntity entity = event.getEntity();
//            if (Objects.nonNull(entity) && Objects.isNull(entity.getId())) {
//                entity.setId(IdUtil.getId());
//            }
//        };
//    }

}
