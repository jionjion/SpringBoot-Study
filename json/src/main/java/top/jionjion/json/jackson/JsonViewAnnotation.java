package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * .@JsonView 注解使用
 *
 * @author Jion
 */
public class JsonViewAnnotation {

    @JsonView(Views.Hide.class)
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

/**
 * 视图类,是否显示隐藏
 */
class Views {
    public static class Show {

    }

    public static class Hide {

    }
}