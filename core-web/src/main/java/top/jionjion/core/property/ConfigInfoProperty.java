package top.jionjion.core.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 属性配置类.
 *
 * @author Jion
 */
@Data
@Component
@PropertySource(value = "classpath:properties/config.properties", encoding = "UTF-8")
public class ConfigInfoProperty {

    @Value("${info.version}")
    private String version;

    @Value("${info.author}")
    private String author;

    @Value("#{'${info.array}'.split(',')}")
    private String[] array;

    @Value("#{'${info.list}'.split(',')}")
    private List<String> list;

    @Value("#{${info.map}}")
    private Map<String, String> map;
}
