package cn.penguin.common.web.annotation;


import cn.penguin.common.web.enums.BusinessModuleEnum;
import cn.penguin.common.web.enums.BusinessOperationEnum;

import java.lang.annotation.*;

/**
 * 简化版记录业务日志
 *
 * @author wensy
 * @since 2022/12/1 14:28
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface BusinessLog {

    /**
     * 关联的业务id，这里用SpEL表达式来取值，参考  bizId = "#entity.id"
     * entity指参数的名字，
     *
     * @return
     */
    String bizId();

    /**
     * 业务模块类型
     *
     * @return
     */
    BusinessModuleEnum module() ;

    /**
     * 执行操作类型
     *
     * @return
     */
    BusinessOperationEnum type() ;

}
