package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * .@JsonAnySetter 类的测试
 *
 * @author Jion
 */
@SuppressWarnings("unused")
public class JsonAnySetterAnnotation {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Map<String, String> info = new HashMap<>();

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    /**
     * 会将Map中的属性作为同级进行反序列化
     */
    @JsonAnySetter
    public void addInfo(String key, String value) {
        info.put(key, value);
    }

    private Map<String, String> score = new HashMap<>();


    public void setScore(Map<String, String> score) {
        this.score = score;
    }

    /**
     * 会将Map中的属性作为嵌套进行反序列化
     */
    @JsonAnySetter(enabled = false)
    public void addScore(String key, String value) {
        score.put(key, value);
    }

    public Map<String, String> getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "JsonAnySetterAnnotation{" +
                "name='" + name + '\'' +
                ", info=" + info +
                ", score=" + score +
                '}';
    }
}
