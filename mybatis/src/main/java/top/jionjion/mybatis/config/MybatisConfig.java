package top.jionjion.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *  Mybatis 的配置文件
 *
 * @author Jion
 */
@Configuration
@MapperScan(basePackages = "top.jionjion.mybatis.mapper")
public class MybatisConfig {

}
