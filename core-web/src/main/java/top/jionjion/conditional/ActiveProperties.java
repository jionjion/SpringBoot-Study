package top.jionjion.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * 在某个属性下存在时生效
 *
 * @author Jion
 */
@Component
@ConditionalOnProperty("spring.profiles.active")
public class ActiveProperties {

}
