package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

/**
 * .@JsonAnyGetter 注解使用
 *
 * @author Jion
 */
public class JsonAnyGetterAnnotation {

    private final Map<String, String> info = new HashMap<>();

    /**
     * 会将Map中的属性作为同级进行序列化
     */
    @JsonAnyGetter
    public Map<String, String> getInfo() {
        return info;
    }

    private final Map<String, String> score = new HashMap<>();

    /**
     * 会将Map中的属性作为嵌套进行序列化
     */
    @JsonAnyGetter(enabled = false)
    public Map<String, String> getScore() {
        return score;
    }
}