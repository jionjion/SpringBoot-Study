package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * .@JsonFilter 注解使用
 *
 * @author Jion
 */
@JsonFilter("jsonFilter")
@JsonView(Views.hide.class)
public class JsonFilterAnnotation {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(Views.show.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}