package cn.penguin.common.core.exception;

/**
 * @author wensy
 * @since 2022-11-26 14:55
 */
public class BizException extends RuntimeException {

    public BizException(String format) {
        super(format);
    }

    public BizException(Throwable throwable) {
        super(throwable);
    }

    public BizException(String format, Throwable t) {
        super(format,t);
    }
}
