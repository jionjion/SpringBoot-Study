package top.jionjion.elasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 创建pojo类与索引对应
 *
 * @author JionJion
 */
@Data
@Document(indexName = "food", shards = 1, replicas = 0)
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