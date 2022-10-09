package top.jionjion.core.life;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Bean的生命周期
 *
 * @author Jion
 */
@Data
@Component
@SuppressWarnings("unused")
public class People {

    private String name;
}
