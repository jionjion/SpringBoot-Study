package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * .@JsonIgnore 注解使用
 *
 * @author Jion
 */
@SuppressWarnings("unused")
public class JsonIgnoreAnnotation {

    @JsonIgnore
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
