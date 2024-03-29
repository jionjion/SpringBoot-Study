package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * .@JsonUnwrapped 注解使用
 *
 * @author Jion
 */
@SuppressWarnings("unused")
public class JsonUnwrappedAnnotation {

    /**
     * 内部类
     */
    public static class Student {

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

        @JsonUnwrapped
        private Info info;

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }
    }

    public static class Info {

        String address;

        String postcode;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public Info(String address, String postcode) {
            this.address = address;
            this.postcode = postcode;
        }
    }
}
