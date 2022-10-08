package top.jionjion.redisom.repository;

import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Component;
import top.jionjion.redisom.po.Website;

/**
 * 简化 Redis 操作, 继承自 RedisDocumentRepository 并指明主键
 *
 * @author Jion
 */
@Component
public interface WebsiteCrudRepository extends RedisDocumentRepository<Website, String> {

}