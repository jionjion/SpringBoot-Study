package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * .@JsonAutoDetect 注解使用
 *
 * @author Jion
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JsonAutoDetectAnnotation {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
