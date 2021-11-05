package top.jionjion.web.except;

import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 自定异常处理
 *
 * @author Jion
 */
public class WebApplicationExceptionReporter implements SpringBootExceptionReporter {

    /**
     * Spring 上下文
     */
    private final ConfigurableApplicationContext context;

    WebApplicationExceptionReporter(ConfigurableApplicationContext context) {
        // 有参构造器,必须有.在容器启动时反射创建实例
        this.context = context;
    }

    @Override
    public boolean reportException(Throwable failure) {
        if (failure instanceof RuntimeException) {
            System.out.println("容器启动失败...");
            System.out.println(context.toString());
        }
        // 如果返回 true 不会进行处理后续异常报告
        return false;
    }
}
