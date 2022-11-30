package cn.penguin.common.annotation;

import java.lang.annotation.*;

/**
 * @author wensy
 * @since 2022-11-29 09:35
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

}
