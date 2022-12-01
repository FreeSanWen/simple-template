package cn.penguin.common.annotation;

import cn.penguin.common.enums.BusinessModuleEnum;
import cn.penguin.common.enums.BusinessOperationEnum;

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
     * entity指参数的名字，如果是新增的话，会取出参，其他情况取入参
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
