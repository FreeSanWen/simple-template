package cn.penguin.common.entity;

import cn.penguin.common.enums.HttpEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wensy
 * @since 2022-11-26 14:55
 */
@Data
@NoArgsConstructor
public class Reply<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String msg;

    private Integer code;

    private T data;

    private Reply(T t, HttpEnum httpEnum) {
        this.msg = httpEnum.getMsg();
        this.code = httpEnum.getCode();
        this.data = t;
    }

    private Reply(Throwable throwable, HttpEnum fail) {
        this.msg = throwable.getMessage();
        this.code = fail.getCode();
    }

    private Reply(HttpEnum httpEnum) {
        this.msg = httpEnum.getMsg();
        this.code = httpEnum.getCode();
    }

    public static <T> Reply<T> ok(T t) {
        return new Reply<T>(t, HttpEnum.SUCCESS);
    }

    public static Reply no(Throwable throwable) {
        return new Reply(throwable, HttpEnum.FAIL);
    }

    public static Reply no(HttpEnum httpEnum) {
        return new Reply(httpEnum);
    }
}
