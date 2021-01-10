package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * .@JsonInclude 注解使用
 *
 * @author Jion
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonIncludeAnnotation {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
