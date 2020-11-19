package top.jionjion.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * 自定义注解使用, 在特定环境下引入
 *
 * @author Jion
 */
@Component
@ConditionalOnWebApplication
public class WebApplicationProperties {


}
