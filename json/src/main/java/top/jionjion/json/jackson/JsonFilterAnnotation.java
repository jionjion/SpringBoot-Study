package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * .@JsonFilter 注解使用
 *
 * @author Jion
 */
@JsonFilter("jsonFilter")
@SuppressWarnings("unused")
@JsonView(Views.Hide.class)
public class JsonFilterAnnotation {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(Views.Show.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}