package top.jionjion.elasticsearch.repository;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import top.jionjion.elasticsearch.pojo.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 测试
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
class BookRepositoryTest {

    /**
     * Elasticsearch 模板引擎
     */
    @Autowired
    ElasticsearchRestTemplate elasticsearchTemplate;

    /**
     * Food 增删改查
     */
    @Autowired
    BookRepository foodRepository;


    /**
     * 索引操作
     */
    @Test
    public void testIndex() {
        IndexOperations indexOperations = elasticsearchTemplate.indexOps(Food.class);
        indexOperations.create();
        indexOperations.putMapping();
        indexOperations.delete();
    }

    /**
     * 插入与更新
     */
    @Test
    public void testCreate() {
        Food food1 = new Food(1, "大米", "食品", 100D);
        Object save = this.foodRepository.save(food1);
        log.info("保存一个: {}", save);

        List<Food> list = new ArrayList<>();
        list.add(new Food(2, "小米", "食品", 200D));
        list.add(new Food(3, "黄豆", "食品", 300D));

        // 接收对象集合，实现批量新增
        Iterable<Food> foods = foodRepository.saveAll(list);
        log.info("保存全部: {}", foods);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete() {
        Food food = new Food(1, "大米", "食品", 100D);
        this.foodRepository.delete(food);

    }


    /**
     * 查询
     */
    @Test
    public void testFind() {
        System.out.println("-----主键查询------");
        Optional<Food> byId = this.foodRepository.findById(1L);
        System.out.println(byId.get());

        System.out.println("-----查询全部------");
        Iterable<Food> all = this.foodRepository.findAll();
        all.forEach(i -> System.out.println(i));

        System.out.println("-----排序查询(升序降序)------");
        Iterable<Food> price = this.foodRepository.findAll(Sort.by("price").descending());
        price.forEach(System.out::println);
    }

    /**
     * 调用自定义方法
     */
    @Test
    public void testFindByU() {
        List<Food> phone = this.foodRepository.findByTitle("食品");
        phone.forEach(i -> {
            System.out.println(i);
        });

        List<Food> byPriceBetween = this.foodRepository.findByPriceBetween(100.0, 300.0);
        byPriceBetween.forEach(i -> System.out.println(i));
    }

    /**
     * 批量插入
     */
    @Test
    public void indexList() {
        List<Food> list = new ArrayList<>();

        list.add(new Food(1, "大米", "食品", 100D));
        list.add(new Food(2, "小米", "食品", 200D));
        list.add(new Food(3, "黄豆", "食品", 300D));
        // 接收对象集合，实现批量新增
        foodRepository.saveAll(list);
    }

    /**
     * 高级查询
     */
    @Test
    public void testSearch() {
        //通过查询构建器工具构建--重点：QueryBuilders：词条、模糊、范围
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", "手机");
        //获取结果集
        Iterable<Food> Foods = this.foodRepository.search(queryBuilder);

        Foods.forEach(System.out::println);

    }

    /**
     * 重点--自定义查询
     */
    @Test
    public void testNative() {
        // 构建自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "手机"));
        // 查询分页结果集
        Page<Food> FoodPage = this.foodRepository.search(queryBuilder.build());
        System.out.println(FoodPage.getTotalPages());
        System.out.println(FoodPage.getTotalElements());
        FoodPage.forEach(i -> System.out.println(i));

    }

    /**
     * 重点--分页查询
     */
    @Test
    public void testPage() {
        // 构建自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("category", "手机"));
        queryBuilder.withPageable(PageRequest.of(1, 2));
        // 查询分页结果集
        Page<Food> FoodPage = this.foodRepository.search(queryBuilder.build());
        System.out.println(FoodPage.getTotalPages());
        System.out.println(FoodPage.getTotalElements());
        FoodPage.forEach(i -> System.out.println(i));

    }

    /**
     * 重点--排序
     */
    @Test
    public void testSort() {
        // 构建自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("category", "手机"));
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        // 查询分页结果集
        Page<Food> FoodPage = this.foodRepository.search(queryBuilder.build());
        System.out.println(FoodPage.getTotalPages());
        System.out.println(FoodPage.getTotalElements());
        FoodPage.forEach(i -> System.out.println(i));

    }
}