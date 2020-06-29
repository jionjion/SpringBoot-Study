package top.jionjion.aware;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *  获得容器的环境变量信息
 * @author Jion
 */
@Component
public class WebApplicationEnvironmentAware implements EnvironmentAware {

    /** 环境变量 */
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /** 通过环境变量获得 */
    public void getOne(){
        String property = this.environment.getProperty("user");
        System.out.println("获得环境变量" + property);
    }
}
