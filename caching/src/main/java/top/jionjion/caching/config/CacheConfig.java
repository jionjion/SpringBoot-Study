package top.jionjion.caching.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

/**
 * 自定义 Spring-Cache 的配置
 *
 * @author Jion
 */
@Component
@SuppressWarnings("EmptyMethod")
public class CacheConfig extends CachingConfigurerSupport {


    public CacheConfig() {
        super();
    }

    @Override
    public CacheManager cacheManager() {
        return super.cacheManager();
    }

    @Override
    public CacheResolver cacheResolver() {
        return super.cacheResolver();
    }

    @Override
    public KeyGenerator keyGenerator() {
        return super.keyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return super.errorHandler();
    }
}