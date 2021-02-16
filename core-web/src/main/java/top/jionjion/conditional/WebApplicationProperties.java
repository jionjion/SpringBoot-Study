package top.jionjion.conditional;

import org.springframework.stereotype.Component;

/**
 * 使用自定义注解, 在特定环境下引入
 *
 * @author Jion
 */
@Component
@ConditionalOnWebApplication
public class WebApplicationProperties {

}
