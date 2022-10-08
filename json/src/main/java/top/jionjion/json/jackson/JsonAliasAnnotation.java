package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.extern.slf4j.Slf4j;

/**
 * .@JsonAlias 类的测试
 *
 * @author Jion
 */
@Slf4j
@SuppressWarnings("unused")
public class JsonAliasAnnotation {

    private Integer id;

    @JsonAlias({"name", "username"})
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

    @Override
    public String toString() {
        return "JsonAliasAnnotation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
