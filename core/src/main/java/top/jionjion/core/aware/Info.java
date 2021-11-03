package top.jionjion.core.aware;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Jion
 */
@PropertySource(value = "classpath:aware/config.properties",encoding = "UTF-8")
@Component
@Data
public class Info {

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
