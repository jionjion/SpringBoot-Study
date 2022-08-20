package top.jionjion.redisom.po;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

/**
 * 存入Redis中
 * 添加 @Document注释即可，定义格式省去了自己做转换，Redis OM 库直观地将域对象 (domain objects) 保存在 Redis上。
 * <p>
 * RedisSearch 是支持搜索的底层搜索引擎，支持 Text（全文搜索）、Tag（精确匹配搜索）、Numeric（范围查询）、Geo（地理范围查询）和 Vector（向量相似性查询）字段
 * 使用 @Indexed 添加到字段上, 会对其添加声明式索引.根据属性的数据类型选择适当的搜索字段
 * 使用 @Searchable 添加到字段上, 标识其为全文检索
 *
 * @author Jion
 */
@Data
@Document
public class Website {

    /**
     * 区分唯一主键
     */
    @Id
    @Indexed
    private String id;

    /**
     * 全文检索
     */
    @Searchable(nostem = true)
    private String name;

    /**
     * 声明式检索
     */
    @Indexed
    private Set<String> tags = new HashSet<>();

    @Indexed
    private Integer number;

    @Indexed
    private String url;

    private boolean enable;

}
