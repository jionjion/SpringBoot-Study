package top.jionjion.redisom.po;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

/**
 * 存入Redis中
 * 添加@Document注释即可，定义格式省去了自己做转换，Redis OM 库直观地将域对象 (domain objects) 保存在 Redis上。
 *
 * @author Jion
 */
@Document
public class Book {

    /**
     * 区分唯一主键
     */
    @Id
    private String id;

    /**
     * 全文检索
     */
    private String name;

    /**
     * 声明式检索
     */
    @Indexed
    private Set<String> tags = new HashSet<>();

    @Indexed
    private Integer number;

    private String url;

    private boolean enable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
