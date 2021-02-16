package top.jionjion.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * 使用 @ConditionalOnProperty 在某个属性下存在时该类被注入到容器中
 *
 * @author Jion
 */
@Component
@ConditionalOnProperty("spring.profiles.active")
public class ActiveProperties {

}
