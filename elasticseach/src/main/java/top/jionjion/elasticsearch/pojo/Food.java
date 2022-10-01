package top.jionjion.elasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

/**
 * 创建pojo类与索引对应
 *
 * @author JionJion
 */
@Data
@Setting(shards = 2, replicas = 0)
@Document(indexName = "food")
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;

    /**
     * 分类
     */
    @Field(type = FieldType.Keyword)
    private String category;

    /**
     * 价格
     */
    @Field(type = FieldType.Double)
    private Double price;

}