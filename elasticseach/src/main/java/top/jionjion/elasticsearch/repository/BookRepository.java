package top.jionjion.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.jionjion.elasticsearch.pojo.Food;

import java.util.List;

/**
 * 自定义查询
 *
 * @author Jion
 */
@SuppressWarnings("unused")
public interface BookRepository extends ElasticsearchRepository<Food, Long> {

    /**
     * 自定义查询, 通过标题查询
     *
     * @param title 标题
     * @return 查询结果
     */
    List<Food> findByTitle(String title);

    /**
     * 自定义查询, 查询区间内的
     *
     * @param price1 价格, 左区间
     * @param price2 价格, 右区间
     * @return 查询结果
     */
    List<Food> findByPriceBetween(Double price1, Double price2);
}