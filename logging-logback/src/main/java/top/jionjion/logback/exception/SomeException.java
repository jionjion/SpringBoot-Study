package top.jionjion.logback.exception;

/**
 * 自定义运行时异常
 *
 * @author Jion
 */
public class SomeException extends RuntimeException {

    public SomeException(String message) {
        super(message);
    }
}
