package cn.penguin.common.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wensy
 * @since 2022/12/5 13:55
 */
@Slf4j
//@Component
public class JdbcListenerConfig {

//    @EventListener
//    public void setIdBeforeSave(BeforeSaveEvent<BaseEntity> event) {
//        log.info("{}设置id", LogbackConstant.LOG_PREFIX);
//        BaseEntity entity = event.getEntity();
//        if (Objects.nonNull(entity) && Objects.isNull(entity.getId())) {
//            entity.setId(IdUtil.getId());
//        }
//    }


//    public ApplicationListener<BeforeSaveEvent<User>> setIdBeforeSave(){
//        return event -> {
//            BaseEntity entity = event.getEntity();
//            if (Objects.nonNull(entity) && Objects.isNull(entity.getId())) {
//                entity.setId(IdUtil.getId());
//            }
//        };
//    }

}
