package top.jionjion.plus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 配置类,配置Mybatis-Plus的信息
 * <li>开启配置</li>
 * <li>开启事物管理</li>
 * <li>制定 Mapper 文件的路径</li>
 * <li>注入各种组件拦截器</li>
 *
 * @author jion
 */
@Configuration
@EnableTransactionManagement
@MapperScan("top.jionjion.mapper")
public class PlusConfig {

    /**
     * 注册组件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 注册乐观锁组件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 注册分页组件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
