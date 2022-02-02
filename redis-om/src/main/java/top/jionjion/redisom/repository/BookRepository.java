package top.jionjion.redisom.repository;

import com.redis.om.spring.repository.RedisDocumentRepository;
import top.jionjion.redisom.po.Book;

/**
 * 简化 Redis 操作, 继承自 RedisDocumentRepository 并指明主键
 *
 * @author Jion
 */
public interface BookRepository extends RedisDocumentRepository<Book, String> {


}
