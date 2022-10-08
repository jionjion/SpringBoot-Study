package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * .@JsonIgnoreProperties 注解使用
 *
 * @author Jion
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(value = {"id", "address"})
public class JsonIgnorePropertiesAnnotation {

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

    @Override
    public String toString() {
        return "JsonIgnorePropertiesAnnotation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
